CREATE TABLE IF NOT EXISTS tb_trading_account (
    id BINARY(16) PRIMARY KEY,
    customer_id BINARY(16) NOT NULL,
    number_account VARCHAR(20) NOT NULL,
    account_type ENUM('MASTER', 'FILHOTE') NOT NULL,
    balance DECIMAL(18, 2) NOT NULL DEFAULT 0.00,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    UNIQUE INDEX uk_number_account (number_account),
    INDEX idx_customer_id (customer_id),

    CONSTRAINT fk_customer_trading_account
        FOREIGN KEY (customer_id)
        REFERENCES tb_customer(id)
        ON DELETE CASCADE
) ENGINE=InnoDB;