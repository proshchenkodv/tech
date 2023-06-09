--liquibase formatted sql
--changeset proshchenkodv:TZ-1
CREATE SCHEMA rzd_wagon AUTHORIZATION postgres;
GRANT ALL ON SCHEMA rzd_wagon TO postgres;