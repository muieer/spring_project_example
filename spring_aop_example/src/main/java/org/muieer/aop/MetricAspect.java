package org.muieer.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MetricAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(MetricAspect.class);

    @Pointcut("@annotation(org.muieer.annotations.TimeConsuming)")
    public void timeConsumingPointcut() {}

    @Around("timeConsumingPointcut()")
    public Object timeConsumingAdvice(ProceedingJoinPoint joinPoint) {

        long start = System.currentTimeMillis();
        Object result = null;

        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        } finally {
            long end = System.currentTimeMillis();
            LOGGER.info(String.format("%s cost time %d ms", joinPoint, end - start));
        }

        return result;
    }

}
