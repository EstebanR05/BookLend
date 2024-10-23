package com.library.ApiRestLibrary.Services.Impl;

import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileMultipart implements MultipartFile {

    private final Path filePath;
    private final UrlResource resource;

    public FileMultipart(Path filePath) throws IOException {
        this.filePath = filePath;
        this.resource = new UrlResource(filePath.toUri());
    }

    @Override
    public String getName() {
        return filePath.getFileName().toString();
    }

    @Override
    public String getOriginalFilename() {
        return filePath.getFileName().toString();
    }

    @Override
    public String getContentType() {
        try {
            return Files.probeContentType(filePath);
        } catch (IOException e) {
            return "application/octet-stream";
        }
    }

    @Override
    public boolean isEmpty() {
        return filePath.toFile().length() == 0;
    }

    @Override
    public long getSize() {
        return filePath.toFile().length();
    }

    @Override
    public byte[] getBytes() throws IOException {
        return Files.readAllBytes(filePath);
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return Files.newInputStream(filePath);
    }

    @Override
    public void transferTo(File dest) throws IOException, IllegalStateException {
        Files.copy(this.filePath, dest.toPath());
    }
}
