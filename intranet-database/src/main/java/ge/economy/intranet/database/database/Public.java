package ge.economy.intranet.database.database;

import ge.economy.intranet.database.database.tables.Group;
import ge.economy.intranet.database.database.tables.Hall;
import ge.economy.intranet.database.database.tables.Personal;
import ge.economy.intranet.database.database.tables.Position;
import ge.economy.intranet.database.database.tables.Reservation;
import ge.economy.intranet.database.database.tables.Status;
import ge.economy.intranet.database.database.tables.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jooq.Sequence;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;

public class Public
		extends SchemaImpl
{
	private static final long serialVersionUID = -199104930L;
	public static final Public PUBLIC = new Public();

	private Public()
	{
		super("public");
	}

	public final List<Sequence<?>> getSequences()
	{
		List result = new ArrayList();
		result.addAll(getSequences0());
		return result;
	}

	private final List<Sequence<?>> getSequences0()
	{
		return Arrays.asList(new Sequence[] { Sequences.GROUP_ID_SEQ, Sequences.HALL_ID_SEQ, Sequences.PERSONAL_ID_SEQ, Sequences.POSITION_ID_SEQ, Sequences.RESERVATION_ID_SEQ, Sequences.STATUS_ID_SEQ, Sequences.USER_ID_SEQ });
	}

	public final List<Table<?>> getTables()
	{
		List result = new ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final List<Table<?>> getTables0()
	{
		return Arrays.asList(new Table[] { Group.GROUP, Hall.HALL, Personal.PERSONAL, Position.POSITION, Reservation.RESERVATION, Status.STATUS, User.USER });
	}
}
