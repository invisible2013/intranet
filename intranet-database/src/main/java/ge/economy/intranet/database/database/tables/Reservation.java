package ge.economy.intranet.database.database.tables;

import ge.economy.intranet.database.converter.TimestampConverter;
import ge.economy.intranet.database.database.Keys;
import ge.economy.intranet.database.database.Public;
import ge.economy.intranet.database.database.tables.records.ReservationRecord;
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

public class Reservation
        extends TableImpl<ReservationRecord>
{
    private static final long serialVersionUID = 1887404089L;
    public static final Reservation RESERVATION = new Reservation();

    public Class<ReservationRecord> getRecordType()
    {
        return ReservationRecord.class;
    }

    public final TableField<ReservationRecord, Integer> ID = createField("id", SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");
    public final TableField<ReservationRecord, Integer> HALL_ID = createField("hall_id", SQLDataType.INTEGER, this, "");
    public final TableField<ReservationRecord, Date> START_DATE = createField("start_date", SQLDataType.TIMESTAMP, this, "", new TimestampConverter());
    public final TableField<ReservationRecord, Date> END_DATE = createField("end_date", SQLDataType.TIMESTAMP, this, "", new TimestampConverter());
    public final TableField<ReservationRecord, String> DESCRIPTION = createField("description", SQLDataType.VARCHAR, this, "");
    public final TableField<ReservationRecord, Integer> USER_ID = createField("user_id", SQLDataType.INTEGER, this, "");
    public final TableField<ReservationRecord, String> NAME = createField("name", SQLDataType.VARCHAR, this, "");

    public Reservation()
    {
        this("reservation", null);
    }

    public Reservation(String alias)
    {
        this(alias, RESERVATION);
    }

    private Reservation(String alias, Table<ReservationRecord> aliased)
    {
        this(alias, aliased, null);
    }

    private Reservation(String alias, Table<ReservationRecord> aliased, Field<?>[] parameters)
    {
        super(alias, Public.PUBLIC, aliased, parameters, "");
    }

    public Identity<ReservationRecord, Integer> getIdentity()
    {
        return Keys.IDENTITY_RESERVATION;
    }

    public UniqueKey<ReservationRecord> getPrimaryKey()
    {
        return Keys.RESERVATION_PKEY;
    }

    public List<UniqueKey<ReservationRecord>> getKeys()
    {
        return Arrays.asList(new UniqueKey[] { Keys.RESERVATION_PKEY });
    }

    public Reservation as(String alias)
    {
        return new Reservation(alias, this);
    }

    public Reservation rename(String name)
    {
        return new Reservation(name, null);
    }
}
