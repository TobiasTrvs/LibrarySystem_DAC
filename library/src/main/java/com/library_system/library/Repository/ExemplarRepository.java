package com.library_system.library.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library_system.library.entity.Exemplar;

public interface ExemplarRepository extends JpaRepository <Exemplar, Long>{
    
}
