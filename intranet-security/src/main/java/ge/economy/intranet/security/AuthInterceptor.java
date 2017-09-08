package ge.economy.intranet.security;

import ge.economy.intranet.security.api.SecurityAPI;
import ge.economy.intranet.security.api.User;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
    public static final String CURRENT_USER = "current_user";
    @Autowired
    private SecurityAPI securityAPI;
    @Autowired
    private InterceptorFilter interceptorFilter;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws IOException {
        String uri = request.getRequestURI();
        User user = (User) request.getSession().getAttribute("current_user");
        if (!this.interceptorFilter.isSpecialUri(uri)) {
            if ((user == null) && (request.getHeader("X-Requested-With") == null)) {
                if (uri.startsWith(request.getContextPath())) {
                    uri = uri.replace(request.getContextPath(), "");
                }
                if ((uri.length() > 0) && (!uri.equals("/"))) {
                    response.sendRedirect(this.securityAPI.getLoginPage() + "?redirect=" + uri);
                } else {
                    response.sendRedirect(this.securityAPI.getLoginPage());
                }
                return false;
            }
            if (user == null) {
                response.setContentType("application/json");
                ObjectMapper mapper = new ObjectMapper();
                String responseBody = mapper.writeValueAsString(this.securityAPI.wrapErrorMessage(ErrorCodes.UNAUTHORIZED));
                response.getWriter().write(responseBody);
                return false;
            }
        }
        return true;
    }
}
