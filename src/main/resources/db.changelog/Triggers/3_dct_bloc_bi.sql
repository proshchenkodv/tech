--liquibase formatted sql
--changeset proshchenkodv:SSD-19 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS dct_bloc_bi ON rzd_wagon.dct_bloc;
CREATE or REPLACE FUNCTION rzd_wagon.dct_bloc_bi() RETURNS trigger AS
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
        IF new.functional_bloc_id IS NULL THEN
            new.functional_bloc_id := nextval('rzd_wagon.dct_bloc_s');
        END IF;
    END IF;
    RETURN new;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER dct_bloc_bi
    BEFORE INSERT
    ON rzd_wagon.dct_bloc
    FOR EACH ROW
EXECUTE FUNCTION rzd_wagon.dct_bloc_bi();