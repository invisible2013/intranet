package ge.economy.intranet.hall;

import ge.economy.intranet.core.api.dto.PersonalDTO;
import ge.economy.intranet.core.api.request.AddHallRequest;
import ge.economy.intranet.core.response.Response;
import ge.economy.intranet.core.services.HallService;
import ge.economy.intranet.security.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@RequestMapping({"/hall"})
@Controller
public class HallController {
    @Autowired
    private HallService hallService;

    @ResponseBody
    @RequestMapping({"/save-hall"})
    public Response saveHall(@RequestBody AddHallRequest request, HttpSession httpSession) {
        User u = (User) httpSession.getAttribute("current_user");
        PersonalDTO personal = new PersonalDTO();
        if (u != null) {
            personal = (PersonalDTO) u.getUserData();
            request.setOrganisationId(personal.getOrganisationId());
        }
        return Response.withData(this.hallService.saveHall(request));
    }

    @ResponseBody
    @RequestMapping({"/get-halls"})
    public Response getHalls(HttpSession httpSession) {
        User u = (User) httpSession.getAttribute("current_user");
        PersonalDTO personal = new PersonalDTO();
        if (u != null) {
            personal = (PersonalDTO) u.getUserData();
        }
        return Response.withData(this.hallService.getHalls(personal.getOrganisationId()));
    }

    @ResponseBody
    @RequestMapping({"/delete-hall"})
    public Response deleteHall(@RequestParam int itemId) {
        this.hallService.deleteHall(itemId);
        return Response.withData(Boolean.valueOf(true));
    }
}
