package com.library.ApiRestLibrary.Services.Impl;

import com.library.ApiRestLibrary.Entity.Inventary;
import com.library.ApiRestLibrary.Repositories.InventaryRepository;
import com.library.ApiRestLibrary.Services.FileService;
import com.library.ApiRestLibrary.Services.InventaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventaryServiceImpl implements InventaryService {

    @Autowired
    private InventaryRepository inventaryRepository;

    @Autowired
    private FileService fileService;

    @Override
    public List<Inventary> getAllInventaries() {
        return inventaryRepository.findAll();
    }

    @Override
    public Inventary getInventaryById(long id) {
        return inventaryRepository.findById(id).orElse(null);
    }

    @Override
    public UrlResource getFileByInventary(String name) {
        try {
            return fileService.getFile(name);
        } catch (Exception e) {
            throw new RuntimeException("can not get file by name: " + e.getMessage());
        }
    }

    @Override
    public Inventary createInventary(Inventary inventary) {
        try {
            if (inventary.getFile() == null) {
                throw new RuntimeException("file image is null");
            }

            validatedInventary(inventary);
            inventary.setImg(fileService.UploadFile(inventary.getFile()));
            inventary.setFile(null);
            return inventaryRepository.save(inventary);
        } catch (Exception e) {
            throw new RuntimeException("can not create inventary: " + e.getMessage());
        }
    }

    @Override
    public Inventary updateInventary(Inventary inventary, long id) {
        try {
            validatedInventary(inventary);
            Inventary response = getInventaryById(id);

            if (inventary.getFile() != null) {
                if (response.getImg() != null) fileService.deleteFile(response.getImg());
                final String fileName = fileService.UploadFile(inventary.getFile());
                response.setImg(fileName);
            }

            response.setName(inventary.getName());
            response.setAuthor(inventary.getAuthor());
            response.setCreate_at(inventary.getCreate_at());
            return inventaryRepository.save(response);
        } catch (Exception e) {
            throw new RuntimeException("can not update inventary: " + e.getMessage());
        }
    }

    @Override
    public Boolean deleteInventary(long id) {
        try{
            Inventary inventary = getInventaryById(id);
            validatedInventary(inventary);
            if (inventary.getImg() != null) fileService.deleteFile(inventary.getImg());
            inventaryRepository.delete(inventary);
            return true;
        }catch (Exception e){
            throw new RuntimeException("can not delete inventary: " + e.getMessage());
        }
    }

    private void validatedInventary(Inventary inventary) {
        if (inventary.getName() == null) {
            throw new RuntimeException("name is null");
        }

        if (inventary.getAuthor() == null) {
            throw new RuntimeException("author is null");
        }

        if (inventary.getCreate_at() == null) {
            throw new RuntimeException("create_at is null");
        }
    }
}
