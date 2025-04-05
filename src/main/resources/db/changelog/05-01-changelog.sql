-- liquibase formatted sql

-- changeset Oleg:1743855909528-1
CREATE SEQUENCE IF NOT EXISTS client_seq START WITH 1 INCREMENT BY 50;

-- changeset Oleg:1743855909528-2
CREATE TABLE client
(
    id   INTEGER     NOT NULL,
    name VARCHAR(50) NOT NULL,
    CONSTRAINT pk_client PRIMARY KEY (id)
);

-- changeset Oleg:1743855909528-3
CREATE TABLE requisites
(
    id               UUID             NOT NULL,
    external_id      VARCHAR(50)      NOT NULL,
    client_id        VARCHAR(20)      NOT NULL,
    name_company     VARCHAR(50)      NOT NULL,
    inn              BIGINT           NOT NULL,
    kpp              INTEGER          NOT NULL,
    ogrn             BIGINT           NOT NULL,
    business_address VARCHAR(100)     NOT NULL,
    address          VARCHAR(100)     NOT NULL,
    rcbic            INTEGER          NOT NULL,
    corr_ass         DOUBLE PRECISION NOT NULL,
    ass              DOUBLE PRECISION NOT NULL,
    bank_name        VARCHAR(50)      NOT NULL,
    created_time     TIMESTAMP WITHOUT TIME ZONE,
    updated_time     TIMESTAMP WITHOUT TIME ZONE,
    requisites_id    INTEGER,
    CONSTRAINT pk_requisites PRIMARY KEY (id)
);

-- changeset Oleg:1743855909528-4
ALTER TABLE requisites
    ADD CONSTRAINT FK_REQUISITES_ON_REQUISITES FOREIGN KEY (requisites_id) REFERENCES client (id);

