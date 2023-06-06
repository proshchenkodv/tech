--liquibase formatted sql
--changeset proshchenkodv:SSD-40 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS at_client_auth_biu ON supersklad.at_client_auth;
CREATE TRIGGER at_client_auth_biu
    BEFORE INSERT OR UPDATE
    ON supersklad.at_client_auth
    FOR EACH ROW
EXECUTE FUNCTION supersklad.for_trigger_biu();