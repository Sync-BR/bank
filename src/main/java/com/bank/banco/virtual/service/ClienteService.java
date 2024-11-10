package com.bank.banco.virtual.service;

import com.bank.banco.virtual.model.ClienteModel;
import com.bank.banco.virtual.repository.ClienteRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class ClienteService {
    private static final Logger log = LogManager.getLogger(ClienteService.class);
    @Autowired
    private  ClienteRepository clienteRepository;

    public Boolean createrUser(ClienteModel clienteModel) {
        if (clienteModel != null) {
            log.info("Cliente adicionado com sucesso");
            clienteRepository.save(clienteModel);
            return true;
        }
        log.error("Erro ao cadastrar cliente");
        return false;
    }

    public Boolean checkCpf(String cpf) {
        ClienteModel cliente = clienteRepository.findByCpf(cpf);
        if (cliente != null) {
            log.info("Cpf encontrado no banco de dados");
            return true;
        }
        log.info("CPF: " +cpf+ " não encontrado no banco de dados!");
        return false;
    }

    public Boolean checkEmail(String email) {
        ClienteModel cliente = clienteRepository.findByEmail(email);
        if (cliente != null) {
            log.info("Email encontrado no banco de dados");
            return true;
        }
        log.info("Email " +email+ " não foi encontrado no banco de dados");
        return false;
    }
}
