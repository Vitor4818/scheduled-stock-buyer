package com.vgm.invest.domain.repository;

import com.vgm.invest.domain.model.Customer.Cpf;
import com.vgm.invest.domain.model.Customer.Customer;
import com.vgm.invest.domain.model.Customer.CustomerEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    boolean existsByCpf(Cpf cpf);
    boolean existsByEmail(CustomerEmail email);
}
