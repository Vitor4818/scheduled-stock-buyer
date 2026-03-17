package com.vgm.invest.application.customer.query.dto;

import com.vgm.invest.domain.customer.entities.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CustomerResponse(
        UUID id,
        String name,
        String cpf,
        String email,
        BigDecimal monthlyInvestment,
        LocalDate accessionDate
) {
    public CustomerResponse(UUID id, String name, String cpf, String email, BigDecimal monthlyInvestment, LocalDate accessionDate) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.monthlyInvestment = monthlyInvestment;
        this.accessionDate = accessionDate;
    }

    public static CustomerResponse fromEntity(Customer customer){
        return new CustomerResponse(
        customer.getId(),
        customer.getName(),
        customer.getCpf().getValue(),
        customer.getEmail().getValue(),
        customer.getMonthlyInvestment().getValue(),
        customer.getAccessionDate()
        );
    }



}
