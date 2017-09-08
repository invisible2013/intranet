package ge.economy.intranet.database.database.tables;

import ge.economy.intranet.database.converter.TimestampConverter;
import ge.economy.intranet.database.database.Keys;
import ge.economy.intranet.database.database.Public;
import ge.economy.intranet.database.database.tables.records.PersonalRecord;
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

public class Personal
        extends TableImpl<PersonalRecord>
{
    private static final long serialVersionUID = -310503442L;
    public static final Personal PERSONAL = new Personal();

    public Class<PersonalRecord> getRecordType()
    {
        return PersonalRecord.class;
    }

    public final TableField<PersonalRecord, Integer> ID = createField("id", SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");
    public final TableField<PersonalRecord, Integer> ORGANISATION_ID = createField("organisation_id", SQLDataType.INTEGER.nullable(false), this, "");
    public final TableField<PersonalRecord, Integer> STRUCTURE_ID = createField("structure_id", SQLDataType.INTEGER.nullable(false), this, "");
    public final TableField<PersonalRecord, Integer> POSITION_ID = createField("position_id", SQLDataType.INTEGER.nullable(false), this, "");
    public final TableField<PersonalRecord, String> FIRST_NAME = createField("first_name", SQLDataType.VARCHAR, this, "");
    public final TableField<PersonalRecord, String> LAST_NAME = createField("last_name", SQLDataType.VARCHAR, this, "");
    public final TableField<PersonalRecord, String> MAIL = createField("mail", SQLDataType.VARCHAR, this, "");
    public final TableField<PersonalRecord, Date> BIRTH_DATE = createField("birth_date", SQLDataType.TIMESTAMP, this, "", new TimestampConverter());
    public final TableField<PersonalRecord, String> PID_NUMBER = createField("pid_number", SQLDataType.VARCHAR, this, "");
    public final TableField<PersonalRecord, String> PHONE_NUMBER = createField("phone_number", SQLDataType.VARCHAR, this, "");
    public final TableField<PersonalRecord, String> ADDRESS = createField("address", SQLDataType.VARCHAR, this, "");
    public final TableField<PersonalRecord, Integer> GROUP_ID = createField("group_id", SQLDataType.INTEGER.nullable(false), this, "");
    public final TableField<PersonalRecord, Integer> STATUS_ID = createField("status_id", SQLDataType.INTEGER.nullable(false), this, "");

    public Personal()
    {
        this("personal", null);
    }

    public Personal(String alias)
    {
        this(alias, PERSONAL);
    }

    private Personal(String alias, Table<PersonalRecord> aliased)
    {
        this(alias, aliased, null);
    }

    private Personal(String alias, Table<PersonalRecord> aliased, Field<?>[] parameters)
    {
        super(alias, Public.PUBLIC, aliased, parameters, "");
    }

    public Identity<PersonalRecord, Integer> getIdentity()
    {
        return Keys.IDENTITY_PERSONAL;
    }

    public UniqueKey<PersonalRecord> getPrimaryKey()
    {
        return Keys.PERSONAL_PKEY;
    }

    public List<UniqueKey<PersonalRecord>> getKeys()
    {
        return Arrays.asList(new UniqueKey[] { Keys.PERSONAL_PKEY });
    }

    public Personal as(String alias)
    {
        return new Personal(alias, this);
    }

    public Personal rename(String name)
    {
        return new Personal(name, null);
    }
}
