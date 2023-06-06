--liquibase formatted sql
--changeset proshchenkodv:SSD-12 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS dmt_dispatching_biu ON supersklad.dmt_dispatching;
CREATE TRIGGER dmt_dispatching_biu
    BEFORE INSERT OR UPDATE
    ON supersklad.dmt_dispatching
    FOR EACH ROW
EXECUTE FUNCTION supersklad.for_trigger_biu();