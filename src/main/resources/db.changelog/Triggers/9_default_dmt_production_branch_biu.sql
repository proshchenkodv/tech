--liquibase formatted sql
--changeset proshchenkodv:SSD-55 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS default_dmt_production_branch_biu ON supersklad.DEFAULT_DMT_PRODUCTION_BRANCH;
CREATE TRIGGER default_dmt_production_branch_biu
    BEFORE INSERT OR UPDATE
    ON supersklad.DEFAULT_DMT_PRODUCTION_BRANCH
    FOR EACH ROW
EXECUTE FUNCTION supersklad.for_trigger_biu();