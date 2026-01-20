package com.ecommerce.Rp_ecommerce.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    String uploadNewImage(String path, MultipartFile file) throws IOException ;
}
