--liquibase formatted sql
--changeset proshchenkodv:SSD-53 runOnChange:true splitStatements:false

CREATE SEQUENCE supersklad.default_dmt_production_gp_s
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1
;