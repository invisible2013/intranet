package ge.economy.intranet.security;

import org.springframework.stereotype.Component;

@Component
public class InterceptorFilter
{
    public boolean isSpecialUri(String uri)
    {
        return (uri.endsWith("login")) || (uri.endsWith("logout")) || (uri.contains("resources")) || (uri.contains("app/")) || (uri.contains("file-upload"));
    }
}
