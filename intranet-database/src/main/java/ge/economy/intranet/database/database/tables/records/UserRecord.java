package ge.economy.intranet.database.database.tables.records;

import ge.economy.intranet.database.database.tables.User;
import java.util.Date;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

public class UserRecord
		extends UpdatableRecordImpl<UserRecord>
		implements Record6<Integer, String, String, String, Date, Integer>
{
	private static final long serialVersionUID = 1543669532L;

	public void setId(Integer value)
	{
		setValue(0, value);
	}

	public Integer getId()
	{
		return (Integer)getValue(0);
	}

	public void setUserName(String value)
	{
		setValue(1, value);
	}

	public String getUserName()
	{
		return (String)getValue(1);
	}

	public void setPassword(String value)
	{
		setValue(2, value);
	}

	public String getPassword()
	{
		return (String)getValue(2);
	}

	public void setEmail(String value)
	{
		setValue(3, value);
	}

	public String getEmail()
	{
		return (String)getValue(3);
	}

	public void setBirthDate(Date value)
	{
		setValue(4, value);
	}

	public Date getBirthDate()
	{
		return (Date)getValue(4);
	}

	public void setStatusId(Integer value)
	{
		setValue(5, value);
	}

	public Integer getStatusId()
	{
		return (Integer)getValue(5);
	}

	public Record1<Integer> key()
	{
		return (Record1)super.key();
	}

	public Row6<Integer, String, String, String, Date, Integer> fieldsRow()
	{
		return (Row6)super.fieldsRow();
	}

	public Row6<Integer, String, String, String, Date, Integer> valuesRow()
	{
		return (Row6)super.valuesRow();
	}

	public Field<Integer> field1()
	{
		return User.USER.ID;
	}

	public Field<String> field2()
	{
		return User.USER.USER_NAME;
	}

	public Field<String> field3()
	{
		return User.USER.PASSWORD;
	}

	public Field<String> field4()
	{
		return User.USER.EMAIL;
	}

	public Field<Date> field5()
	{
		return User.USER.BIRTH_DATE;
	}

	public Field<Integer> field6()
	{
		return User.USER.STATUS_ID;
	}

	public Integer value1()
	{
		return getId();
	}

	public String value2()
	{
		return getUserName();
	}

	public String value3()
	{
		return getPassword();
	}

	public String value4()
	{
		return getEmail();
	}

	public Date value5()
	{
		return getBirthDate();
	}

	public Integer value6()
	{
		return getStatusId();
	}

	public UserRecord value1(Integer value)
	{
		setId(value);
		return this;
	}

	public UserRecord value2(String value)
	{
		setUserName(value);
		return this;
	}

	public UserRecord value3(String value)
	{
		setPassword(value);
		return this;
	}

	public UserRecord value4(String value)
	{
		setEmail(value);
		return this;
	}

	public UserRecord value5(Date value)
	{
		setBirthDate(value);
		return this;
	}

	public UserRecord value6(Integer value)
	{
		setStatusId(value);
		return this;
	}

	public UserRecord values(Integer value1, String value2, String value3, String value4, Date value5, Integer value6)
	{
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		return this;
	}

	public UserRecord()
	{
		super(User.USER);
	}

	public UserRecord(Integer id, String userName, String password, String email, Date birthDate, Integer statusId)
	{
		super(User.USER);

		setValue(0, id);
		setValue(1, userName);
		setValue(2, password);
		setValue(3, email);
		setValue(4, birthDate);
		setValue(5, statusId);
	}
}
