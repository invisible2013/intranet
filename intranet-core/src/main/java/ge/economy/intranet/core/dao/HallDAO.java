package ge.economy.intranet.core.dao;

import ge.economy.intranet.database.database.Tables;
import ge.economy.intranet.database.database.tables.Hall;
import ge.economy.intranet.database.database.tables.records.HallRecord;

import java.util.List;

import org.jooq.Record;
import org.springframework.stereotype.Repository;

@Repository
public class HallDAO extends AbstractDAO {
    public List<Record> getHalls() {
        return dslContext.
                select().
                from(Tables.HALL).
                orderBy(Tables.HALL.ID.desc()).
                fetch();
    }

    public HallRecord getHallById(int id) {
        return (HallRecord) dslContext.fetchOne(Tables.HALL, Tables.HALL.ID.eq(id));
    }

    public void deleteHall(int itemId) {
        dslContext.deleteFrom(Tables.HALL).where(Tables.HALL.ID.eq(itemId)).execute();
    }
}
