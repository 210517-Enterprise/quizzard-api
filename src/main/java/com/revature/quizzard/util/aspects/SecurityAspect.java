package com.revature.quizzard.util.aspects;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.quizzard.util.exceptions.AuthorizationException;
import com.revature.quizzard.util.security.Secured;
import com.revature.quizzard.web.intercom.AuthServiceClient;

@Aspect
@Component
public class SecurityAspect {

    private HttpServletRequest request;
    private AuthServiceClient authClient;

    @Autowired
    public SecurityAspect(HttpServletRequest request, AuthServiceClient authClient) {
        this.request = request;
        this.authClient = authClient;
    }

    @Around("@annotation(com.revature.quizzard.util.security.Secured)")
    public Object secureEndpoint(ProceedingJoinPoint pjp) throws Throwable {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        Secured securedAnno = method.getAnnotation(Secured.class);

        List<String> allowedRoles = Arrays.asList(securedAnno.allowedRoles());

        String token = request.getHeader("quizzard-token");
        System.out.println(token);
        String authority = authClient.getTokenAuthorities(token);

        if (!allowedRoles.contains(authority)) {
            throw new AuthorizationException();
        }

        return pjp.proceed();

    }

}
