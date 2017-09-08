package ge.economy.intranet.hall;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/"})
public class WebController
{
    @RequestMapping({"/{page}"})
    public String home(@PathVariable String page)
    {
        return page;
    }
}
