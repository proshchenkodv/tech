--liquibase formatted sql
--changeset proshchenkodv:SSD-53 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS default_dmt_production_gp_biu ON supersklad.default_dmt_production_gp;
CREATE TRIGGER default_dmt_production_gp_biu
    BEFORE INSERT OR UPDATE
    ON supersklad.default_dmt_production_gp
    FOR EACH ROW
EXECUTE FUNCTION supersklad.for_trigger_biu();