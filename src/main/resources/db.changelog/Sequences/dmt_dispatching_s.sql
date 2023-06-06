--liquibase formatted sql
--changeset proshchenkodv:SSD-40 runOnChange:true splitStatements:false

CREATE SEQUENCE supersklad.dmt_dispatching_s
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1
;