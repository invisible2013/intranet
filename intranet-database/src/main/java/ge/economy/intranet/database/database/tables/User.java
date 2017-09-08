package ge.economy.intranet.database.database.tables;

import ge.economy.intranet.database.converter.TimestampConverter;
import ge.economy.intranet.database.database.Keys;
import ge.economy.intranet.database.database.Public;
import ge.economy.intranet.database.database.tables.records.UserRecord;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.jooq.DataType;
import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

public class User
        extends TableImpl<UserRecord>
{
    private static final long serialVersionUID = -405784471L;
    public static final User USER = new User();

    public Class<UserRecord> getRecordType()
    {
        return UserRecord.class;
    }

    public final TableField<UserRecord, Integer> ID = createField("id", SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");
    public final TableField<UserRecord, String> USER_NAME = createField("user_name", SQLDataType.VARCHAR, this, "");
    public final TableField<UserRecord, String> PASSWORD = createField("password", SQLDataType.VARCHAR, this, "");
    public final TableField<UserRecord, String> EMAIL = createField("email", SQLDataType.VARCHAR, this, "");
    public final TableField<UserRecord, Date> BIRTH_DATE = createField("birth_date", SQLDataType.TIMESTAMP, this, "", new TimestampConverter());
    public final TableField<UserRecord, Integer> STATUS_ID = createField("status_id", SQLDataType.INTEGER, this, "");

    public User()
    {
        this("user", null);
    }

    public User(String alias)
    {
        this(alias, USER);
    }

    private User(String alias, Table<UserRecord> aliased)
    {
        this(alias, aliased, null);
    }

    private User(String alias, Table<UserRecord> aliased, Field<?>[] parameters)
    {
        super(alias, Public.PUBLIC, aliased, parameters, "");
    }

    public Identity<UserRecord, Integer> getIdentity()
    {
        return Keys.IDENTITY_USER;
    }

    public UniqueKey<UserRecord> getPrimaryKey()
    {
        return Keys.USER_PKEY;
    }

    public List<UniqueKey<UserRecord>> getKeys()
    {
        return Arrays.asList(new UniqueKey[] { Keys.USER_PKEY });
    }

    public User as(String alias)
    {
        return new User(alias, this);
    }

    public User rename(String name)
    {
        return new User(name, null);
    }
}
