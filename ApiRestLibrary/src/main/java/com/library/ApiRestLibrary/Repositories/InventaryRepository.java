package com.library.ApiRestLibrary.Repositories;

import com.library.ApiRestLibrary.Entity.Inventary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventaryRepository extends JpaRepository<Inventary, Long> {

}
