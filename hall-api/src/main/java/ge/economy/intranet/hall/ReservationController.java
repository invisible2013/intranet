package ge.economy.intranet.hall;

import ge.economy.intranet.core.api.dto.PersonalDTO;
import ge.economy.intranet.core.api.request.AddReservationRequest;
import ge.economy.intranet.core.response.Response;
import ge.economy.intranet.core.services.ReservationService;
import ge.economy.intranet.security.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping({"/reservation"})
public class ReservationController
{
    @Autowired
    private ReservationService reservationService;

    @ResponseBody
    @RequestMapping({"/save-reservation"})
    public Response saveHall(HttpSession httpSession, @RequestBody AddReservationRequest request)
    {
        User u = (User)httpSession.getAttribute("current_user");
        if (u != null) {
            request.setUserId(((PersonalDTO)u.getUserData()).getId().intValue());
        }
        try
        {
            return Response.withData(this.reservationService.saveReservation(request));
        }
        catch (Exception ex)
        {
            return Response.withError(ex.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping({"/get-reservations"})
    public Response getReservations()
    {
        return Response.withData(this.reservationService.getReservations());
    }

    @ResponseBody
    @RequestMapping({"/get-reservations-by-hall"})
    public Response getReservationsByHall(@RequestParam int hallId)
    {
        return Response.withData(this.reservationService.getReservationsByHall(hallId));
    }

    @ResponseBody
    @RequestMapping({"/delete-reservation"})
    public Response deleteHall(@RequestParam int itemId)
    {
        this.reservationService.deleteReservation(itemId);
        return Response.withData(Boolean.valueOf(true));
    }
}
