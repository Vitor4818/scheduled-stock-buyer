package com.vgm.invest.domain.customer.repository;

import com.vgm.invest.domain.customer.vo.Cpf;
import com.vgm.invest.domain.customer.entities.Customer;
import com.vgm.invest.domain.customer.vo.CustomerEmail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    boolean existsByCpf(Cpf cpf);
    boolean existsByEmail(CustomerEmail email);
}
