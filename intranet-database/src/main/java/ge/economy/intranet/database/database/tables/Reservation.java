/**
 * This class is generated by jOOQ
 */
package ge.economy.intranet.database.database.tables;


import ge.economy.intranet.database.converter.TimestampConverter;
import ge.economy.intranet.database.database.Keys;
import ge.economy.intranet.database.database.Public;
import ge.economy.intranet.database.database.tables.records.ReservationRecord;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Reservation extends TableImpl<ReservationRecord> {

	private static final long serialVersionUID = -5479523;

	/**
	 * The reference instance of <code>public.reservation</code>
	 */
	public static final Reservation RESERVATION = new Reservation();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<ReservationRecord> getRecordType() {
		return ReservationRecord.class;
	}

	/**
	 * The column <code>public.reservation.id</code>.
	 */
	public final TableField<ReservationRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>public.reservation.hall_id</code>.
	 */
	public final TableField<ReservationRecord, Integer> HALL_ID = createField("hall_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.reservation.start_date</code>.
	 */
	public final TableField<ReservationRecord, Date> START_DATE = createField("start_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "", new TimestampConverter());

	/**
	 * The column <code>public.reservation.end_date</code>.
	 */
	public final TableField<ReservationRecord, Date> END_DATE = createField("end_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "", new TimestampConverter());

	/**
	 * The column <code>public.reservation.name</code>.
	 */
	public final TableField<ReservationRecord, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.reservation.description</code>.
	 */
	public final TableField<ReservationRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR, this, "");

	/**
	 * The column <code>public.reservation.user_id</code>.
	 */
	public final TableField<ReservationRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.reservation.organisation_id</code>.
	 */
	public final TableField<ReservationRecord, Integer> ORGANISATION_ID = createField("organisation_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>public.reservation</code> table reference
	 */
	public Reservation() {
		this("reservation", null);
	}

	/**
	 * Create an aliased <code>public.reservation</code> table reference
	 */
	public Reservation(String alias) {
		this(alias, RESERVATION);
	}

	private Reservation(String alias, Table<ReservationRecord> aliased) {
		this(alias, aliased, null);
	}

	private Reservation(String alias, Table<ReservationRecord> aliased, Field<?>[] parameters) {
		super(alias, Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<ReservationRecord, Integer> getIdentity() {
		return Keys.IDENTITY_RESERVATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<ReservationRecord> getPrimaryKey() {
		return Keys.RESERVATION_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<ReservationRecord>> getKeys() {
		return Arrays.<UniqueKey<ReservationRecord>>asList(Keys.RESERVATION_PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Reservation as(String alias) {
		return new Reservation(alias, this);
	}

	/**
	 * Rename this table
	 */
	public Reservation rename(String name) {
		return new Reservation(name, null);
	}
}
