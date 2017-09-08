package ge.economy.intranet.database.database.tables.records;

import ge.economy.intranet.database.database.tables.Reservation;
import java.util.Date;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;

public class ReservationRecord
        extends UpdatableRecordImpl<ReservationRecord>
        implements Record7<Integer, Integer, Date, Date, String, Integer, String>
{
    private static final long serialVersionUID = -746270178L;

    public void setId(Integer value)
    {
        setValue(0, value);
    }

    public Integer getId()
    {
        return (Integer)getValue(0);
    }

    public void setHallId(Integer value)
    {
        setValue(1, value);
    }

    public Integer getHallId()
    {
        return (Integer)getValue(1);
    }

    public void setStartDate(Date value)
    {
        setValue(2, value);
    }

    public Date getStartDate()
    {
        return (Date)getValue(2);
    }

    public void setEndDate(Date value)
    {
        setValue(3, value);
    }

    public Date getEndDate()
    {
        return (Date)getValue(3);
    }

    public void setDescription(String value)
    {
        setValue(4, value);
    }

    public String getDescription()
    {
        return (String)getValue(4);
    }

    public void setUserId(Integer value)
    {
        setValue(5, value);
    }

    public Integer getUserId()
    {
        return (Integer)getValue(5);
    }

    public void setName(String value)
    {
        setValue(6, value);
    }

    public String getName()
    {
        return (String)getValue(6);
    }

    public Record1<Integer> key()
    {
        return (Record1)super.key();
    }

    public Row7<Integer, Integer, Date, Date, String, Integer, String> fieldsRow()
    {
        return (Row7)super.fieldsRow();
    }

    public Row7<Integer, Integer, Date, Date, String, Integer, String> valuesRow()
    {
        return (Row7)super.valuesRow();
    }

    public Field<Integer> field1()
    {
        return Reservation.RESERVATION.ID;
    }

    public Field<Integer> field2()
    {
        return Reservation.RESERVATION.HALL_ID;
    }

    public Field<Date> field3()
    {
        return Reservation.RESERVATION.START_DATE;
    }

    public Field<Date> field4()
    {
        return Reservation.RESERVATION.END_DATE;
    }

    public Field<String> field5()
    {
        return Reservation.RESERVATION.DESCRIPTION;
    }

    public Field<Integer> field6()
    {
        return Reservation.RESERVATION.USER_ID;
    }

    public Field<String> field7()
    {
        return Reservation.RESERVATION.NAME;
    }

    public Integer value1()
    {
        return getId();
    }

    public Integer value2()
    {
        return getHallId();
    }

    public Date value3()
    {
        return getStartDate();
    }

    public Date value4()
    {
        return getEndDate();
    }

    public String value5()
    {
        return getDescription();
    }

    public Integer value6()
    {
        return getUserId();
    }

    public String value7()
    {
        return getName();
    }

    public ReservationRecord value1(Integer value)
    {
        setId(value);
        return this;
    }

    public ReservationRecord value2(Integer value)
    {
        setHallId(value);
        return this;
    }

    public ReservationRecord value3(Date value)
    {
        setStartDate(value);
        return this;
    }

    public ReservationRecord value4(Date value)
    {
        setEndDate(value);
        return this;
    }

    public ReservationRecord value5(String value)
    {
        setDescription(value);
        return this;
    }

    public ReservationRecord value6(Integer value)
    {
        setUserId(value);
        return this;
    }

    public ReservationRecord value7(String value)
    {
        setName(value);
        return this;
    }

    public ReservationRecord values(Integer value1, Integer value2, Date value3, Date value4, String value5, Integer value6, String value7)
    {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    public ReservationRecord()
    {
        super(Reservation.RESERVATION);
    }

    public ReservationRecord(Integer id, Integer hallId, Date startDate, Date endDate, String description, Integer userId, String name)
    {
        super(Reservation.RESERVATION);

        setValue(0, id);
        setValue(1, hallId);
        setValue(2, startDate);
        setValue(3, endDate);
        setValue(4, description);
        setValue(5, userId);
        setValue(6, name);
    }
}
