-- liquibase formatted sql

-- changeset Oleg:1741111198606-1
CREATE TABLE requisites
(
    id               UUID         NOT NULL,
    external_id      VARCHAR(50)  NOT NULL,
    client_id        VARCHAR(20)  NOT NULL,
    name_company     VARCHAR(50)  NOT NULL,
    inn              BIGINT       NOT NULL,
    kpp              INTEGER      NOT NULL,
    ogrn             BIGINT       NOT NULL,
    business_address VARCHAR(100) NOT NULL,
    address          VARCHAR(100) NOT NULL,
    rcbic            INTEGER      NOT NULL,
    corr_ass         FLOAT        NOT NULL,
    ass              FLOAT        NOT NULL,
    bank_name        VARCHAR(50)  NOT NULL,
    created_time     TIMESTAMP WITHOUT TIME ZONE,
    updated_time     TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_requisites PRIMARY KEY (id)
);

