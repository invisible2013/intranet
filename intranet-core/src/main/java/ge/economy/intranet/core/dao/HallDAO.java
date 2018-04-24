package ge.economy.intranet.core.dao;

import ge.economy.intranet.database.database.Tables;
import ge.economy.intranet.database.database.tables.Hall;
import ge.economy.intranet.database.database.tables.records.HallRecord;

import java.util.List;

import org.jooq.Record;
import org.springframework.stereotype.Repository;

@Repository
public class HallDAO extends AbstractDAO {
    public List<Record> getHalls(int organisationId) {
        return dslContext.
                select().
                from(Tables.HALL).
                where(Tables.HALL.ORGANISATION_ID.eq(organisationId)).
                orderBy(Tables.HALL.ID).
                fetch();
    }

    public List<Record> getActiveHalls(int organisationId) {
        return dslContext.
                select().
                from(Tables.HALL).
                where(Tables.HALL.ORGANISATION_ID.eq(organisationId)).
                and(Tables.HALL.IS_ACTIVE.eq(true)).
                orderBy(Tables.HALL.ID).
                fetch();
    }

    public HallRecord getHallById(int id) {
        return (HallRecord) dslContext.fetchOne(Tables.HALL, Tables.HALL.ID.eq(id));
    }

    public void deleteHall(int itemId) {
        dslContext.deleteFrom(Tables.HALL).where(Tables.HALL.ID.eq(itemId)).execute();
    }
}
