package com.bank.banco.virtual.repository;

import com.bank.banco.virtual.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
     ClienteModel findByCpf(String cpf);
     ClienteModel findByEmail(String email);
}
