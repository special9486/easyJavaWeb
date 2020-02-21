package com.example.servingwebcontent.commons.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
@Slf4j
public class LoggingElapsedTime {

    @Around("within(com.example.servingwebcontent.controller..*)")
    public Object elapsedTimeController(ProceedingJoinPoint pjp) throws Throwable {
        return printElapseTime(pjp);
    }

    @Around("within(com.example.servingwebcontent.service..*)")
    public Object elapsedTimeService(ProceedingJoinPoint pjp) throws Throwable {
        return printElapseTime(pjp);
    }

    @Around("execution(public !void org.springframework.data.repository.Repository+.*(..))")
    public Object elapsedTimeRepository(ProceedingJoinPoint pjp) throws Throwable {
        return printElapseTime(pjp);
    }

    private Object printElapseTime(ProceedingJoinPoint pjp) throws Throwable {
        try {
            final StopWatch stopWatch = new StopWatch();
            final String className = pjp.getTarget().getClass().getSimpleName();
            final String methodName = pjp.getSignature().getName();
            log.info("{}.{} start....", className, methodName);

            stopWatch.start();
            final Object result = pjp.proceed();
            stopWatch.stop();

            log.info("{}.{} elapsed time: {} ms", className, methodName, stopWatch.getTotalTimeMillis());

            return result;
        } catch (Throwable e) {
            log.error("elapsedTimeController Throwable: " + e.getMessage(), e);
            throw e;
        }
    }
 }
