package ge.economy.intranet.security;

import ge.economy.intranet.security.api.SecurityAPI;
import ge.economy.intranet.security.api.User;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class AuthController {
    @Autowired
    private SecurityAPI securityAPI;

    public AuthController() {
    }

    @RequestMapping(
            value = {"/login"},
            method = {RequestMethod.GET}
    )
    public String login(HttpServletRequest request) {
        User user = (User)request.getSession().getAttribute("current_user");
        return user == null?"login":"redirect:" + this.securityAPI.getHomePage();
    }

    @RequestMapping(
            value = {"/login"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Object verify(HttpServletRequest request, @RequestParam(value = "redirect",required = false) String redirect) throws Exception {
        Map<String, Object> params = new HashMap();
        redirect = redirect != null && !redirect.isEmpty()?redirect:this.securityAPI.getHomePage();
        List<String> list = this.securityAPI.getLoginParameters();
        this.securityAPI.getLoginParameters().stream().forEach((p) -> {
            params.put(p, request.getParameter(p));
        });
        User user;
        if(this.securityAPI.isTwoStepVerification()) {
            if(request.getParameterMap().containsKey(this.securityAPI.getTwoStepVerificationParam())) {
                user = this.securityAPI.getUser(params);
                if(user != null) {
                    request.getSession().setAttribute("current_user", user);
                    return this.securityAPI.wrapResponse(redirect);
                } else {
                    return this.securityAPI.wrapErrorMessage(ErrorCodes.INCORRECT_CREDENTIALS);
                }
            } else {
                return Boolean.valueOf(this.securityAPI.sendTwoStepVerificationCode(params));
            }
        } else {
            user = this.securityAPI.getUser(params);
            if(user != null) {
                request.getSession().setAttribute("current_user", user);
                return this.securityAPI.wrapResponse(redirect);
            } else {
                return this.securityAPI.wrapErrorMessage(ErrorCodes.INCORRECT_CREDENTIALS);
            }
        }
    }

    @RequestMapping(
            value = {"/logout"},
            method = {RequestMethod.GET}
    )
    public String logout(HttpSession session) {
        session.removeAttribute("current_user");
        session.invalidate();
        return "redirect:" + this.securityAPI.getLoginPage();
    }

    @RequestMapping(
            value = {"/status"},
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public Object status(HttpSession session, HttpServletResponse response) throws IOException {
        User u = (User)session.getAttribute("current_user");
        return u != null?this.securityAPI.wrapResponse(u):this.securityAPI.wrapErrorMessage(ErrorCodes.UNAUTHORIZED);
    }

    @ResponseBody
    @RequestMapping(
            value = {"/get-user"},
            method = {RequestMethod.POST}
    )
    public Object getUser(HttpServletRequest httpServletRequest) {
        User user = (User)httpServletRequest.getSession().getAttribute("current_user");
        return this.securityAPI.wrapResponse(user);
    }
}
