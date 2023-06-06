--liquibase formatted sql
--changeset proshchenkodv:SSD-40 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS at_client_auth_bi ON supersklad.at_client_auth;
CREATE or REPLACE FUNCTION supersklad.at_client_auth_bi() RETURNS trigger AS
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
        IF new.ID IS NULL THEN
            new.ID := nextval('supersklad.at_client_auth_s');
        END IF;
    END IF;
    RETURN new;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER at_client_auth_bi
    BEFORE INSERT
    ON supersklad.at_client_auth
    FOR EACH ROW
EXECUTE FUNCTION supersklad.at_client_auth_bi();