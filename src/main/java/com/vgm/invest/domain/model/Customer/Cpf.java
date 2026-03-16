package com.vgm.invest.domain.model.Customer;

import br.com.caelum.stella.validation.CPFValidator;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cpf {
    @Column(name = "cpf")
    private  String value;

    //Consrutor realiza a validação do cpf pela biblioteca CAELUM STELLA
    public Cpf(String cpf) {

        //Faz a normalização da string para ter somente um padrão salvo no banco
        String normalized = cpf.replaceAll("[^0-9]", "");
        //Cria o objeto da Lib
        CPFValidator cpfValidator = new CPFValidator();
        //Verifica se é válido
        try{ cpfValidator.assertValid(normalized);
        //Se não for, lança uma exception
        }catch(Exception e){
            throw new IllegalArgumentException("Cpf Inválido");
        }
        //Salva o valor de CPF
        this.value = normalized;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cpf cpf = (Cpf) o;
        return Objects.equals(value, cpf.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }




}
