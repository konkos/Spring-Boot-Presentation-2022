package gr.opensourceuom.presentation.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {

    Logger logger = LoggerFactory.getLogger(MyAdvice.class);

    @Before("execution(public String gr.opensourceuom.presentation.hello.HelloController.*(..))")
    public void beforeHello(JoinPoint jp) {
        logger.info("BEFORE METHOD EXECUTION");

        String name = jp.getSignature().getName();
        logger.info("Name " + name);
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            logger.info(arg.toString());
        }
    }

    @After("execution(public String gr.opensourceuom.presentation.hello.HelloController.*(..))")
    public void afterHello(JoinPoint jp) {
        logger.info("AFTER METHOD EXECUTION");

        String name = jp.getSignature().getName();
        logger.info("Name " + name);
        Object[] args = jp.getArgs();
        for (Object arg : args) {
            logger.info(arg.toString());
        }
    }


    @Pointcut("execution(public String gr.opensourceuom.presentation.hello.HelloController.*(..))")
    public void myPointCut() {
    }

    @After("myPointCut()")
    public void afterPointCut() {
        logger.info("POINTCUT");
    }
}
