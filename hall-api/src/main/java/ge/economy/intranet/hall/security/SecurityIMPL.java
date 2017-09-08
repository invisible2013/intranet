package ge.economy.intranet.hall.security;

import ge.economy.intranet.core.api.dto.PersonalDTO;
import ge.economy.intranet.core.response.Response;
import ge.economy.intranet.core.services.LDAPService;
import ge.economy.intranet.core.services.UserService;
import ge.economy.intranet.security.ErrorCodes;
import ge.economy.intranet.security.api.SecurityAPI;
import ge.economy.intranet.security.api.User;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityIMPL
        implements SecurityAPI
{
    @Autowired
    private UserService userService;
    @Autowired
    private LDAPService ldapService;

    public User getUser(Map<String, Object> map)
            throws Exception
    {
        String username = map.get("email").toString().toLowerCase();
        String password = map.get("password").toString();

        PersonalDTO personal = ldapService.ldapAuth(username, password);
        if (personal == null) {
            return null;
        }
        User user = new User();
        user.setUserData(personal);

        return user;
    }

    public List<String> getLoginParameters()
    {
        return Arrays.asList(new String[] { "email", "password" });
    }

    public String getLoginPage()
    {
        return "login";
    }

    public String getHomePage()
    {
        return "home";
    }

    public boolean isTwoStepVerification()
    {
        return false;
    }

    public String getTwoStepVerificationParam()
    {
        return null;
    }

    public boolean sendTwoStepVerificationCode(Map<String, Object> map)
    {
        return false;
    }

    public Object wrapErrorMessage(ErrorCodes errorCode)
    {
        Response response = new Response();
        response.setErrorCode(errorCode.getCode());
        response.setMessage(errorCode.getMessage());
        return response;
    }

    public Object wrapResponse(Object data)
    {
        return Response.withData(data);
    }
}
