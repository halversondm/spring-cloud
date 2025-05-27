--liquibase formatted sql

--changeset Dan Halverson:adding schema
--preconditions onFail:MARK_RAN
--precondition-sql-check expectedResult:0 SELECT count(1) FROM information_schema.schemata WHERE schema_name = 'spring_cloud_app'
CREATE SCHEMA SPRING_CLOUD_APP;