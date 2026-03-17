package com.vgm.invest.infrastructure.persistence.jpa;

import com.vgm.invest.domain.customer.entities.Customer;
import com.vgm.invest.domain.customer.repository.CustomerRepository;
import com.vgm.invest.domain.customer.vo.Cpf;
import com.vgm.invest.domain.customer.vo.CustomerEmail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final SpringDataCustomerRepository springDataRepository;

    public CustomerRepositoryImpl(SpringDataCustomerRepository springDataRepository) {
        this.springDataRepository = springDataRepository;
    }

    @Override
    public boolean existsByCpf(Cpf cpf) {
        return springDataRepository.existsByCpf(cpf);
    }

    @Override
    public boolean existsByEmail(CustomerEmail email) {
        return springDataRepository.existsByEmail(email);
    }

    @Override
    public Optional<Customer> findById(UUID uuid) {
        return springDataRepository.findById(uuid);
    }

    @Override
    public Customer save(Customer customer) {
        return springDataRepository.save(customer);
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return springDataRepository.findAll(pageable);
    }
}
