package com.company.task1.app.aspect;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
@Log4j2
public class MyLogger {
    @Pointcut("within(com.company.task1.app.controller.*)")
    private void loggingService() {}

    @Around("loggingService()")
    public Object timeManagement(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Called method : " + joinPoint.getSignature());
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        log.info("Time Taken by {} is {}", joinPoint, timeTaken);
        return obj;
    }
/*
    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    private void loggingService() {}

    @Around("loggingService() && args(user)")
    public Object timeManagement(ProceedingJoinPoint joinPoint, User user) throws Throwable {
        log.info("Called method : " + joinPoint.getSignature() + " email" + user.getEmail());
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        
        Arrays.stream(joinPoint.getArgs()).forEach(arg -> log.info(arg));
        long timeTaken = System.currentTimeMillis() - startTime;
        log.info("Time Taken by {} is {}", joinPoint, timeTaken);
        return obj;
    }
*/
}
