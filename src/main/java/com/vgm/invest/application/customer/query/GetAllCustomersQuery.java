package com.vgm.invest.application.customer.query;

import org.springframework.data.domain.Pageable;

public record GetAllCustomersQuery(Pageable pageable) {

}
