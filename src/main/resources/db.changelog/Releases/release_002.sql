--liquibase formatted sql
-- Data USERS
--changeset proshchenkodv:SSD-61_3
ALTER TABLE supersklad.at_user
ADD COLUMN LOGIN Character varying(20);
COMMENT ON COLUMN supersklad.at_user.CD_UP IS 'Логин';

--liquibase formatted sql
-- Data USERS
--changeset proshchenkodv:SSD-61_4
ALTER TABLE supersklad.at_client_auth
    DROP COLUMN LOGIN;