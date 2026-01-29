package com.example.SecurityDemo.jwt;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${spring.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    @Value("${spring.app.secretKey}")
    private String secretKey;
    //adding logger
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    //getting Jwt header from http request
    public String getJwtFromRequest(HttpServletRequest request){
        String bearerRequest = request.getHeader("Authorization");
        logger.debug("Authorization Header: {} " , bearerRequest);
        if(bearerRequest!=null && bearerRequest.startsWith("Bearer ")){
            String token = bearerRequest.substring(7);
            return token ;
        }
        // now extracting token only as Authorization Header have "Bearer <> "
        // here  , we just want <>.
        return null;

    }

    // method for generating token form user name
    public String generateTokenFromUserName(UserDetails userDetails){
        String userName = userDetails.getUsername();
        return Jwts.builder().subject(userName).
                issuedAt(new Date()).
                expiration(new Date(new Date().getTime() + jwtExpirationMs)).
                signWith(key()).
                compact();
    }
    //getting userName from Token
    public String  UserNameFromJwtToken(String token){
        return Jwts.parser().
                verifyWith((SecretKey) key()).build().
                parseSignedClaims(token).
                getPayload().getSubject();
    }
    //generating key
    /*
    steps involve  :

    1) select algo for key generation
    2) select decoder
    3) put a secret key  in the argument
     */
    public Key key(){
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(secretKey));
    }
    // validate jwt token
    public boolean validateToken(String authToken){
         /*
         we could potentially find exception here , so i will make use of try and catch block
          */
        try{
            System.out.println("Validate");
            Jwts.parser().verifyWith((SecretKey) key()).build().parseSignedClaims(authToken);
            return true;
        }catch(MalformedJwtException e){
            logger.error("Jwt token is malformed : {}"  , e.getMessage());
        }catch(ExpiredJwtException e){
            logger.error("Jwt token is expired : {}" , e.getMessage());
        }catch(UnsupportedJwtException e){
            logger.error("Invalid Jwt token : {} " , e.getMessage());
        }catch(IllegalArgumentException e){
            logger.error("Unsupported Jwt token : {}" , e.getMessage());
        }
        return false;
    }
}
