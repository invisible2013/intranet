package ge.economy.intranet.hall;

import ge.economy.intranet.core.api.dto.PersonalDTO;
import ge.economy.intranet.core.api.request.AddPersonalRequest;
import ge.economy.intranet.core.response.Response;
import ge.economy.intranet.core.services.PersonalService;
import ge.economy.intranet.security.api.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@RequestMapping({"/users"})
@Controller
public class UserController {
    @Autowired
    PersonalService personalService;

    @ResponseBody
    @RequestMapping({"/save-user"})
    public Response saveUser(@RequestBody AddPersonalRequest request) {
        return Response.withData(this.personalService.savePersonal(request));
    }

    @ResponseBody
    @RequestMapping({"/get-users"})
    public Response getUsers(HttpSession httpSession) {
        User u = (User) httpSession.getAttribute("current_user");
        PersonalDTO personal = new PersonalDTO();
        if (u != null) {
            personal = (PersonalDTO) u.getUserData();
        }
        return Response.withData(this.personalService.getPersonals(personal.getOrganisationId()));
    }

    @ResponseBody
    @RequestMapping({"/get-groups"})
    public Response getGroups() {
        return Response.withData(this.personalService.getGroups());
    }
}
