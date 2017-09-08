package ge.economy.intranet.core.dao;

import ge.economy.intranet.database.database.Tables;
import ge.economy.intranet.database.database.tables.User;
import ge.economy.intranet.database.database.tables.records.UserRecord;

import java.util.List;

import org.jooq.Record;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO
        extends AbstractDAO {
    public UserRecord getUser(String username, String password) {
        List<Record> records = dslContext.
                select().
                from(Tables.USER).
                where(Tables.USER.USER_NAME.eq(username)).
                and(Tables.USER.PASSWORD.eq(password)).
                fetch();

        return records.size() > 0 ? (UserRecord) ((Record) records.get(0)).into(UserRecord.class) : null;
    }
}
