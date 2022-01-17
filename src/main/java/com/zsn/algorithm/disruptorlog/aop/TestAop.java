package com.zsn.algorithm.disruptorlog.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author : zhou sen nan
 * @Date : 2021/11/23  14:14
 */
@Aspect
@Component
public class TestAop {
//* com.sample.service.impl..*.*(..)
    @Around("execution(* com.zsn.algorithm.disruptorlog.controller..*.*(..))")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) {

        System.out.println("ssssssssss");
        return null;
    }
}
