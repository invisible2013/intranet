package ge.economy.intranet.database.database.tables.records;

import ge.economy.intranet.database.database.tables.Status;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;

public class StatusRecord
        extends UpdatableRecordImpl<StatusRecord>
        implements Record2<Integer, String>
{
    private static final long serialVersionUID = -252555341L;

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

    public Record1<Integer> key()
    {
        return (Record1)super.key();
    }

    public Row2<Integer, String> fieldsRow()
    {
        return (Row2)super.fieldsRow();
    }

    public Row2<Integer, String> valuesRow()
    {
        return (Row2)super.valuesRow();
    }

    public Field<Integer> field1()
    {
        return Status.STATUS.ID;
    }

    public Field<String> field2()
    {
        return Status.STATUS.NAME;
    }

    public Integer value1()
    {
        return getId();
    }

    public String value2()
    {
        return getName();
    }

    public StatusRecord value1(Integer value)
    {
        setId(value);
        return this;
    }

    public StatusRecord value2(String value)
    {
        setName(value);
        return this;
    }

    public StatusRecord values(Integer value1, String value2)
    {
        value1(value1);
        value2(value2);
        return this;
    }

    public StatusRecord()
    {
        super(Status.STATUS);
    }

    public StatusRecord(Integer id, String name)
    {
        super(Status.STATUS);

        setValue(0, id);
        setValue(1, name);
    }
}
