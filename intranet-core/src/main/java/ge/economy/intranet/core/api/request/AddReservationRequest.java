package ge.economy.intranet.core.api.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ge.economy.intranet.core.jsonhelper.JsonDateTimeDeserializeSupport;

import java.util.Date;

public class AddReservationRequest
{
    private int id;
    private int hallId;
    private int userId;
    private int organisationId;
    private String name;
    private String description;
    @JsonDeserialize(using=JsonDateTimeDeserializeSupport.class)
    private Date startDate;
    @JsonDeserialize(using=JsonDateTimeDeserializeSupport.class)
    private Date endDate;

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getHallId()
    {
        return this.hallId;
    }

    public void setHallId(int hallId)
    {
        this.hallId = hallId;
    }

    public int getUserId()
    {
        return this.userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getStartDate()
    {
        return this.startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Date getEndDate()
    {
        return this.endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public int getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(int organisationId) {
        this.organisationId = organisationId;
    }
}
