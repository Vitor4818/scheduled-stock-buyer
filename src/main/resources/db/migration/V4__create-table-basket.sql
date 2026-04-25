CREATE TABLE tb_basket (
    id BINARY(16) NOT NULL,
    name VARCHAR(100) NOT NULL,
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    activation_date DATE NOT NULL,
    deactivation_date DATE NULL,
    CONSTRAINT pk_basket PRIMARY KEY (id)
) ENGINE=InnoDB;
CREATE INDEX idx_basket_active ON tb_basket (is_active);