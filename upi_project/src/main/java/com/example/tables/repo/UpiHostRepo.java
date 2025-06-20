package com.example.tables.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tables.Entity.UpiHostEntity;

@Repository
public interface UpiHostRepo extends JpaRepository<UpiHostEntity, Long> {
 
}