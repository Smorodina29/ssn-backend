package ssn.web.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ssn.commons.api.exceptions.TokenRequiredException;
import ssn.facades.exeptions.BadTokenException;
import ssn.facades.exeptions.TokenExpiredException;
import ssn.facades.SecurityServiceFacade;
import ssn.web.security.annotation.Secured;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Slf4j
@Component
public class SecurityTokenCheckInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SecurityServiceFacade securityService;

    @Value("${thauctions.security.token.header}")
    private String authTokenHeader;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        Secured annotation;
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            annotation = method.getMethod().getAnnotation(Secured.class);
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN,
                    "unknown resource");
            return false;
        }

        boolean result = true;

        if (annotation != null) {
            result = handleAuthorizedMethod(request, annotation);
        } else {
            Thread.currentThread().setName("web-anon");
        }

        return result;
    }

    private boolean handleAuthorizedMethod(HttpServletRequest request,
                                           Secured annotation) throws BadTokenException, TokenExpiredException, TokenRequiredException, ssn.facades.exeptions.BadTokenException {

        final String token = Optional.ofNullable(request.getHeader(authTokenHeader))
                .orElseThrow(() -> new TokenRequiredException(authTokenHeader));

        if (log.isTraceEnabled()) {
            log.trace("Check token for method " + request + ", " +
                    "token " + token + ", annotation " + annotation);
        }

        long userId = securityService.checkToken(token);

        request.setAttribute("userId", userId);
        Thread.currentThread().setName("web-" + userId);
        return true;
    }
}
