package com.bank.banco.virtual.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class FileUploadService {
    private static final Log log = LogFactory.getLog(FileUploadService.class);
    private final String dir = "E:/Java/Projetos SpringBoot/banco-virtual/src/main/resources/static/src/img/perfil/";

    public boolean uploadImage(MultipartFile file) {
        try {
            File destinationFile = new File(dir + file.getOriginalFilename());
            file.transferTo(destinationFile);
            log.info("Imagem enviada com sucesso!");
            return true;
        } catch (IOException e) {
            log.error(e.getMessage());
            return false;
        }
    }
}
