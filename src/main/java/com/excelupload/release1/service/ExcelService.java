package com.excelupload.release1.service;

import com.excelupload.release1.model.ExcelEntity;
import com.excelupload.release1.repository.ExcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class ExcelService {

    @Autowired
    private ExcelRepository excelRepository;

    public void processExcelFile(InputStream inputStream, String fileName) throws IOException {
        byte[] fileBytes = readBytesFromInputStream(inputStream);

        ExcelEntity excelEntity = new ExcelEntity(fileBytes, fileName);
        excelRepository.save(excelEntity);
    }

    private byte[] readBytesFromInputStream(InputStream inputStream) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

}
