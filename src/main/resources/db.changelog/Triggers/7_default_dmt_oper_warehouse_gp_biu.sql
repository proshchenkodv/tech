--liquibase formatted sql
--changeset proshchenkodv:SSD-32 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS default_dmt_oper_warehouse_gp_biu ON supersklad.default_dmt_oper_warehouse_gp;
CREATE TRIGGER default_dmt_oper_warehouse_gp_biu
    BEFORE INSERT OR UPDATE
    ON supersklad.default_dmt_oper_warehouse_gp
    FOR EACH ROW
EXECUTE FUNCTION supersklad.for_trigger_biu();