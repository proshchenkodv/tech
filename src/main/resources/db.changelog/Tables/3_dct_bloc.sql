--liquibase formatted sql
-- Table WAGON_PASSPORT
--changeset proshchenkodv:TZ-1
CREATE TABLE IF NOT EXISTS RZD_WAGON.WAGON_PASSPORT
(
    WAGON_PASSPORT_ID           Integer                  NOT NULL,
    WAGON_NUMBER   Character varying(30)   NOT NULL,
    WAGON_TYPE   Character varying(30)   NOT NULL,
    TARA_WEIGHT        FLOAT    NOT NULL,
    LOAD_CAPACITY      FLOAT                  NOT NULL,
    INS_DATE     Timestamp NOT NULL default current_timestamp,
    MOD_DATE     Timestamp NOT NULL default current_timestamp,
    CONSTRAINT WAGON_PASSPORT_PK PRIMARY KEY (WAGON_ID)
    )
;
COMMENT ON TABLE RZD_WAGON.WAGON_PASSPORT IS 'Паспорта вагонов';
COMMENT ON COLUMN RZD_WAGON.WAGON_PASSPORT.WAGON_ID IS 'ИД записи';
COMMENT ON COLUMN RZD_WAGON.WAGON_PASSPORT.WAGON_NUMBER IS 'Номер';
COMMENT ON COLUMN RZD_WAGON.WAGON_PASSPORT.WAGON_TYPE IS 'Тип';
COMMENT ON COLUMN RZD_WAGON.WAGON_PASSPORT.TARA_WEIGHT IS 'Вес тары';
COMMENT ON COLUMN RZD_WAGON.WAGON_PASSPORT.LOAD_CAPACITY IS 'Грузоподъемность';
COMMENT ON COLUMN RZD_WAGON.WAGON_PASSPORT.INS_DATE IS 'Дата создания записи';
COMMENT ON COLUMN RZD_WAGON.WAGON_PASSPORT.MOD_DATE IS 'Дата изменения записи';