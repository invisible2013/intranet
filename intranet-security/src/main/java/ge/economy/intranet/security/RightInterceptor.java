package ge.economy.intranet.security;

import ge.economy.intranet.security.api.User;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RightInterceptor
        extends HandlerInterceptorAdapter
{
    @Autowired
    private InterceptorFilter filter;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException
    {
        if (this.filter.isSpecialUri(request.getRequestURI())) {
            return true;
        }
        HandlerMethod method = (HandlerMethod)handler;
        User user = (User)request.getSession().getAttribute("current_user");
        HasRight hasRight = (HasRight)method.getMethod().getAnnotation(HasRight.class);
        if (hasRight != null)
        {
            String[] rights = hasRight.rights();
            for (String right : rights) {
                if (!user.getRights().contains(right))
                {
                    response.sendError(403);
                    return false;
                }
            }
        }
        return true;
    }
}
