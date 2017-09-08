package ge.economy.intranet.database.database.tables;

import ge.economy.intranet.database.database.Keys;
import ge.economy.intranet.database.database.Public;
import ge.economy.intranet.database.database.tables.records.PositionRecord;
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

public class Position
        extends TableImpl<PositionRecord>
{
    private static final long serialVersionUID = 113290264L;
    public static final Position POSITION = new Position();

    public Class<PositionRecord> getRecordType()
    {
        return PositionRecord.class;
    }

    public final TableField<PositionRecord, Integer> ID = createField("id", SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");
    public final TableField<PositionRecord, String> NAME = createField("name", SQLDataType.VARCHAR, this, "");
    public final TableField<PositionRecord, Integer> POSITION_ = createField("position", SQLDataType.INTEGER, this, "");
    public final TableField<PositionRecord, String> LDAP_KEY = createField("ldap_key", SQLDataType.VARCHAR, this, "");

    public Position()
    {
        this("position", null);
    }

    public Position(String alias)
    {
        this(alias, POSITION);
    }

    private Position(String alias, Table<PositionRecord> aliased)
    {
        this(alias, aliased, null);
    }

    private Position(String alias, Table<PositionRecord> aliased, Field<?>[] parameters)
    {
        super(alias, Public.PUBLIC, aliased, parameters, "");
    }

    public Identity<PositionRecord, Integer> getIdentity()
    {
        return Keys.IDENTITY_POSITION;
    }

    public UniqueKey<PositionRecord> getPrimaryKey()
    {
        return Keys.POSITION_PKEY;
    }

    public List<UniqueKey<PositionRecord>> getKeys()
    {
        return Arrays.asList(new UniqueKey[] { Keys.POSITION_PKEY });
    }

    public Position as(String alias)
    {
        return new Position(alias, this);
    }

    public Position rename(String name)
    {
        return new Position(name, null);
    }
}
