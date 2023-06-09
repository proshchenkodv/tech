--liquibase formatted sql
--changeset proshchenkodv:SSD-19 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS dct_bloc_biu ON rzd_wagon.dct_bloc;
CREATE TRIGGER dct_bloc_biu
    BEFORE INSERT OR UPDATE
    ON rzd_wagon.dct_bloc
    FOR EACH ROW
EXECUTE FUNCTION rzd_wagon.for_trigger_biu();