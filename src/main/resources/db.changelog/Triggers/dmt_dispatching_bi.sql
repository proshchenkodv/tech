--liquibase formatted sql
--changeset proshchenkodv:SSD-40 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS dmt_dispatching_bi ON supersklad.dmt_dispatching;
CREATE or REPLACE FUNCTION supersklad.dmt_dispatching_bi() RETURNS trigger AS
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
        IF new.ID IS NULL THEN
            new.ID := nextval('supersklad.dmt_dispatching_s');
        END IF;
    END IF;
    RETURN new;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER dmt_dispatching_bi
    BEFORE INSERT
    ON supersklad.dmt_dispatching
    FOR EACH ROW
EXECUTE FUNCTION supersklad.dmt_dispatching_bi();