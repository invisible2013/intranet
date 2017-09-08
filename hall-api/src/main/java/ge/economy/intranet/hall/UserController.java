package ge.economy.intranet.hall;

import ge.economy.intranet.core.api.request.AddPersonalRequest;
import ge.economy.intranet.core.response.Response;
import ge.economy.intranet.core.services.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping({"/users"})
@Controller
public class UserController
{
    @Autowired
    PersonalService personalService;

    @ResponseBody
    @RequestMapping({"/save-user"})
    public Response saveUser(@RequestBody AddPersonalRequest request)
    {
        return Response.withData(this.personalService.savePersonal(request));
    }

    @ResponseBody
    @RequestMapping({"/get-users"})
    public Response getUsers()
    {
        return Response.withData(this.personalService.getPersonals());
    }

    @ResponseBody
    @RequestMapping({"/get-groups"})
    public Response getGroups()
    {
        return Response.withData(this.personalService.getGroups());
    }
}
