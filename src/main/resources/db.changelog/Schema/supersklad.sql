--liquibase formatted sql
--changeset proshchenkodv:TZ-1
CREATE SCHEMA rzd_wagon AUTHORIZATION ms_user;
GRANT ALL ON SCHEMA rzd_wagon TO ms_user;