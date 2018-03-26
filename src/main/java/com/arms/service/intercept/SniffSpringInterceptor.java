package com.arms.service.intercept;

import com.arms.core.context.SystemContext;
import com.arms.service.annotation.Sniff;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author jinxuan
 * @since 2017/12/18
 * Junit 和 Aspect 共同使用会产生类型不匹配错误
 */

@Aspect
@Component
public class SniffSpringInterceptor {

    private static String COOKIE_LOGIN_TICKET = "clt";

    private static String WEB_LOGIN_URI       = "/login_page";

    @Around("(@annotation(com.arms.service.annotation.Sniff)))")
    public Object intercept(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Sniff sniff = getMethodAnnotation(proceedingJoinPoint, Sniff.class);
        Cookie loginCookie = getLoginCookie();
        if (loginCookie == null
            || (loginCookie.getValue().indexOf(sniff.value()) == -1 && loginCookie.getValue()
                .indexOf("ROLE_ADMIN") == -1)) {
            String redirectUrl = "http://" + SystemContext.getRequest().getServerName() + ":"
                                 + SystemContext.getRequest().getServerPort() + WEB_LOGIN_URI
                                 + "?redirectUrl=" + SystemContext.getRequest().getRequestURI()
                                 + "&&roleAuth=" + sniff.value();
            SystemContext.getResponse().sendRedirect(redirectUrl);
        }
        System.out.println(sniff.value());

        return proceedingJoinPoint.proceed();

    }

    private <T extends Annotation> T getMethodAnnotation(ProceedingJoinPoint joinPoint,
                                                         Class<T> clazz) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        return method.getAnnotation(clazz);
    }

    /**
     * @author jinxuan
     * @since 2017/12/18
     * 取出cookie中的登录信息
     */
    public Cookie getLoginCookie() {
        Cookie[] cookies = SystemContext.getRequest().getCookies();
        if (cookies == null || cookies.length <= 0) {
            return null;
        }
        for (Cookie c : cookies) {
            if (COOKIE_LOGIN_TICKET.equals(c.getName())) {
                return c;
            }
        }
        return null;
    }

}
