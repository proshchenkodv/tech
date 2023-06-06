--liquibase formatted sql
--changeset proshchenkodv:SSD-32 runOnChange:true splitStatements:false
DROP TRIGGER IF EXISTS default_dmt_oper_warehouse_gp_bi ON supersklad.default_dmt_oper_warehouse_gp;
CREATE or REPLACE FUNCTION supersklad.default_dmt_oper_warehouse_gp_bi() RETURNS trigger AS
$$
BEGIN
    IF TG_OP = 'INSERT' THEN
        IF new.id IS NULL THEN
            new.id := nextval('supersklad.default_dmt_oper_warehouse_gp_s');
        END IF;
    END IF;
    new.org_id := 902;
    new.warehouse_name :=
            (SELECT d.warehouse_name FROM supersklad.dct_branch d where d.warehouse_oebs_org_id = new.org_id);
    RETURN
        new;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER default_dmt_oper_warehouse_gp_bi
    BEFORE INSERT
    ON supersklad.default_dmt_oper_warehouse_gp
    FOR EACH ROW
EXECUTE FUNCTION supersklad.default_dmt_oper_warehouse_gp_bi();