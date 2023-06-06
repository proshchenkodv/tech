--liquibase formatted sql
--changeset proshchenkodv:SSD-32 runOnChange:true splitStatements:false

CREATE SEQUENCE supersklad.default_dmt_oper_warehouse_gp_s
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1
;