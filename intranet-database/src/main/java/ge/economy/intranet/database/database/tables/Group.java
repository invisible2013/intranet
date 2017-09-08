package ge.economy.intranet.database.database.tables;

import ge.economy.intranet.database.database.Keys;
import ge.economy.intranet.database.database.Public;
import ge.economy.intranet.database.database.tables.records.GroupRecord;
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

public class Group
        extends TableImpl<GroupRecord>
{
    private static final long serialVersionUID = -1943707053L;
    public static final Group GROUP = new Group();

    public Class<GroupRecord> getRecordType()
    {
        return GroupRecord.class;
    }

    public final TableField<GroupRecord, Integer> ID = createField("id", SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");
    public final TableField<GroupRecord, String> NAME = createField("name", SQLDataType.VARCHAR, this, "");

    public Group()
    {
        this("group", null);
    }

    public Group(String alias)
    {
        this(alias, GROUP);
    }

    private Group(String alias, Table<GroupRecord> aliased)
    {
        this(alias, aliased, null);
    }

    private Group(String alias, Table<GroupRecord> aliased, Field<?>[] parameters)
    {
        super(alias, Public.PUBLIC, aliased, parameters, "");
    }

    public Identity<GroupRecord, Integer> getIdentity()
    {
        return Keys.IDENTITY_GROUP;
    }

    public UniqueKey<GroupRecord> getPrimaryKey()
    {
        return Keys.GROUP_PKEY;
    }

    public List<UniqueKey<GroupRecord>> getKeys()
    {
        return Arrays.asList(new UniqueKey[] { Keys.GROUP_PKEY });
    }

    public Group as(String alias)
    {
        return new Group(alias, this);
    }

    public Group rename(String name)
    {
        return new Group(name, null);
    }
}
