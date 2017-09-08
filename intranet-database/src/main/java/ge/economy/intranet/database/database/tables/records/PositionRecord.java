package ge.economy.intranet.database.database.tables.records;

import ge.economy.intranet.database.database.tables.Position;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;

public class PositionRecord
        extends UpdatableRecordImpl<PositionRecord>
        implements Record4<Integer, String, Integer, String>
{
    private static final long serialVersionUID = 1748193970L;

    public void setId(Integer value)
    {
        setValue(0, value);
    }

    public Integer getId()
    {
        return (Integer)getValue(0);
    }

    public void setName(String value)
    {
        setValue(1, value);
    }

    public String getName()
    {
        return (String)getValue(1);
    }

    public void setPosition(Integer value)
    {
        setValue(2, value);
    }

    public Integer getPosition()
    {
        return (Integer)getValue(2);
    }

    public void setLdapKey(String value)
    {
        setValue(3, value);
    }

    public String getLdapKey()
    {
        return (String)getValue(3);
    }

    public Record1<Integer> key()
    {
        return (Record1)super.key();
    }

    public Row4<Integer, String, Integer, String> fieldsRow()
    {
        return (Row4)super.fieldsRow();
    }

    public Row4<Integer, String, Integer, String> valuesRow()
    {
        return (Row4)super.valuesRow();
    }

    public Field<Integer> field1()
    {
        return Position.POSITION.ID;
    }

    public Field<String> field2()
    {
        return Position.POSITION.NAME;
    }

    public Field<Integer> field3()
    {
        return Position.POSITION.POSITION_;
    }

    public Field<String> field4()
    {
        return Position.POSITION.LDAP_KEY;
    }

    public Integer value1()
    {
        return getId();
    }

    public String value2()
    {
        return getName();
    }

    public Integer value3()
    {
        return getPosition();
    }

    public String value4()
    {
        return getLdapKey();
    }

    public PositionRecord value1(Integer value)
    {
        setId(value);
        return this;
    }

    public PositionRecord value2(String value)
    {
        setName(value);
        return this;
    }

    public PositionRecord value3(Integer value)
    {
        setPosition(value);
        return this;
    }

    public PositionRecord value4(String value)
    {
        setLdapKey(value);
        return this;
    }

    public PositionRecord values(Integer value1, String value2, Integer value3, String value4)
    {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    public PositionRecord()
    {
        super(Position.POSITION);
    }

    public PositionRecord(Integer id, String name, Integer position, String ldapKey)
    {
        super(Position.POSITION);

        setValue(0, id);
        setValue(1, name);
        setValue(2, position);
        setValue(3, ldapKey);
    }
}
