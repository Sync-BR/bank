package com.bank.banco.virtual.controller;

import com.bank.banco.virtual.model.ClienteModel;
import com.bank.banco.virtual.service.ClienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/user/controlador")
public class ClienteController {
    private ClienteService service;
    @PostMapping("/creater")
    public ResponseEntity<HttpStatus> registerUser(ClienteModel cliente) {
        if (service.createrUser(cliente)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
