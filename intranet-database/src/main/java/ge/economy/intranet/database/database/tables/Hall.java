package ge.economy.intranet.database.database.tables;

import ge.economy.intranet.database.database.Keys;
import ge.economy.intranet.database.database.Public;
import ge.economy.intranet.database.database.tables.records.HallRecord;
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

public class Hall
        extends TableImpl<HallRecord>
{
    private static final long serialVersionUID = -390297578L;
    public static final Hall HALL = new Hall();

    public Class<HallRecord> getRecordType()
    {
        return HallRecord.class;
    }

    public final TableField<HallRecord, Integer> ID = createField("id", SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");
    public final TableField<HallRecord, String> NAME = createField("name", SQLDataType.VARCHAR, this, "");
    public final TableField<HallRecord, String> DESCRIPTION = createField("description", SQLDataType.VARCHAR, this, "");

    public Hall()
    {
        this("hall", null);
    }

    public Hall(String alias)
    {
        this(alias, HALL);
    }

    private Hall(String alias, Table<HallRecord> aliased)
    {
        this(alias, aliased, null);
    }

    private Hall(String alias, Table<HallRecord> aliased, Field<?>[] parameters)
    {
        super(alias, Public.PUBLIC, aliased, parameters, "");
    }

    public Identity<HallRecord, Integer> getIdentity()
    {
        return Keys.IDENTITY_HALL;
    }

    public UniqueKey<HallRecord> getPrimaryKey()
    {
        return Keys.HALL_PKEY;
    }

    public List<UniqueKey<HallRecord>> getKeys()
    {
        return Arrays.asList(new UniqueKey[] { Keys.HALL_PKEY });
    }

    public Hall as(String alias)
    {
        return new Hall(alias, this);
    }

    public Hall rename(String name)
    {
        return new Hall(name, null);
    }
}
