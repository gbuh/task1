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
    private void loggingService() { }

    @Around("loggingService()")
    public Object timeManagement(final ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Called method : " + joinPoint.getSignature());
        long startTime = System.currentTimeMillis();
        Object obj = joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        log.info("Time Taken by {} is {}", joinPoint, timeTaken);
        return obj;
    }
/*
    @Around(value = "@annotation(logging)")
    public Object logMethod(final ProceedingJoinPoint joinPoint, final Logging logging) throws Throwable {
        MethodSignature signature = castToMethodSignature(joinPoint.getSignature());
        Logger log = LogManager.getLogger(signature.getDeclaringType());
        String methodDescription = buildMethodDescription(logging.value(),
                getLoggableParameters(signature, joinPoint.getArgs()));
        log.debug(String.format("Started. %s.", methodDescription));
        Object resultObject = joinPoint.proceed();
        log.debug(String.format("Finished. %s.%s", methodDescription, getResultPart(signature, resultObject)));
        return resultObject;
    }

    private MethodSignature castToMethodSignature(final Signature signature) {
        if (signature instanceof MethodSignature) {
            return (MethodSignature) signature;
        } else {
            throw new UnsupportedOperationException("Cannot operate on joinpoint signature other than MethodSignature");
        }
    }

    private String buildMethodDescription(final String desciption, final List<String> args) {
        StringBuilder messageBuilder = new StringBuilder(desciption);
        if (CollectionUtils.isNotEmpty(args)) {
            return messageBuilder.append(". Parameter(s): ").append(args).toString();
        }
        return messageBuilder.toString();
    }

    private List<String> getLoggableParameters(final MethodSignature methodSignature, final Object[] args) {
        Parameter[] parameters = methodSignature.getMethod().getParameters();
        return IntStream.range(0, parameters.length).boxed()
                .filter(i -> parameters[i].isAnnotationPresent(LogParam.class))
                .map(i -> String.format("%s=%s", parameters[i].getName(), toString(args[i])))
                .collect(Collectors.toList());
    }

    private String getResultPart(final MethodSignature methodSignature, final Object returnedValue) {
        return isVoidMethod(methodSignature)
                ? StringUtils.EMPTY
                : String.format(" Result: %s.", toString(returnedValue));
    }

    private String toString(final Object object) {
        if (object == null) {
            return "null";
        }
        if (object instanceof Loggable) {
            return ((Loggable) object).toLogMessage();
        }
        return ToStringBuilder.reflectionToString(object, new LogMessageStyle());
    }

    private boolean isVoidMethod(final MethodSignature methodSignature) {
        return methodSignature.getReturnType().equals(void.class);
    }

    private static final class LogMessageStyle extends RecursiveToStringStyle {

        private static final long serialVersionUID = 1274855978343310410L;

        private LogMessageStyle() {
            super();
            super.setUseShortClassName(true);
            super.setUseIdentityHashCode(false);
            super.setContentStart("(");
            super.setContentEnd(")");
            super.setArrayStart("[");
            super.setArrayEnd("]");
            super.setArraySeparator(",");
            super.setFieldSeparator(",");
        }

        @Override
        public void appendDetail(final StringBuffer buffer, final String fieldName, final Object value) {
            if (value instanceof Loggable) {
                buffer.append(((Loggable) value).toLogMessage());
            } else {
                super.appendDetail(buffer, fieldName, value);
            }
        }
    }
*/
}
