package com.vgm.invest.domain.customer.entities;

import com.vgm.invest.application.customer.command.UpdateCustomerCommand;
import com.vgm.invest.domain.customer.vo.Cpf;
import com.vgm.invest.domain.customer.vo.CustomerEmail;
import com.vgm.invest.domain.customer.vo.MonthlyInvestment;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tb_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Column(unique = true, nullable = false)
    @Embedded
    private Cpf cpf;
    @Embedded
    private CustomerEmail email;
    @Embedded
    private MonthlyInvestment monthlyInvestment;
    private boolean isActive;
    private LocalDate accessionDate;


    public Customer(MonthlyInvestment monthlyInvestment, CustomerEmail email, Cpf cpf, String name) {
        this.monthlyInvestment = monthlyInvestment;
        this.email = email;
        this.cpf = cpf;
        this.name = name;
        this.isActive = true;
        this.accessionDate = LocalDate.now();
    }

    //Metodo para atualizar parcialmente os dados do usuario. Só irá atualizar os campos recebidos
    public void updateCustomer(UpdateCustomerCommand command) {
        if (command.monthlyInvestment() != null) {
            MonthlyInvestment monthlyInvestmentVO = new MonthlyInvestment(command.monthlyInvestment());
            this.monthlyInvestment = monthlyInvestmentVO;
        }
        if (!command.name().isBlank()) {
            this.name = command.name();
        }
    }

    //Metodo de desativar a conta
    //Usarei para não deletar dados do usuario e poder diferenciar os ativos dos que cancelaram a conta
    public void deactive(){
        this.isActive = false;
        this.monthlyInvestment.setValue(BigDecimal.ZERO);
    }




}
