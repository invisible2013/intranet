package ge.economy.intranet.core.api.dto;

import java.math.BigDecimal;

public class RegionStatisticPojo
{
    private Integer statisticTypeId;
    private BigDecimal count;

    public RegionStatisticPojo(Integer statisticTypeId, BigDecimal count)
    {
        this.statisticTypeId = statisticTypeId;
        this.count = count;
    }

    public Integer getStatisticTypeId()
    {
        return this.statisticTypeId;
    }

    public void setStatisticTypeId(Integer statisticTypeId)
    {
        this.statisticTypeId = statisticTypeId;
    }

    public BigDecimal getCount()
    {
        return this.count;
    }

    public void setCount(BigDecimal count)
    {
        this.count = count;
    }
}
