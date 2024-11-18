package com.bank.banco.virtual.service;

import com.bank.banco.virtual.model.LoginModel;
import com.bank.banco.virtual.repository.LoginRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private static final Logger log = LogManager.getLogger(LoginService.class);
    @Autowired
    private LoginRepository loginRepository;

    protected boolean findByLogin(LoginModel login) {
        LoginModel loginModel = loginRepository.findByUsername(login.getUsername());
        if (loginModel != null) {
            if (login.getPassword().equals(loginModel.getPassword())) {
                log.info("Usuário autenticado com sucesso!");
                return true;
            }
            log.error("Senha incorreta");
            return false;
        }
        log.info("Usuário não encontrado!");
        return false;
    }

    protected boolean findByUserName(String username) {
        System.out.println(username.toString());
        LoginModel usernameDate = loginRepository.findByUsername(username);
        log.info("Resposta: " +usernameDate);
        if (usernameDate != null) {
            return true;
        }
        return false;
    }
}
