package ge.economy.intranet.core.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ge.economy.intranet.core.jsonhelper.JsonDateSerializeSupport;
import ge.economy.intranet.database.database.Tables;
import ge.economy.intranet.database.database.tables.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jooq.Record;

public class UserDTO
{
    private Integer id;
    private String userName;
    private String email;
    @JsonSerialize(using=JsonDateSerializeSupport.class)
    private Date birthDate;
    private int statusId;
    private String statusName;

    public static UserDTO translate(Record record)
    {
        UserDTO dto = new UserDTO();
        dto.setId((Integer)record.getValue(Tables.USER.ID));
        dto.setUserName((String)record.getValue(Tables.USER.USER_NAME));
        dto.setEmail((String)record.getValue(Tables.USER.EMAIL));
        dto.setBirthDate((Date)record.getValue(Tables.USER.BIRTH_DATE));
        dto.setStatusId(((Integer)record.getValue(Tables.USER.STATUS_ID)).intValue());
        return dto;
    }

    public static List<UserDTO> translateArray(List<Record> records)
    {
        ArrayList<UserDTO> list = new ArrayList();
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

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Date getBirthDate()
    {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate)
    {
        this.birthDate = birthDate;
    }

    public int getStatusId()
    {
        return this.statusId;
    }

    public void setStatusId(int statusId)
    {
        this.statusId = statusId;
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
