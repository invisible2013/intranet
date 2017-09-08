package ge.economy.intranet.database.lookups;

public enum UserStatusList
{
    ACTIVE(1, "active", "Active"),  DISABLED(2, "disabled", "Disabled");

    int statusId;
    String name;
    String humanName;

    private UserStatusList(int statusId, String name, String humanName)
    {
        this.statusId = statusId;
        this.name = name;
        this.humanName = humanName;
    }

    public int getStatusId()
    {
        return this.statusId;
    }

    public void setStatusId(int statusId)
    {
        this.statusId = statusId;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
