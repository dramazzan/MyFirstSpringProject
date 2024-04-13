package org.example.aspect;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.service.MyLoggerService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class MyLoggerAspect {

    private final MyLoggerService loggerService;

    @Around(value = "@annotation(org.example.aspect.ToLogOurApp)")
    public Object myLoggerMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("Aspect is working");

        String request = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                 .collect(Collectors.joining(","));
        String answer = (String) joinPoint.proceed();



        org.example.model.MyLogger newLog = new org.example.model.MyLogger(
                null,
                request,
                answer,
                LocalDateTime.now()
        );

        loggerService.saveLog(newLog);

        log.info("in->{} , out->{}" , request ,answer);

        return answer ;
    }

}
