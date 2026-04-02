CREATE TABLE tb_custody (
    -- ID primário da custódia (UUID)
    id BINARY(16) NOT NULL,

    -- Relacionamento com a conta gráfica
    trading_account_id BINARY(16) NOT NULL,

    -- Dados do ativo
    ticker VARCHAR(10) NOT NULL,
    qty INT NOT NULL DEFAULT 0,

    -- Preço Médio (Vindo do seu Value Object @Embedded)
    -- Usamos 18,4 para garantir a precisão bancária de 4 casas decimais
    value_average_price DECIMAL(18, 4) NOT NULL DEFAULT 0.0000,

    -- Auditoria
    last_update_date DATE NOT NULL,

    -- Chave Primária
    CONSTRAINT pk_custody PRIMARY KEY (id),

    -- Chave Estrangeira para a Trading Account
    CONSTRAINT fk_custody_trading_account
        FOREIGN KEY (trading_account_id)
        REFERENCES tb_trading_account (id),

    -- REGRA DE OURO: Impede que o mesmo cliente tenha duas linhas para a mesma ação.
    -- Isso força o seu "Upsert" a funcionar corretamente no banco.
    CONSTRAINT uk_custody_client_asset UNIQUE (trading_account_id, ticker)
);

-- Índice para acelerar a busca por Ticker (Muito usado no Rebalanceamento)
CREATE INDEX idx_custody_ticker ON tb_custody (ticker);