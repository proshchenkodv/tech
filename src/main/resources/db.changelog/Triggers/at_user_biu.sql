--liquibase formatted sql
--changeset proshchenkodv:SSD-12 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS at_user_biu ON supersklad.at_user;
CREATE TRIGGER at_user_biu
    BEFORE INSERT OR UPDATE
    ON supersklad.at_user
    FOR EACH ROW
EXECUTE FUNCTION supersklad.for_trigger_biu();