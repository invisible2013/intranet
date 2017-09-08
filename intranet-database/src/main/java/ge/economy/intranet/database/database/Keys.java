package ge.economy.intranet.database.database;

import ge.economy.intranet.database.database.tables.Group;
import ge.economy.intranet.database.database.tables.Hall;
import ge.economy.intranet.database.database.tables.Personal;
import ge.economy.intranet.database.database.tables.Position;
import ge.economy.intranet.database.database.tables.Reservation;
import ge.economy.intranet.database.database.tables.Status;
import ge.economy.intranet.database.database.tables.User;
import ge.economy.intranet.database.database.tables.records.GroupRecord;
import ge.economy.intranet.database.database.tables.records.HallRecord;
import ge.economy.intranet.database.database.tables.records.PersonalRecord;
import ge.economy.intranet.database.database.tables.records.PositionRecord;
import ge.economy.intranet.database.database.tables.records.ReservationRecord;
import ge.economy.intranet.database.database.tables.records.StatusRecord;
import ge.economy.intranet.database.database.tables.records.UserRecord;
import org.jooq.Identity;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.AbstractKeys;

public class Keys
{
	public static final Identity<GroupRecord, Integer> IDENTITY_GROUP = Identities0.IDENTITY_GROUP;
	public static final Identity<HallRecord, Integer> IDENTITY_HALL = Identities0.IDENTITY_HALL;
	public static final Identity<PersonalRecord, Integer> IDENTITY_PERSONAL = Identities0.IDENTITY_PERSONAL;
	public static final Identity<PositionRecord, Integer> IDENTITY_POSITION = Identities0.IDENTITY_POSITION;
	public static final Identity<ReservationRecord, Integer> IDENTITY_RESERVATION = Identities0.IDENTITY_RESERVATION;
	public static final Identity<StatusRecord, Integer> IDENTITY_STATUS = Identities0.IDENTITY_STATUS;
	public static final Identity<UserRecord, Integer> IDENTITY_USER = Identities0.IDENTITY_USER;
	public static final UniqueKey<GroupRecord> GROUP_PKEY = UniqueKeys0.GROUP_PKEY;
	public static final UniqueKey<HallRecord> HALL_PKEY = UniqueKeys0.HALL_PKEY;
	public static final UniqueKey<PersonalRecord> PERSONAL_PKEY = UniqueKeys0.PERSONAL_PKEY;
	public static final UniqueKey<PositionRecord> POSITION_PKEY = UniqueKeys0.POSITION_PKEY;
	public static final UniqueKey<ReservationRecord> RESERVATION_PKEY = UniqueKeys0.RESERVATION_PKEY;
	public static final UniqueKey<StatusRecord> STATUS_PKEY = UniqueKeys0.STATUS_PKEY;
	public static final UniqueKey<UserRecord> USER_PKEY = UniqueKeys0.USER_PKEY;

	private static class Identities0
			extends AbstractKeys
	{
		public static Identity<GroupRecord, Integer> IDENTITY_GROUP = createIdentity(Group.GROUP, Group.GROUP.ID);
		public static Identity<HallRecord, Integer> IDENTITY_HALL = createIdentity(Hall.HALL, Hall.HALL.ID);
		public static Identity<PersonalRecord, Integer> IDENTITY_PERSONAL = createIdentity(Personal.PERSONAL, Personal.PERSONAL.ID);
		public static Identity<PositionRecord, Integer> IDENTITY_POSITION = createIdentity(Position.POSITION, Position.POSITION.ID);
		public static Identity<ReservationRecord, Integer> IDENTITY_RESERVATION = createIdentity(Reservation.RESERVATION, Reservation.RESERVATION.ID);
		public static Identity<StatusRecord, Integer> IDENTITY_STATUS = createIdentity(Status.STATUS, Status.STATUS.ID);
		public static Identity<UserRecord, Integer> IDENTITY_USER = createIdentity(User.USER, User.USER.ID);
	}

	private static class UniqueKeys0
			extends AbstractKeys
	{
		public static final UniqueKey<GroupRecord> GROUP_PKEY = createUniqueKey(Group.GROUP, new TableField[] { Group.GROUP.ID });
		public static final UniqueKey<HallRecord> HALL_PKEY = createUniqueKey(Hall.HALL, new TableField[] { Hall.HALL.ID });
		public static final UniqueKey<PersonalRecord> PERSONAL_PKEY = createUniqueKey(Personal.PERSONAL, new TableField[] { Personal.PERSONAL.ID });
		public static final UniqueKey<PositionRecord> POSITION_PKEY = createUniqueKey(Position.POSITION, new TableField[] { Position.POSITION.ID });
		public static final UniqueKey<ReservationRecord> RESERVATION_PKEY = createUniqueKey(Reservation.RESERVATION, new TableField[] { Reservation.RESERVATION.ID });
		public static final UniqueKey<StatusRecord> STATUS_PKEY = createUniqueKey(Status.STATUS, new TableField[] { Status.STATUS.ID });
		public static final UniqueKey<UserRecord> USER_PKEY = createUniqueKey(User.USER, new TableField[] { User.USER.ID });
	}
}
