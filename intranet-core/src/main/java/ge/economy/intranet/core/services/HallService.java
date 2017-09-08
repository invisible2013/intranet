package ge.economy.intranet.core.services;

import ge.economy.intranet.core.api.dto.HallDTO;
import ge.economy.intranet.core.api.request.AddHallRequest;
import ge.economy.intranet.core.dao.HallDAO;
import ge.economy.intranet.database.database.Tables;
import ge.economy.intranet.database.database.tables.records.HallRecord;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by NINO on 9/5/2017.
 */

@Service
public class HallService {
    @Autowired
    private HallDAO hallDAO;
    @Autowired
    private DSLContext dslContext;

    public HallDTO saveHall(AddHallRequest request)
    {
        boolean newRecord = false;
        HallRecord record = null;
        if (request.getId() != 0) {
            record = this.hallDAO.getHallById(request.getId());
        }
        if (record == null)
        {
            record = (HallRecord)this.dslContext.newRecord(Tables.HALL);
            newRecord = true;
        }
        record.setName(request.getName());
        record.setDescription(request.getDescription());
        if (newRecord) {
            record.store();
        } else {
            record.update();
        }
        return null;
    }

    public HallDTO getChampionshipById(int itemId)
    {
        return HallDTO.translate(this.hallDAO.getHallById(itemId));
    }

    public List<HallDTO> getHalls()
    {
        return HallDTO.translateArray(this.hallDAO.getHalls());
    }

    public void deleteHall(int itemId)
    {
        this.hallDAO.deleteHall(itemId);
    }
}
