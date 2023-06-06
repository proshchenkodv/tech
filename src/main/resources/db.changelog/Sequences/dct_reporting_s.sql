--liquibase formatted sql
--changeset proshchenkodv:SSD-19 runOnChange:true splitStatements:false

CREATE SEQUENCE supersklad.dct_reporting_s
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1
;