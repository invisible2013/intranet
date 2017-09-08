package ge.economy.intranet.security.api;

import ge.economy.intranet.security.ErrorCodes;
import java.util.List;
import java.util.Map;

public interface SecurityAPI
{
    User getUser(Map<String, Object> var1) throws Exception;

    List<String> getLoginParameters();

    String getLoginPage();

    String getHomePage();

    boolean isTwoStepVerification();

    String getTwoStepVerificationParam();

    boolean sendTwoStepVerificationCode(Map<String, Object> var1);

    Object wrapErrorMessage(ErrorCodes var1);

    Object wrapResponse(Object var1);
}
