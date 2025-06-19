package com.example.tables.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.tables.Entity.UpiSmsEntity;

    @Repository
public interface UpiSmsRepo extends JpaRepository<UpiSmsEntity, String> {
    @Query("SELECT s FROM UpiSmsEntity s")
    List<UpiSmsEntity> fetchAllConfigs();

}
