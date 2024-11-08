package com.bank.banco.virtual.service;

import com.bank.banco.virtual.model.ClienteModel;
import com.bank.banco.virtual.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Boolean createrUser(ClienteModel clienteModel) {
        ClienteModel cliente = clienteRepository.save(clienteModel);
            if (cliente != null) {
                return true;
            }
        return false;
    }
}
