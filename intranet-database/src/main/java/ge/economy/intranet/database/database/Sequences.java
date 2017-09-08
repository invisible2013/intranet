package ge.economy.intranet.database.database;

import org.jooq.DataType;
import org.jooq.Sequence;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.SequenceImpl;

public class Sequences
{
	public static final Sequence<Long> GROUP_ID_SEQ = new SequenceImpl("group_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false));
	public static final Sequence<Long> HALL_ID_SEQ = new SequenceImpl("hall_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false));
	public static final Sequence<Long> PERSONAL_ID_SEQ = new SequenceImpl("personal_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false));
	public static final Sequence<Long> POSITION_ID_SEQ = new SequenceImpl("position_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false));
	public static final Sequence<Long> RESERVATION_ID_SEQ = new SequenceImpl("reservation_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false));
	public static final Sequence<Long> STATUS_ID_SEQ = new SequenceImpl("status_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false));
	public static final Sequence<Long> USER_ID_SEQ = new SequenceImpl("user_id_seq", Public.PUBLIC, SQLDataType.BIGINT.nullable(false));
}
