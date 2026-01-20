package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.exception.ApiException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{
    //allowed extension
    private static final List<String> ALLOWED_EXTENSION = Arrays.asList("jpg" , "jpeg" , "png");

    public String uploadNewImage(String path, MultipartFile file) throws IOException {

        String originalFileName = file.getOriginalFilename();
        String randomId = UUID.randomUUID().toString();
        String ext = originalFileName.substring(originalFileName.lastIndexOf('.'));
        String newFileName = randomId  + ext;
        File folder = new File(path);
        if (!folder.exists()) {
            folder.mkdirs();
        }
       Files.copy(file.getInputStream(), Paths.get( path ,newFileName));
        return newFileName;
    }

    // validation logic
    private void validateFile(MultipartFile file) throws IOException{
        if(file.isEmpty()){
            throw new ApiException("file should not be empty");
        }
        String fileName = file.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
        if(!ALLOWED_EXTENSION.contains(extension)){
            throw new ApiException("upload a valid file");
        }

        // checking file type( content type aka mime(label))
        String contentType = file.getContentType();
        if(contentType==null || !contentType.startsWith("image/")){
            throw new ApiException("file must be an image");
        }

    }

}
