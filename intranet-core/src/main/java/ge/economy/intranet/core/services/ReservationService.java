package ge.economy.intranet.core.services;

import ge.economy.intranet.core.api.dto.EventDTO;
import ge.economy.intranet.core.api.dto.ReservationDTO;
import ge.economy.intranet.core.api.request.AddReservationRequest;
import ge.economy.intranet.core.dao.ReservationDAO;
import ge.economy.intranet.database.database.Tables;
import ge.economy.intranet.database.database.tables.records.ReservationRecord;

import java.util.Date;
import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    @Autowired
    private ReservationDAO reservationDAO;
    @Autowired
    private DSLContext dslContext;

    public ReservationDTO saveReservation(AddReservationRequest request)
            throws Exception {
        if (request.getStartDate() == null) {
            throw new Exception("დაწყების თარიღი არ არის გადმოცემული");
        } else if (request.getEndDate() == null) {
            throw new Exception("დასრულები თარიღი არ არის გადმოცემული");
        } else if (request.getHallId() == 0) {
            throw new Exception("შეხვედრის ოთახი არ არის მითითებული");
        } else if (request.getName() == null) {
            throw new Exception("შეხვედრა არ არის მითითებული");
        }
        checkReservationDate(request.getStartDate(), request.getEndDate(), request.getHallId());

        boolean newRecord = false;
        ReservationRecord record = null;
        if (request.getId() != 0) {
            record = this.reservationDAO.getReservationById(request.getId());
        }
        if (record == null) {
            record = (ReservationRecord) this.dslContext.newRecord(Tables.RESERVATION);
            newRecord = true;
        }
        record.setHallId(request.getHallId());
        record.setUserId(request.getUserId());
        record.setOrganisationId(request.getOrganisationId());
        record.setDescription(request.getDescription());
        record.setName(request.getName());
        record.setStartDate(request.getStartDate());
        record.setEndDate(request.getEndDate());
        if (newRecord) {
            record.store();
        } else {
            record.update();
        }
        return null;
    }

    private boolean checkReservationDate(Date startDate, Date endDate, int hallId)
            throws Exception {
        if (startDate.compareTo(endDate) >= 0) {
            throw new Exception("შეხვედრის დაწყების თარიღი ნაკლები უნდა იყოს დასრულების თარიღზე");
        }
        List<ReservationDTO> reservations = getReservationListByHall(hallId);
        for (ReservationDTO item : reservations) {
            if (((item.getStartDate().compareTo(startDate) < 1) && (item.getEndDate().compareTo(startDate) > 0)) || (
                    (item.getStartDate().compareTo(endDate) < 1) && (item.getEndDate().compareTo(startDate) > 0))) {
                throw new Exception("მითითებული დროის შუალედი კვეთს სხვა შეხვედრას, გთხოვთ ჩაასწოროთ თარიღები.");
            }
        }
        return false;
    }

    public ReservationDTO getReservationById(int itemId) {
        return ReservationDTO.translate(this.reservationDAO.getReservationById(itemId));
    }

    public List<EventDTO> getReservations(int organisationId) {
        return EventDTO.translateArray(this.reservationDAO.getReservations());
    }

    public List<EventDTO> getReservationsByHall(int hallId) {
        return EventDTO.translateArray(this.reservationDAO.getReservationsByHall(hallId));
    }

    public List<ReservationDTO> getReservationListByHall(int hallId) {
        return ReservationDTO.translateArray(this.reservationDAO.getReservationsByHall(hallId));
    }

    public void deleteReservation(int itemId) {
        this.reservationDAO.deleteReservation(itemId);
    }
}
