package ge.economy.intranet.core.api.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import ge.economy.intranet.core.jsonhelper.JsonDateTimeSerializeSupport;
import ge.economy.intranet.database.database.Tables;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jooq.Record;

public class ReservationDTO
{
    private Integer id;
    @JsonSerialize(using=JsonDateTimeSerializeSupport.class)
    private Date startDate;
    @JsonSerialize(using=JsonDateTimeSerializeSupport.class)
    private Date endDate;
    private String description;

    public static ReservationDTO translate(Record record)
    {
        ReservationDTO dto = new ReservationDTO();
        dto.setId((Integer)record.getValue(Tables.RESERVATION.ID));
        dto.setStartDate((Date)record.getValue(Tables.RESERVATION.START_DATE));
        dto.setEndDate((Date)record.getValue(Tables.RESERVATION.END_DATE));
        return dto;
    }

    public static List<ReservationDTO> translateArray(List<Record> records)
    {
        ArrayList<ReservationDTO> list = new ArrayList();
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

    public Date getStartDate()
    {
        return this.startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return this.endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
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
