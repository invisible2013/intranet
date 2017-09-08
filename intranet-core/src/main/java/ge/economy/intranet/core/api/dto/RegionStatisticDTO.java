package ge.economy.intranet.core.api.dto;

public class RegionStatisticDTO
{
    private int regionId;
    private Integer count;
    private Integer sportsmanCount;
    private Integer refereeCount;
    private Integer trainerCount;

    public int getRegionId()
    {
        return this.regionId;
    }

    public void setRegionId(int regionId)
    {
        this.regionId = regionId;
    }

    public Integer getCount()
    {
        return this.count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

    public Integer getSportsmanCount()
    {
        return this.sportsmanCount;
    }

    public void setSportsmanCount(Integer sportsmanCount)
    {
        this.sportsmanCount = sportsmanCount;
    }

    public Integer getRefereeCount()
    {
        return this.refereeCount;
    }

    public void setRefereeCount(Integer refereeCount)
    {
        this.refereeCount = refereeCount;
    }

    public Integer getTrainerCount()
    {
        return this.trainerCount;
    }

    public void setTrainerCount(Integer trainerCount)
    {
        this.trainerCount = trainerCount;
    }
}
