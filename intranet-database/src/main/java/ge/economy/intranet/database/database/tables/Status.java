package ge.economy.intranet.database.database.tables;

import ge.economy.intranet.database.database.Keys;
import ge.economy.intranet.database.database.Public;
import ge.economy.intranet.database.database.tables.records.StatusRecord;
import java.util.Arrays;
import java.util.List;
import org.jooq.DataType;
import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

public class Status
        extends TableImpl<StatusRecord>
{
    private static final long serialVersionUID = 1405120503L;
    public static final Status STATUS = new Status();

    public Class<StatusRecord> getRecordType()
    {
        return StatusRecord.class;
    }

    public final TableField<StatusRecord, Integer> ID = createField("id", SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");
    public final TableField<StatusRecord, String> NAME = createField("name", SQLDataType.VARCHAR, this, "");

    public Status()
    {
        this("status", null);
    }

    public Status(String alias)
    {
        this(alias, STATUS);
    }

    private Status(String alias, Table<StatusRecord> aliased)
    {
        this(alias, aliased, null);
    }

    private Status(String alias, Table<StatusRecord> aliased, Field<?>[] parameters)
    {
        super(alias, Public.PUBLIC, aliased, parameters, "");
    }

    public Identity<StatusRecord, Integer> getIdentity()
    {
        return Keys.IDENTITY_STATUS;
    }

    public UniqueKey<StatusRecord> getPrimaryKey()
    {
        return Keys.STATUS_PKEY;
    }

    public List<UniqueKey<StatusRecord>> getKeys()
    {
        return Arrays.asList(new UniqueKey[] { Keys.STATUS_PKEY });
    }

    public Status as(String alias)
    {
        return new Status(alias, this);
    }

    public Status rename(String name)
    {
        return new Status(name, null);
    }
}
