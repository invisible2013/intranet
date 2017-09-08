package ge.economy.intranet.core.api.request;

public class AddPersonalRequest
{
    private Integer id;
    private String firstName;
    private String lastName;
    private String mail;
    private Integer groupId;
    private Integer statusId;

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
}
