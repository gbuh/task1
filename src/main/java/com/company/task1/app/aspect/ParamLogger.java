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
public class ParamLogger {
    @Pointcut("within(com.company.task1.app.controller.*) && within(com.company.task1.app.service.*)")
    private void loggingClass() { }

    @Pointcut("execution(public * *(..))")
    private void loggingMethod() { }

    @Around(value = "@annotation(loggingParam)", argNames = "loggingParam")
    public Object timeManagement(final ProceedingJoinPoint joinPoint, LoggingParam loggingParam) throws Throwable {
        log.info("Called method : " + joinPoint.getSignature());
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        log.info("Time Taken by {} is {}", joinPoint, timeTaken);
        return obj;
    }
}
