package ge.economy.intranet.core.api.dto;

import ge.economy.intranet.database.database.Tables;
import ge.economy.intranet.database.database.tables.Group;
import ge.economy.intranet.database.database.tables.Personal;
import ge.economy.intranet.database.database.tables.Status;
import java.util.ArrayList;
import java.util.List;
import org.jooq.Record;

public class PersonalDTO
{
    private Integer id;
    private Integer groupId;
    private Integer statusId;
    private String firstName;
    private String lastName;
    private String mail;
    private String groupName;
    private String statusName;
    public static int INACTIVE_PERSONAL = 2;
    public static int ACTIVE_PERSONAL = 1;
    public static int USER_GROUP = 1;
    public static int ADMIN_GROUP = 2;
    public static int POSITION_DEFAULT = 7;
    public static int STRUCTURE_ECONOMY = 1;
    public static int ORGANISATION_ECONOMY = 1;

    public static PersonalDTO translate(Record record)
    {
        PersonalDTO dto = new PersonalDTO();
        dto.setId((Integer)record.getValue(Tables.PERSONAL.ID));
        dto.setFirstName((String)record.getValue(Tables.PERSONAL.FIRST_NAME));
        dto.setLastName((String)record.getValue(Tables.PERSONAL.LAST_NAME));
        dto.setMail((String)record.getValue(Tables.PERSONAL.MAIL));
        dto.setGroupId((Integer)record.getValue(Tables.PERSONAL.GROUP_ID));
        dto.setStatusId((Integer)record.getValue(Tables.PERSONAL.STATUS_ID));
        dto.setGroupName((String)record.getValue(Tables.GROUP.NAME));
        dto.setStatusName((String)record.getValue(Tables.STATUS.NAME));
        return dto;
    }

    public static List<PersonalDTO> translateArray(List<Record> records)
    {
        ArrayList<PersonalDTO> list = new ArrayList();
        for (Record record : records) {
            list.add(translate(record));
        }
        return list;
    }

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getMail()
    {
        return this.mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public Integer getGroupId()
    {
        return this.groupId;
    }

    public void setGroupId(Integer groupId)
    {
        this.groupId = groupId;
    }

    public Integer getStatusId()
    {
        return this.statusId;
    }

    public void setStatusId(Integer statusId)
    {
        this.statusId = statusId;
    }

    public String getGroupName()
    {
        return this.groupName;
    }

    public void setGroupName(String groupName)
    {
        this.groupName = groupName;
    }

    public String getStatusName()
    {
        return this.statusName;
    }

    public void setStatusName(String statusName)
    {
        this.statusName = statusName;
    }
}
