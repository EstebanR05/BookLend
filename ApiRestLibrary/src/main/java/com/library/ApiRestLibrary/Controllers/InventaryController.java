package com.library.ApiRestLibrary.Controllers;

import com.library.ApiRestLibrary.Entity.Inventary;
import com.library.ApiRestLibrary.Services.InventaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/inventary")
public class InventaryController {

    @Autowired
    private InventaryService inventaryService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Inventary>> getAllInventary() {
        try {
            List<Inventary> inventaries = inventaryService.getAllInventaries();
            return new ResponseEntity<>(inventaries, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Inventary> getByIdInventary(@PathVariable long id) {
        try {
            Inventary inventary = inventaryService.getInventaryById(id);
            return (inventary != null) ? new ResponseEntity<>(inventary, HttpStatus.OK) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Inventary> createInventary(@ModelAttribute Inventary inventary) {
        try {
            Inventary response = inventaryService.createInventary(inventary);
            return (response != null) ? new ResponseEntity<>(response, HttpStatus.OK) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Inventary> updateInventary(@PathVariable long id, @ModelAttribute Inventary inventary) {
        try {
            Inventary response = inventaryService.updateInventary(inventary, id);
            return (response != null) ? new ResponseEntity<>(response, HttpStatus.OK) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteInventary(@PathVariable long id) {
        try {
            Boolean response = inventaryService.deleteInventary(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
