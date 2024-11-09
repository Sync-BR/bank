package com.bank.banco.virtual.repository;

import com.bank.banco.virtual.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    public ClienteModel findByCpf(String cpf);
    public ClienteModel findByEmail(String email);
}
