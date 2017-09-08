package ge.economy.intranet.core.dao;

import ge.economy.intranet.database.database.Tables;
import ge.economy.intranet.database.database.tables.records.PersonalRecord;
import java.util.List;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

@Repository
public class PersonalDAO extends AbstractDAO
{
    public List<Record> getPersonals()
    {
        return dslContext.
                select().
                from(Tables.PERSONAL).
                join(Tables.GROUP).on(Tables.PERSONAL.GROUP_ID.eq(Tables.GROUP.ID)).
                join(Tables.STATUS).on(Tables.PERSONAL.STATUS_ID.eq(Tables.STATUS.ID)).
                orderBy(Tables.PERSONAL.ID.desc()).
                fetch();
    }

    public List<Record> getGroups()
    {
        return dslContext.
                select().
                from(Tables.GROUP).
                orderBy(Tables.GROUP.ID.desc()).
                fetch();
    }

    public List<Record> getInactivePersonal(List<String> mails, int organisationId)
    {
        return dslContext.
                select().
                from(Tables.PERSONAL).
                where(Tables.PERSONAL.MAIL.notIn(mails)).
                and(Tables.PERSONAL.ORGANISATION_ID.eq(organisationId)).
                fetch();
    }

    public PersonalRecord getPersonalById(int id)
    {
        return (PersonalRecord)dslContext.fetchOne(Tables.PERSONAL, Tables.PERSONAL.ID.eq(id));
    }

    public Record getPersonalByMail(String mail)
    {
        return dslContext.
                select().
                from(Tables.PERSONAL).
                join(Tables.GROUP).on(Tables.PERSONAL.GROUP_ID.eq(Tables.GROUP.ID)).
                join(Tables.STATUS).on(Tables.PERSONAL.STATUS_ID.eq(Tables.STATUS.ID)).
                where(Tables.PERSONAL.MAIL.eq(mail)).
                fetchOne();
    }

    public void deletePersonal(int itemId)
    {
        dslContext.deleteFrom(Tables.PERSONAL).where(Tables.PERSONAL.ID.eq(itemId)).execute();
    }
}
