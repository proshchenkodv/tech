--liquibase formatted sql
--changeset proshchenkodv:SSD-19 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS dct_role_bi ON supersklad.dct_role;
CREATE or REPLACE FUNCTION supersklad.dct_role_bi() RETURNS trigger AS
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
        IF new.role_id IS NULL THEN
            new.role_id := nextval('supersklad.dct_role_s');
        END IF;
    END IF;
    RETURN new;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER dct_role_bi
    BEFORE INSERT
    ON supersklad.dct_role
    FOR EACH ROW
EXECUTE FUNCTION supersklad.dct_role_bi();