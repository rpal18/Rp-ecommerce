Issue: DELETE Request returns 401 Unauthorized despite valid token
The Symptom: When testing a @DeleteMapping endpoint in Postman with a valid JWT token, the server returned a 401 Unauthorized error from Spring Security instead of executing the delete or showing a proper error message.

The Root Cause (The Chain Reaction):
This was a case of an actual database error being masked by Spring Security.

The Crash: My custom @Query to delete a cart item was missing the @Modifying annotation. Hibernate assumed it was a SELECT query and crashed (IllegalSelectQueryException).

The Internal Redirect: Spring Boot caught the crash and internally redirected the request to the /error endpoint to generate a JSON error message.

The Security Block: Spring Security intercepted the internal redirect to /error. Since /error was not explicitly permitted in the security configuration, the AuthEntryPoint blocked it and returned a misleading 401 Unauthorized.

The Solution:
Two separate fixes were required:

1. Fix the Database Query:
   Tell Spring Data JPA that the custom query modifies the database by adding @Modifying and @Transactional.

Java

// In CartItemRepository.java
@Modifying
@Transactional
@Query("DELETE From CartItem ci WHERE ci.cart.id = ?1 AND ci.product.id = ?2")
void deleteCartItemByProductIdAndCartId(Long cartId, Long productId);
2. Stop Security from Masking 500 Errors:
   Explicitly permit access to the /error endpoint so Spring Boot can return actual crash logs to the client instead of authentication errors.

Java

// In SecurityConfig.java (SecurityFilterChain)
http.authorizeHttpRequests(auth -> auth
// ... other rules ...
.requestMatchers("/error").permitAll() // Add this!
.anyRequest().authenticated()
);