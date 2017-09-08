package ge.economy.intranet.core.api.dto;

import ge.economy.intranet.database.database.Tables;
import ge.economy.intranet.database.database.tables.Hall;
import java.util.ArrayList;
import java.util.List;
import org.jooq.Record;

public class HallDTO
{
    private Integer id;
    private String name;
    private String description;

    public static HallDTO translate(Record record)
    {
        HallDTO dto = new HallDTO();
        dto.setId((Integer)record.getValue(Tables.HALL.ID));
        dto.setName((String)record.getValue(Tables.HALL.NAME));
        dto.setDescription((String)record.getValue(Tables.HALL.DESCRIPTION));
        return dto;
    }

    public static List<HallDTO> translateArray(List<Record> records)
    {
        ArrayList<HallDTO> list = new ArrayList();
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

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
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
