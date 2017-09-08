package ge.economy.intranet.hall;

import ge.economy.intranet.core.response.Response;
import ge.economy.intranet.core.services.FileService;
import ge.economy.intranet.core.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/app"})
public class ApplicationController
{
    @Autowired
    private FileService fileService;
    @Autowired
    private ReservationService reservationService;

    @ResponseBody
    @RequestMapping({"/get-version"})
    public Response getVersion()
    {
        return Response.withData("v1.0.1");
    }
}
