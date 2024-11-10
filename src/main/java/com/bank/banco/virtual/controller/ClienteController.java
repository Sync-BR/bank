package com.bank.banco.virtual.controller;

import com.bank.banco.virtual.model.ClienteModel;
import com.bank.banco.virtual.repository.ClienteRepository;
import com.bank.banco.virtual.service.ClienteService;

import com.bank.banco.virtual.service.FileUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user/controlador")
public class ClienteController {
    private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
    @Autowired
    private ClienteService service;

    @PostMapping("/uploadarchive")
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        FileUploadService uploadService = new FileUploadService();
        if (uploadService.uploadImage(file)) {
            return ResponseEntity.status(HttpStatus.OK).body("Sucesso ao enviar imagem");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Falha no upload da imagem.");
    }
    @PostMapping("/creater")
    public ResponseEntity<?> registerUser(@RequestBody ClienteModel cliente) {
        if (service.createrUser(cliente)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Cliente cadastrado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro ao cadastrar cliente");

    }

    @PostMapping("/check/cpf/{cpf}")
    public ResponseEntity<?> checkCpf(@PathVariable String cpf) {
        if (service.checkCpf(cpf)) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
        return ResponseEntity.status(HttpStatus.OK).body(false);
    }

    @PostMapping("/check/email/{email}")
    public ResponseEntity<?> checkEmail(@PathVariable String email) {
        if (service.checkEmail(email)) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
        return ResponseEntity.status(HttpStatus.OK).body(false);
    }
}


