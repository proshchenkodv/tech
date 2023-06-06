--liquibase formatted sql
--changeset proshchenkodv:SSD-53 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS default_dmt_production_gp_bi ON supersklad.default_dmt_production_gp;
CREATE or REPLACE FUNCTION supersklad.default_dmt_production_gp_bi() RETURNS trigger AS
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
        IF new.id IS NULL THEN
            new.id := nextval('supersklad.default_dmt_production_gp_s');
        END IF;
    END IF;
    RETURN
        new;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER default_dmt_production_gp_bi
    BEFORE INSERT
    ON supersklad.default_dmt_production_gp
    FOR EACH ROW
EXECUTE FUNCTION supersklad.default_dmt_production_gp_bi();