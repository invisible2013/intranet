package ge.economy.intranet.core.response;

public class LDAPResponse
{
    private String nameInNamespace;
    private String title;
    private String cn;
    private String mail;
    private String telephoneNumber;
    private String firstOU;
    private String secondOU;

    public String getNameInNamespace()
    {
        return this.nameInNamespace;
    }

    public void setNameInNamespace(String nameInNamespace)
    {
        this.nameInNamespace = nameInNamespace;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getCn()
    {
        return this.cn;
    }

    public void setCn(String cn)
    {
        this.cn = cn;
    }

    public String getMail()
    {
        return this.mail;
    }

    public void setMail(String mail)
    {
        this.mail = mail;
    }

    public String getTelephoneNumber()
    {
        return this.telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber)
    {
        this.telephoneNumber = telephoneNumber;
    }

    public String getFirstOU()
    {
        return this.firstOU;
    }

    public void setFirstOU(String firstOU)
    {
        this.firstOU = firstOU;
    }

    public String getSecondOU()
    {
        return this.secondOU;
    }

    public void setSecondOU(String secondOU)
    {
        this.secondOU = secondOU;
    }
}
