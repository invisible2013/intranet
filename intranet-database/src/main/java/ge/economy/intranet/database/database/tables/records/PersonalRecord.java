package ge.economy.intranet.database.database.tables.records;

import ge.economy.intranet.database.database.tables.Personal;
import java.util.Date;
import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record13;
import org.jooq.Row13;
import org.jooq.impl.UpdatableRecordImpl;

public class PersonalRecord
        extends UpdatableRecordImpl<PersonalRecord>
        implements Record13<Integer, Integer, Integer, Integer, String, String, String, Date, String, String, String, Integer, Integer>
{
    private static final long serialVersionUID = -542283207L;

    public void setId(Integer value)
    {
        setValue(0, value);
    }

    public Integer getId()
    {
        return (Integer)getValue(0);
    }

    public void setOrganisationId(Integer value)
    {
        setValue(1, value);
    }

    public Integer getOrganisationId()
    {
        return (Integer)getValue(1);
    }

    public void setStructureId(Integer value)
    {
        setValue(2, value);
    }

    public Integer getStructureId()
    {
        return (Integer)getValue(2);
    }

    public void setPositionId(Integer value)
    {
        setValue(3, value);
    }

    public Integer getPositionId()
    {
        return (Integer)getValue(3);
    }

    public void setFirstName(String value)
    {
        setValue(4, value);
    }

    public String getFirstName()
    {
        return (String)getValue(4);
    }

    public void setLastName(String value)
    {
        setValue(5, value);
    }

    public String getLastName()
    {
        return (String)getValue(5);
    }

    public void setMail(String value)
    {
        setValue(6, value);
    }

    public String getMail()
    {
        return (String)getValue(6);
    }

    public void setBirthDate(Date value)
    {
        setValue(7, value);
    }

    public Date getBirthDate()
    {
        return (Date)getValue(7);
    }

    public void setPidNumber(String value)
    {
        setValue(8, value);
    }

    public String getPidNumber()
    {
        return (String)getValue(8);
    }

    public void setPhoneNumber(String value)
    {
        setValue(9, value);
    }

    public String getPhoneNumber()
    {
        return (String)getValue(9);
    }

    public void setAddress(String value)
    {
        setValue(10, value);
    }

    public String getAddress()
    {
        return (String)getValue(10);
    }

    public void setGroupId(Integer value)
    {
        setValue(11, value);
    }

    public Integer getGroupId()
    {
        return (Integer)getValue(11);
    }

    public void setStatusId(Integer value)
    {
        setValue(12, value);
    }

    public Integer getStatusId()
    {
        return (Integer)getValue(12);
    }

    public Record1<Integer> key()
    {
        return (Record1)super.key();
    }

    public Row13<Integer, Integer, Integer, Integer, String, String, String, Date, String, String, String, Integer, Integer> fieldsRow()
    {
        return (Row13)super.fieldsRow();
    }

    public Row13<Integer, Integer, Integer, Integer, String, String, String, Date, String, String, String, Integer, Integer> valuesRow()
    {
        return (Row13)super.valuesRow();
    }

    public Field<Integer> field1()
    {
        return Personal.PERSONAL.ID;
    }

    public Field<Integer> field2()
    {
        return Personal.PERSONAL.ORGANISATION_ID;
    }

    public Field<Integer> field3()
    {
        return Personal.PERSONAL.STRUCTURE_ID;
    }

    public Field<Integer> field4()
    {
        return Personal.PERSONAL.POSITION_ID;
    }

    public Field<String> field5()
    {
        return Personal.PERSONAL.FIRST_NAME;
    }

    public Field<String> field6()
    {
        return Personal.PERSONAL.LAST_NAME;
    }

    public Field<String> field7()
    {
        return Personal.PERSONAL.MAIL;
    }

    public Field<Date> field8()
    {
        return Personal.PERSONAL.BIRTH_DATE;
    }

    public Field<String> field9()
    {
        return Personal.PERSONAL.PID_NUMBER;
    }

    public Field<String> field10()
    {
        return Personal.PERSONAL.PHONE_NUMBER;
    }

    public Field<String> field11()
    {
        return Personal.PERSONAL.ADDRESS;
    }

    public Field<Integer> field12()
    {
        return Personal.PERSONAL.GROUP_ID;
    }

    public Field<Integer> field13()
    {
        return Personal.PERSONAL.STATUS_ID;
    }

    public Integer value1()
    {
        return getId();
    }

    public Integer value2()
    {
        return getOrganisationId();
    }

    public Integer value3()
    {
        return getStructureId();
    }

    public Integer value4()
    {
        return getPositionId();
    }

    public String value5()
    {
        return getFirstName();
    }

    public String value6()
    {
        return getLastName();
    }

    public String value7()
    {
        return getMail();
    }

    public Date value8()
    {
        return getBirthDate();
    }

    public String value9()
    {
        return getPidNumber();
    }

    public String value10()
    {
        return getPhoneNumber();
    }

    public String value11()
    {
        return getAddress();
    }

    public Integer value12()
    {
        return getGroupId();
    }

    public Integer value13()
    {
        return getStatusId();
    }

    public PersonalRecord value1(Integer value)
    {
        setId(value);
        return this;
    }

    public PersonalRecord value2(Integer value)
    {
        setOrganisationId(value);
        return this;
    }

    public PersonalRecord value3(Integer value)
    {
        setStructureId(value);
        return this;
    }

    public PersonalRecord value4(Integer value)
    {
        setPositionId(value);
        return this;
    }

    public PersonalRecord value5(String value)
    {
        setFirstName(value);
        return this;
    }

    public PersonalRecord value6(String value)
    {
        setLastName(value);
        return this;
    }

    public PersonalRecord value7(String value)
    {
        setMail(value);
        return this;
    }

    public PersonalRecord value8(Date value)
    {
        setBirthDate(value);
        return this;
    }

    public PersonalRecord value9(String value)
    {
        setPidNumber(value);
        return this;
    }

    public PersonalRecord value10(String value)
    {
        setPhoneNumber(value);
        return this;
    }

    public PersonalRecord value11(String value)
    {
        setAddress(value);
        return this;
    }

    public PersonalRecord value12(Integer value)
    {
        setGroupId(value);
        return this;
    }

    public PersonalRecord value13(Integer value)
    {
        setStatusId(value);
        return this;
    }

    public PersonalRecord values(Integer value1, Integer value2, Integer value3, Integer value4, String value5, String value6, String value7, Date value8, String value9, String value10, String value11, Integer value12, Integer value13)
    {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        return this;
    }

    public PersonalRecord()
    {
        super(Personal.PERSONAL);
    }

    public PersonalRecord(Integer id, Integer organisationId, Integer structureId, Integer positionId, String firstName, String lastName, String mail, Date birthDate, String pidNumber, String phoneNumber, String address, Integer groupId, Integer statusId)
    {
        super(Personal.PERSONAL);

        setValue(0, id);
        setValue(1, organisationId);
        setValue(2, structureId);
        setValue(3, positionId);
        setValue(4, firstName);
        setValue(5, lastName);
        setValue(6, mail);
        setValue(7, birthDate);
        setValue(8, pidNumber);
        setValue(9, phoneNumber);
        setValue(10, address);
        setValue(11, groupId);
        setValue(12, statusId);
    }
}
