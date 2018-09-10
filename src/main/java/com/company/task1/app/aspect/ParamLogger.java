package com.company.task1.app.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Aspect
@Component
public class ParamLogger {
    @Around(value = "@annotation(loggingMethod)", argNames = "loggingMethod")
    public Object logMethod(final ProceedingJoinPoint joinPoint, final LoggingMethod loggingMethod) throws Throwable {
        Logger log = LogManager.getLogger(joinPoint.getSignature().getDeclaringType());
        List<String> argsWithNames = getParametersWithNames(joinPoint);
        String processDesription = buildJoinPointDescription(loggingMethod.value(), argsWithNames);
        log.info("Started. " + processDesription);
        Object proceed = joinPoint.proceed();
        log.info("Finished. " + processDesription);
        return proceed;
    }

    private List<String> getParametersWithNames(final ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        if (signature instanceof MethodSignature) {
            MethodSignature methodSignature = (MethodSignature) signature;
            Parameter[] parameters = methodSignature.getMethod().getParameters();
            Object[] args = joinPoint.getArgs();
            List<String> argsWithNames = IntStream.range(0, parameters.length).boxed()
                    .filter(i -> parameters[i].isAnnotationPresent(LoggingParam.class))
                    .map(i -> parameters[i].getName() + ":" + args[i]).collect(Collectors.toList());
            return argsWithNames;
        }
        return Collections.emptyList();
    }

    private String buildJoinPointDescription(final String desciption, final List<String> args) {
        StringBuilder messageBuilder = new StringBuilder(desciption).append(". Parameters: ");
        if (args.isEmpty()) {
            messageBuilder.append("none");
        } else {
            messageBuilder.append(args);
        }
        return messageBuilder.toString();
    }
}
