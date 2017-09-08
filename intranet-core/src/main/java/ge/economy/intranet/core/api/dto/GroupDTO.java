package ge.economy.intranet.core.api.dto;

import ge.economy.intranet.database.database.Tables;
import ge.economy.intranet.database.database.tables.Group;
import java.util.ArrayList;
import java.util.List;
import org.jooq.Record;

public class GroupDTO
{
    private Integer id;
    private String name;
    public static int INACTIVE_PERSONAL = 2;
    public static int ACTIVE_PERSONAL = 1;
    public static int USER_GROUP = 1;

    public static GroupDTO translate(Record record)
    {
        GroupDTO dto = new GroupDTO();
        dto.setId((Integer)record.getValue(Tables.GROUP.ID));
        dto.setName((String)record.getValue(Tables.GROUP.NAME));
        return dto;
    }

    public static List<GroupDTO> translateArray(List<Record> records)
    {
        ArrayList<GroupDTO> list = new ArrayList();
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
}
