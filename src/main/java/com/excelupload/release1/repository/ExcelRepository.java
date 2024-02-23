package com.excelupload.release1.repository;
import com.excelupload.release1.model.ExcelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcelRepository extends JpaRepository<ExcelEntity, Long> {
    // You can add custom query methods here if needed
}

