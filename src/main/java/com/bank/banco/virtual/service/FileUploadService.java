package com.bank.banco.virtual.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUploadService {
    private final String dir = "E:/Java/Projetos SpringBoot/banco-virtual/src/main/resources/static/src/img/";

    public boolean uploadImage(MultipartFile file) {
        try {
            File destinationFile = new File(dir + file.getOriginalFilename());
            file.transferTo(destinationFile);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
