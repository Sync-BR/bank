package com.bank.banco.virtual.repository;

import com.bank.banco.virtual.model.ClienteModel;
import com.bank.banco.virtual.model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<LoginModel, Long> {
    LoginModel findByUsername(String username);
}
