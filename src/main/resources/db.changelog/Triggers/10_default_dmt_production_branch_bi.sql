--liquibase formatted sql
--changeset proshchenkodv:SSD-55 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS default_dmt_production_branch_bi ON supersklad.DEFAULT_DMT_PRODUCTION_BRANCH;
CREATE or REPLACE FUNCTION supersklad.default_dmt_production_branch_bi() RETURNS trigger AS
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
        IF new.id IS NULL THEN
            new.id := nextval('supersklad.default_dmt_production_branch_s');
        END IF;
    END IF;
    RETURN
        new;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER default_dmt_production_branch_bi
    BEFORE INSERT
    ON supersklad.DEFAULT_DMT_PRODUCTION_BRANCH
    FOR EACH ROW
EXECUTE FUNCTION supersklad.default_dmt_production_branch_bi();