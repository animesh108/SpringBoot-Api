package com.excelupload.release1.model;


import jakarta.persistence.*;

@Entity
public class ExcelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private byte[] excelFile;

    private String fileName; // Add this field for storing the original file name

    // Constructors, getters, and setters

    public ExcelEntity() {
    }

    public ExcelEntity(byte[] excelFile, String fileName) {
        this.excelFile = excelFile;
        this.fileName = fileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getExcelFile() {
        return excelFile;
    }

    public void setExcelFile(byte[] excelFile) {
        this.excelFile = excelFile;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
