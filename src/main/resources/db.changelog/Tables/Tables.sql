--liquibase formatted sql
-- Table WAGON_PASSPORT
--changeset proshchenkodv:TZ-1
CREATE TABLE TECH.NATUR_LIST
(
    ID            BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    NATURLISTNAME VARCHAR(255) NOT NULL
);

CREATE TABLE TECH.NOMENCLATURE
(
    ID               BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    NOMENCLATURECODE VARCHAR(255) NOT NULL,
    NOMENCLATURENAME VARCHAR(255) NOT NULL
);

CREATE TABLE TECH.ROLE
(
    ROLEID   INTEGER PRIMARY KEY,
    ROLENAME VARCHAR(255) NOT NULL
);

CREATE TABLE TECH.STATION
(
    ID          BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    STATIONNAME VARCHAR(255) NOT NULL
);

CREATE TABLE TECH.STATION_PATH
(
    ID         BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    PATHNAME   VARCHAR(255) NOT NULL,
    STATION_ID BIGINT       NOT NULL,
    FOREIGN KEY (STATION_ID)
        REFERENCES TECH.STATION (ID)
);

CREATE TABLE TECH.USER
(
    USERID INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    NAME   VARCHAR(255) NOT NULL
);

CREATE TABLE TECH.WAGON
(
    ID                 BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    WAGONNUMBER        VARCHAR(255) NOT NULL,
    NOMENCLATUREWEIGHT DOUBLE       NOT NULL,
    WAGONWEIGHT        DOUBLE       NOT NULL,
    ORDERNUM           INTEGER      NOT NULL,
    NATURLIST_ID       BIGINT,
    WAGONPASSPORT_ID   BIGINT,
    NOMENCLATURE_ID    BIGINT,
    STATION_PATH_ID    BIGINT,
    FOREIGN KEY (NATURLIST_ID)
        REFERENCES TECH.NATUR_LIST (ID),
    FOREIGN KEY (WAGONPASSPORT_ID)
        REFERENCES TECH.WAGON_PASSPORT (ID),
    FOREIGN KEY (NOMENCLATURE_ID)
        REFERENCES TECH.NOMENCLATURE (ID),
    FOREIGN KEY (STATION_PATH_ID)
        REFERENCES TECH.STATION_PATH (ID)
);

CREATE TABLE TECH.WAGON_PASSPORT
(
    ID       BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    TYPE     VARCHAR(255) NOT NULL,
    NUMBER   VARCHAR(255) NOT NULL,
    WEIGHT   DOUBLE       NOT NULL,
    CAPACITY DOUBLE       NOT NULL
);

CREATE TABLE TECH.NATUR_LIST_WAGON
(
    NATURLIST_ID BIGINT NOT NULL,
    WAGON_ID     BIGINT NOT NULL,
    PRIMARY KEY (NATURLIST_ID, WAGON_ID),
    FOREIGN KEY (NATURLIST_ID)
        REFERENCES TECH.NATUR_LIST (ID),
    FOREIGN KEY (WAGON_ID)
        REFERENCES TECH.WAGON (ID)
);

CREATE TABLE TECH.USER_ROLES
(
    USER_ID INTEGER NOT NULL,
    ROLE_ID INTEGER NOT NULL,
    PRIMARY KEY (USER_ID, ROLE_ID),
    FOREIGN KEY (USER_ID)
        REFERENCES TECH.USER (USERID),
    FOREIGN KEY (ROLE_ID)
        REFERENCES TECH.ROLE (ROLEID)
);