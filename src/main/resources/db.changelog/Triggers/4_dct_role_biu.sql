--liquibase formatted sql
--changeset proshchenkodv:SSD-19 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS dct_role_biu ON supersklad.dct_role;
CREATE TRIGGER dct_role_biu
    BEFORE INSERT OR UPDATE
    ON supersklad.dct_role
    FOR EACH ROW
EXECUTE FUNCTION supersklad.for_trigger_biu();