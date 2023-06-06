--liquibase formatted sql
-- Data USERS
--changeset proshchenkodv:SSD-61_1
INSERT INTO supersklad.at_user(cd_up, cd_coll, full_name, first_name, second_name, patronymic_name, short_name, phone, email, date_of_birth, remuneration_system, org_id, department_name, division_name, position_name, group_name, date_work, org_num, org_name, status)
VALUES (-1, -1, 'Сервисная запись диспетчера', 'Сервис','Сервис','Сервис','Сервис','79000000000','00@00.00','${now}','ОФИС',902,'Сервис','Сервис','Сервис','Сервис','${now}',1,'Протек-01 г. Москва', 1);

--liquibase formatted sql
-- Data DCT_ROLE
--changeset proshchenkodv:SSD-61_2
INSERT INTO supersklad.dct_role(role_name, status)
VALUES ('ROLE_DISPATCHER',1);

