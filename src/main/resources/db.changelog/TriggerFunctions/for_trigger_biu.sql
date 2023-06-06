--liquibase formatted sql
--changeset proshchenkodv:SSD-12 runOnChange:true splitStatements:false
create or replace function supersklad.for_trigger_biu() returns trigger as
$$
begin
    IF TG_OP = 'INSERT' THEN
        new.ins_date := clock_timestamp();
        new.mod_date := clock_timestamp();
    END IF;
    IF TG_OP = 'UPDATE' THEN
        new.mod_date := clock_timestamp();
    END IF;
    RETURN new;
end;
$$ language plpgsql;