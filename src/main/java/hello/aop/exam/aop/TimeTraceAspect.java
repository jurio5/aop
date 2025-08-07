package hello.aop.exam.aop;

import hello.aop.exam.annotation.TimeTraceLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect
public class TimeTraceAspect {

    @Around("@annotation(timeTraceLog)")
    public Object doTimeLog(ProceedingJoinPoint joinPoint, TimeTraceLog timeTraceLog) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        } finally {
            long endTime = System.currentTimeMillis();
            long result = endTime - startTime;

            if (result >= timeTraceLog.thresholdMillis()) {
                log.info("[TimeLog] {}, executed in {} ms", joinPoint.getSignature(), result);
            }
        }
    }
}
