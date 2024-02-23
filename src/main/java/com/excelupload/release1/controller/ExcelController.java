package com.excelupload.release1.controller;

import com.excelupload.release1.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import java.io.IOException;


@RestController
@RequestMapping("/api/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload.");
        }
        String originalFilename = file.getOriginalFilename();

        if (originalFilename != null && (originalFilename.toLowerCase().endsWith(".xlsx") || originalFilename.toLowerCase().endsWith(".xls"))) {
            try {
                excelService.processExcelFile(file.getInputStream(), file.getOriginalFilename());
                return ResponseEntity.ok("File uploaded successfully!");
            } catch (IOException e) {
                return ResponseEntity.badRequest().body("Failed to upload file: " + e.getMessage());
            }
        } else {
            return ResponseEntity.badRequest().body("Only Excel files with .xlsx extension are allowed.");
        }
    }


    // Other controller methods
}
