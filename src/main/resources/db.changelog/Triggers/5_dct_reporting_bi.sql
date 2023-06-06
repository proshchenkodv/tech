--liquibase formatted sql
--changeset proshchenkodv:SSD-19 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS dct_reporting_bi ON supersklad.dct_reporting;
CREATE or REPLACE FUNCTION supersklad.dct_reporting_bi() RETURNS trigger AS
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
        IF new.report_id IS NULL THEN
            new.report_id := nextval('supersklad.dct_reporting_s');
        END IF;
    END IF;
    RETURN new;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER dct_reporting_bi
    BEFORE INSERT
    ON supersklad.dct_reporting
    FOR EACH ROW
EXECUTE FUNCTION supersklad.dct_reporting_bi();