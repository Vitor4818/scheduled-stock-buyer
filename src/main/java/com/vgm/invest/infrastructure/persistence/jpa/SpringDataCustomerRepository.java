package com.vgm.invest.infrastructure.persistence.jpa;

import com.vgm.invest.domain.customer.entities.Customer;
import com.vgm.invest.domain.customer.vo.Cpf;
import com.vgm.invest.domain.customer.vo.CustomerEmail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataCustomerRepository extends JpaRepository<Customer, UUID> {
    boolean existsByCpf(Cpf cpf);
    boolean existsByEmail(CustomerEmail email);
    Page<Customer> findAllByIsActiveTrue(Pageable pageable);

}
