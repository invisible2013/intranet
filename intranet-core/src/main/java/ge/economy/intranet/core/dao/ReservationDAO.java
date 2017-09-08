package ge.economy.intranet.core.dao;

import ge.economy.intranet.database.database.Tables;
import ge.economy.intranet.database.database.tables.records.ReservationRecord;

import java.util.List;

import org.jooq.Record;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationDAO extends AbstractDAO {
    public List<Record> getReservations() {
        return dslContext.
                select().
                from(Tables.RESERVATION).
                join(Tables.HALL).
                on(Tables.RESERVATION.HALL_ID.eq(Tables.HALL.ID)).
                orderBy(Tables.RESERVATION.ID.desc()).
                fetch();
    }

    public List<Record> getReservationsByHall(int hallId) {
        return dslContext.
                select().
                from(Tables.RESERVATION).
                join(Tables.HALL).
                on(Tables.RESERVATION.HALL_ID.eq(Tables.HALL.ID)).
                leftJoin(Tables.PERSONAL).
                on(Tables.RESERVATION.USER_ID.eq(Tables.PERSONAL.ID)).
                where(Tables.RESERVATION.HALL_ID.eq(Integer.valueOf(hallId))).
                orderBy(Tables.RESERVATION.ID.desc()).fetch();
    }

    public ReservationRecord getReservationById(int id) {
        return (ReservationRecord) dslContext.fetchOne(Tables.RESERVATION, Tables.RESERVATION.ID.eq(id));
    }

    public void deleteReservation(int itemId) {
        dslContext.deleteFrom(Tables.RESERVATION).where(Tables.RESERVATION.ID.eq(itemId)).execute();
    }
}
