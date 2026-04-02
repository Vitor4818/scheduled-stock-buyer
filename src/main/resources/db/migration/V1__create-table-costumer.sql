CREATE TABLE tb_customer (
    id BINARY(16) NOT NULL,
    name VARCHAR(255),
    cpf VARCHAR(14) NOT NULL,
    email VARCHAR(255),
    monthly_investment DECIMAL(19,2),
    is_active BOOLEAN,
    accession_date DATE,
    PRIMARY KEY (id),
    UNIQUE (cpf)
);