package ge.economy.intranet.database.database.tables.records;

import ge.economy.intranet.database.database.tables.Hall;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;

public class HallRecord
        extends UpdatableRecordImpl<HallRecord>
        implements Record3<Integer, String, String>
{
    private static final long serialVersionUID = 2138057384L;

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

    public void setDescription(String value)
    {
        setValue(2, value);
    }

    public String getDescription()
    {
        return (String)getValue(2);
    }

    public Record1<Integer> key()
    {
        return (Record1)super.key();
    }

    public Row3<Integer, String, String> fieldsRow()
    {
        return (Row3)super.fieldsRow();
    }

    public Row3<Integer, String, String> valuesRow()
    {
        return (Row3)super.valuesRow();
    }

    public Field<Integer> field1()
    {
        return Hall.HALL.ID;
    }

    public Field<String> field2()
    {
        return Hall.HALL.NAME;
    }

    public Field<String> field3()
    {
        return Hall.HALL.DESCRIPTION;
    }

    public Integer value1()
    {
        return getId();
    }

    public String value2()
    {
        return getName();
    }

    public String value3()
    {
        return getDescription();
    }

    public HallRecord value1(Integer value)
    {
        setId(value);
        return this;
    }

    public HallRecord value2(String value)
    {
        setName(value);
        return this;
    }

    public HallRecord value3(String value)
    {
        setDescription(value);
        return this;
    }

    public HallRecord values(Integer value1, String value2, String value3)
    {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    public HallRecord()
    {
        super(Hall.HALL);
    }

    public HallRecord(Integer id, String name, String description)
    {
        super(Hall.HALL);

        setValue(0, id);
        setValue(1, name);
        setValue(2, description);
    }
}
