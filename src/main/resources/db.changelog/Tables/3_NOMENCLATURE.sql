--liquibase formatted sql
-- Table WAGON_PASSPORT
--changeset proshchenkodv:TZ-1
CREATE TABLE IF NOT EXISTS RZD_WAGON.NOMENCLATURE
(
    NOMENCLATURE_ID           Integer                  NOT NULL,
    NOMENCLATURE_NAME   Character varying(30)   NOT NULL,
    INS_DATE     Timestamp NOT NULL default current_timestamp,
    MOD_DATE     Timestamp NOT NULL default current_timestamp,
    CONSTRAINT NOMENCLATURE_PK PRIMARY KEY (NOMENCLATURE_ID)
    )
;
COMMENT ON TABLE RZD_WAGON.NOMENCLATURE IS 'Справочник номенклатур грузов';
COMMENT ON COLUMN RZD_WAGON.NOMENCLATURE.NOMENCLATURE_ID IS 'ИД записи';
COMMENT ON COLUMN RZD_WAGON.NOMENCLATURE.NOMENCLATURE_NAME IS 'Имя номенклатуры';
COMMENT ON COLUMN RZD_WAGON.NOMENCLATURE.INS_DATE IS 'Дата создания записи';
COMMENT ON COLUMN RZD_WAGON.NOMENCLATURE.MOD_DATE IS 'Дата изменения записи';