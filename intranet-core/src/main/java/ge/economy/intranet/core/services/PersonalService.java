package ge.economy.intranet.core.services;

import ge.economy.intranet.core.api.dto.GroupDTO;
import ge.economy.intranet.core.api.dto.PersonalDTO;
import ge.economy.intranet.core.api.request.AddPersonalRequest;
import ge.economy.intranet.core.dao.PersonalDAO;
import ge.economy.intranet.database.database.Tables;
import ge.economy.intranet.database.database.tables.records.PersonalRecord;
import java.util.List;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalService
{
    @Autowired
    private PersonalDAO personalDAO;
    @Autowired
    private DSLContext dslContext;

    public void inactivePersonal(List<String> mails, int organisationId)
    {
        List<Record> personals = this.personalDAO.getInactivePersonal(mails, organisationId);
        for (Record p : personals)
        {
            PersonalRecord personal = (PersonalRecord)p;
            personal.setStatusId(Integer.valueOf(PersonalDTO.INACTIVE_PERSONAL));
            personal.update();
        }
    }

    public PersonalDTO getPersonalByMail(String mail)
    {
        Record personalRecord = this.personalDAO.getPersonalByMail(mail);
        if (personalRecord != null) {
            return PersonalDTO.translate(personalRecord);
        }
        return null;
    }

    public PersonalDTO savePersonal(PersonalRecord request)
    {
        PersonalRecord record = (PersonalRecord)this.personalDAO.getPersonalByMail(request.getMail());
        if (record == null)
        {
            record = (PersonalRecord)this.dslContext.newRecord(Tables.PERSONAL);
            record.setMail(request.getMail());
            record.setFirstName(request.getFirstName());
            record.setLastName(request.getLastName());
            record.setPositionId(request.getPositionId());
            record.setGroupId(request.getGroupId());
            record.setStructureId(request.getStructureId());
            record.setOrganisationId(request.getOrganisationId());
            record.setStatusId(request.getStatusId());
            record.store();
        }
        else
        {
            record.update();
        }
        return null;
    }

    public void addBasePersonalByMail(String mail)
    {
        PersonalRecord record = (PersonalRecord)this.personalDAO.getPersonalByMail(mail);
        if (record == null)
        {
            record = (PersonalRecord)this.dslContext.newRecord(Tables.PERSONAL);
            record.setMail(mail);
            String username = mail.substring(0, mail.indexOf('@'));
            if (!username.contains("."))
            {
                record.setFirstName(username.substring(0, 1));
                record.setLastName(username.substring(1, username.length()));
            }
            else
            {
                record.setFirstName(username.substring(0, username.indexOf('.')));
                record.setLastName(username.substring(username.indexOf('.') + 1, username.length()));
            }
            record.setPositionId(Integer.valueOf(PersonalDTO.POSITION_DEFAULT));
            record.setGroupId(Integer.valueOf(PersonalDTO.USER_GROUP));
            record.setStructureId(Integer.valueOf(PersonalDTO.STRUCTURE_ECONOMY));
            record.setOrganisationId(Integer.valueOf(PersonalDTO.ORGANISATION_ECONOMY));
            record.setStatusId(Integer.valueOf(PersonalDTO.ACTIVE_PERSONAL));
            record.store();
        }
    }

    public PersonalDTO savePersonal(AddPersonalRequest request)
    {
        PersonalRecord record = null;
        if (request.getId().intValue() != 0) {
            record = this.personalDAO.getPersonalById(request.getId().intValue());
        } else {
            record = (PersonalRecord)this.dslContext.newRecord(Tables.PERSONAL);
        }
        record.setFirstName(request.getFirstName());
        record.setLastName(request.getLastName());
        record.setGroupId(request.getGroupId());
        if (request.getId().intValue() != 0) {
            record.update();
        } else {
            record.store();
        }
        return null;
    }

    public PersonalDTO getPersonalById(int itemId)
    {
        return PersonalDTO.translate(this.personalDAO.getPersonalById(itemId));
    }

    public List<PersonalDTO> getPersonals()
    {
        return PersonalDTO.translateArray(this.personalDAO.getPersonals());
    }

    public List<GroupDTO> getGroups()
    {
        return GroupDTO.translateArray(this.personalDAO.getGroups());
    }
}
