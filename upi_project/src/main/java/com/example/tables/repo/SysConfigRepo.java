package com.example.tables.repo;

import com.example.tables.Entity.SysConfig;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SysConfigRepo extends JpaRepository<SysConfig, String> {
    @Query("SELECT s FROM SysConfig s")
    List<SysConfig> fetchAllConfigs();

}
