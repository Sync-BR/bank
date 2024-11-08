package com.bank.banco.virtual.controller;

import com.bank.banco.virtual.model.ClienteModel;
import com.bank.banco.virtual.service.ClienteService;

import com.bank.banco.virtual.service.FileUploadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/user/controlador")
public class ClienteController {
    private ClienteService service;

    @PostMapping("/creater")
    public ResponseEntity<?> registerUser(@RequestBody ClienteModel cliente, @RequestParam("file") MultipartFile file) {
        FileUploadService uploadService = new FileUploadService();
        if (uploadService.uploadImage(file)) {
            if (service.createrUser(cliente)) {
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return ResponseEntity.status(HttpStatus.OK).body("Falha no upload da imagem.");

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // Se existe o cpf retorna verdadeiro
    @PostMapping("/check/cpf/{cpf}")
    public ResponseEntity<?> checkCpf(@PathVariable String cpf) {
        if (service.checkCpf(cpf)) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
        return ResponseEntity.status(HttpStatus.OK).body(false);
    }

    // Se existe o email retorna verdadeiro
    @PostMapping("/check/email/{email}")
    public ResponseEntity<?> checkEmail(@PathVariable String email) {
        if (service.checkEmail(email)) {
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }
        return ResponseEntity.status(HttpStatus.OK).body(false);
    }
}


