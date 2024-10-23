package com.library.ApiRestLibrary.Services.Impl;

import com.library.ApiRestLibrary.Entity.Inventary;
import com.library.ApiRestLibrary.Repositories.InventaryRepository;
import com.library.ApiRestLibrary.Services.FileService;
import com.library.ApiRestLibrary.Services.InventaryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Inventary createInventary(Inventary inventary) {
        
        return null;
    }

    @Override
    public Inventary updateInventary(Inventary inventary, long id) {
        return null;
    }

    @Override
    public Boolean deleteInventary(long id) {
        try{
            Inventary inventary = getInventaryById(id);
            fileService.deleteFile(inventary.getImg());
            inventaryRepository.delete(inventary);
            return true;
        }catch (Exception e){
            throw new RuntimeException("can not delete inventary: " + e.getMessage());
        }
    }
}
