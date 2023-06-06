--liquibase formatted sql
--changeset proshchenkodv:SSD-19 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS dct_reporting_biu ON supersklad.dct_reporting;
CREATE TRIGGER dct_reporting_biu
    BEFORE INSERT OR UPDATE
    ON supersklad.dct_reporting
    FOR EACH ROW
EXECUTE FUNCTION supersklad.for_trigger_biu();