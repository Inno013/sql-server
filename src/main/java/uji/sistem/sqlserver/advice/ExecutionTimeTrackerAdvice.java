package uji.sistem.sqlserver.advice;

import jakarta.annotation.PreDestroy;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTrackerAdvice {

    private long totalExecutionTime = 0;
    private long totalExecutions = 0;
    Logger logger = LoggerFactory.getLogger(ExecutionTimeTrackerAdvice.class);

    @Around("@annotation(uji.sistem.sqlserver.advice.TrackExecutionTime)")
    public Object trackTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        totalExecutionTime += executionTime;
        totalExecutions++;
        logger.info("Method name: {} - Time taken to execute: {} ms", joinPoint.getSignature(), executionTime);
        return object;
    }

    public double getAverageExecutionTime() {
        if (totalExecutions == 0) {
            return 0;
        }
        return (double) totalExecutionTime / totalExecutions;
    }
}
