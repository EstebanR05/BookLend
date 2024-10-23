package com.library.ApiRestLibrary.Services;

import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FileService {
    String UploadFile(MultipartFile file) throws Exception;

    MultipartFile getFile(String filename) throws Exception;

    boolean deleteFile(String filename) throws Exception;
}
