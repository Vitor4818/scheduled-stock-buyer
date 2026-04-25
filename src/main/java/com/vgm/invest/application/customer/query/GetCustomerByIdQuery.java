package com.vgm.invest.application.customer.query;

import java.util.UUID;

public record GetCustomerByIdQuery(
        UUID customerId
) {
}
