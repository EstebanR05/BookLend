package com.library.ApiRestLibrary.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.UrlResource;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "inventary")
public class Inventary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventary")
    private long id;

    @Column(name = "name_book")
    private String name;

    @Column(name = "img")
    private String img;

    @Column(name = "author")
    private String author;

    @Column(name = "create_at")
    private LocalDate create_at;

    @Transient
    private MultipartFile file;
}
