package com.library.ApiRestLibrary.Services.Impl;

import com.library.ApiRestLibrary.Services.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Value("${media.location}")
    private String mediaLocation;

    @Override
    public String UploadFile(MultipartFile file) throws Exception {
        try {
            String fileName = UUID.randomUUID().toString();
            byte[] bytes = file.getBytes();
            String fileOriginalName = file.getOriginalFilename();
            long fileSize = file.getSize();
            long maxFileSize = 5 * 1024 * 1024;

            if (fileSize > maxFileSize) {
                return "File size must be less then or equal to 5MB";
            }

            if (!fileOriginalName.endsWith(".jpg") && !fileOriginalName.endsWith(".jpeg") && !fileOriginalName.endsWith(".png")) {
                return "only JPG, JPEG and PNG files are supported";
            }

            //extraemos el nombre del archivo y ademas le concatenamos el id unico creado para ese archivo
            String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
            String newFileName = fileName + fileExtension;

            //crear carpeta donde se van a guardar los archivos
            File folder = new File(mediaLocation);

            if (!folder.exists()) {
                folder.mkdir();
            }

            //se guarda los datos en la carpeta
            Path path = Paths.get(mediaLocation + "/" + newFileName);
            Files.write(path, bytes);

            return "file uploaded successfully";
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public UrlResource getFile(String filename) throws Exception {
        try {
            Path file = Paths.get(mediaLocation + "/" + filename);
            UrlResource resource = new UrlResource(file.toUri());

            if (!resource.exists() || !resource.isReadable()) {
                throw new RuntimeException(filename);
            }

            return resource;
        } catch (RuntimeException e) {
            throw new RuntimeException("could not read file " + filename);
        }
    }

    @Override
    public boolean deleteFile(String filename) throws Exception {
        try {
            Path file = Paths.get(mediaLocation + "/" + filename);
            File fileToDelete = file.toFile();

            if (fileToDelete.exists() && fileToDelete.isFile()) {
                return fileToDelete.delete();
            } else {
                throw new RuntimeException("File not found: " + filename);
            }
        } catch (Exception e) {
            throw new Exception("Error deleting file: " + filename, e);
        }
    }
}
