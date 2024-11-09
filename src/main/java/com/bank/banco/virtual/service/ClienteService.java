package com.bank.banco.virtual.service;

import com.bank.banco.virtual.model.ClienteModel;
import com.bank.banco.virtual.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    public Boolean checkCpf(String cpf){
        ClienteModel cliente = clienteRepository.findByCpf(cpf);
        if (cliente != null) {
            return true;
        }
        return false;
    }
    public Boolean checkEmail(String email){
        ClienteModel cliente = clienteRepository.findByEmail(email);
        if (cliente != null) {
            return true;
        }
        return false;
    }
}
