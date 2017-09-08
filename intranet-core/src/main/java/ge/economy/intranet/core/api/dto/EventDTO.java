package ge.economy.intranet.core.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ge.economy.intranet.core.jsonhelper.JsonDateTimeSerializeSupport;
import ge.economy.intranet.database.database.Tables;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jooq.Record;

public class EventDTO
{
    private Integer id;
    @JsonSerialize(using=JsonDateTimeSerializeSupport.class)
    private Date start;
    @JsonSerialize(using=JsonDateTimeSerializeSupport.class)
    private Date end;
    private String title;
    private String description;
    private Integer userId;
    private String userFirstName;
    private String userLastName;
    private String hallName;
    private String hallDescription;

    public static EventDTO translate(Record record)
    {
        EventDTO dto = new EventDTO();
        dto.setId((Integer)record.getValue(Tables.RESERVATION.ID));
        dto.setTitle((String)record.getValue(Tables.RESERVATION.NAME));
        dto.setDescription((String)record.getValue(Tables.RESERVATION.DESCRIPTION));
        dto.setStart((Date)record.getValue(Tables.RESERVATION.START_DATE));
        dto.setEnd((Date)record.getValue(Tables.RESERVATION.END_DATE));
        dto.setUserId((Integer)record.getValue(Tables.RESERVATION.USER_ID));
        dto.setUserFirstName((String)record.getValue(Tables.PERSONAL.FIRST_NAME));
        dto.setUserLastName((String)record.getValue(Tables.PERSONAL.LAST_NAME));
        dto.setHallName((String)record.getValue(Tables.HALL.NAME));
        dto.setHallDescription((String)record.getValue(Tables.HALL.DESCRIPTION));
        return dto;
    }

    public static List<EventDTO> translateArray(List<Record> records)
    {
        ArrayList<EventDTO> list = new ArrayList();
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

    public Date getStart()
    {
        return this.start;
    }

    public void setStart(Date start)
    {
        this.start = start;
    }

    public Date getEnd()
    {
        return this.end;
    }

    public void setEnd(Date end)
    {
        this.end = end;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Integer getUserId()
    {
        return this.userId;
    }

    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public String getUserFirstName()
    {
        return this.userFirstName;
    }

    public void setUserFirstName(String userFirstName)
    {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName()
    {
        return this.userLastName;
    }

    public void setUserLastName(String userLastName)
    {
        this.userLastName = userLastName;
    }

    public String getHallName()
    {
        return this.hallName;
    }

    public void setHallName(String hallName)
    {
        this.hallName = hallName;
    }

    public String getHallDescription()
    {
        return this.hallDescription;
    }

    public void setHallDescription(String hallDescription)
    {
        this.hallDescription = hallDescription;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
