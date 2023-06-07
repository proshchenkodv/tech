--liquibase formatted sql
-- Table WAGON_PASSPORT
--changeset proshchenkodv:TZ-1
CREATE TABLE IF NOT EXISTS RZD_WAGON.STATION_PATH
(
    STATION_PATH_ID           Integer                  NOT NULL,
    STATION_PATH_NAME   Character varying(30)   NOT NULL,
    STATION_ID   Integer   NOT NULL,
    INS_DATE     Timestamp NOT NULL default current_timestamp,
    MOD_DATE     Timestamp NOT NULL default current_timestamp,
    CONSTRAINT STATION_PATH_PK PRIMARY KEY (STATION_PATH_ID)
    )
;
COMMENT ON TABLE RZD_WAGON.STATION_PATH IS 'Пути на станциях';
COMMENT ON COLUMN RZD_WAGON.STATION_PATH.STATION_PATH_ID IS 'ИД записи';
COMMENT ON COLUMN RZD_WAGON.STATION_PATH.STATION_PATH_NAME IS 'Имя пути';
COMMENT ON COLUMN RZD_WAGON.STATION_PATH.STATION_ID IS 'ID станции';
COMMENT ON COLUMN RZD_WAGON.STATION_PATH.INS_DATE IS 'Дата создания записи';
COMMENT ON COLUMN RZD_WAGON.STATION_PATH.MOD_DATE IS 'Дата изменения записи';