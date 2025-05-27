--liquibase formatted sql

--changeset Dan Halverson:adding book table
CREATE TABLE BOOK
(
    ID          INTEGER PRIMARY KEY,
    TITLE       VARCHAR(255),
    AUTHOR      VARCHAR(255),
    PUBLISHED   DATE
);
--rollback DELETE TABLE BOOK;