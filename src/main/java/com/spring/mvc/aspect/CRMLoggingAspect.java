package com.spring.mvc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class CRMLoggingAspect {

    // setup logger
    private final Logger logger = Logger.getLogger(getClass().getName());

    // setup pointcut declaration
    @Pointcut("execution(* com.spring.mvc.controller.*.*(..))")
    private void forControllerPackage() {

    }

    // do the same for repository and service
    @Pointcut("execution(* com.spring.mvc.repository.*.*(..))")
    private void forRepositoryPackage() {

    }

    @Pointcut("execution(* com.spring.mvc.service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("forControllerPackage() || forRepositoryPackage() || forServicePackage()")
    private void forAppFlow() {

    }

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        // display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("@Before method: " + method);

        // display the argument to the method

        // get the arguments
        Object[] args = joinPoint.getArgs();

        // loop thru and display args
        for (Object arg : args) {
            logger.info("Arguments: " + arg);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinpoint, Object result) {

        // display method we are returning from
        String method = joinpoint.getSignature().toShortString();
        logger.info("@AfterReturning method: " + method);

        // display date returned
        logger.info("result: " + result);
    }

//    @Around("forAppFlow()")
//    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        String method = proceedingJoinPoint.getSignature().toShortString();
//        logger.info("@Before method: " + method);
//        Object[] args = proceedingJoinPoint.getArgs();
//
//        for (Object arg : args) {
//            logger.info("Arguments: " + arg);
//        }
//
//        proceedingJoinPoint.proceed();
//
//        logger.info("@AfterReturning method: " + method);
//        logger.info("result: " + proceedingJoinPoint.proceed());
//
//        return proceedingJoinPoint.proceed();
//    }

}
