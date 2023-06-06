--liquibase formatted sql
--changeset proshchenkodv:SSD-19 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS dct_connection_role_bloc_biu ON supersklad.dct_connection_role_bloc;
CREATE TRIGGER dct_connection_role_bloc_biu
    BEFORE INSERT OR UPDATE
    ON supersklad.dct_connection_role_bloc
    FOR EACH ROW
EXECUTE FUNCTION supersklad.for_trigger_biu();