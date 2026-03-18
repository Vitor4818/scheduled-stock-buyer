package com.vgm.invest.domain.customer.repository;

import com.vgm.invest.domain.customer.vo.Cpf;
import com.vgm.invest.domain.customer.entities.Customer;
import com.vgm.invest.domain.customer.vo.CustomerEmail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    boolean existsByCpf(Cpf cpf);
    boolean existsByEmail(CustomerEmail email);
    Optional<Customer> findById(UUID uuid);
    Customer save(Customer customer);
    Page<Customer> findAllActive(Pageable pageable);
}
