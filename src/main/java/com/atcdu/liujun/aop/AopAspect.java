package com.atcdu.liujun.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AopAspect {

//  aop执行顺序
//    try{
//        @before
//        method
//        @AfterReturning
//    }
//    catch{
//          @AfterThrowing
//    }
//    finally{
//           @After
//    }
//环绕通知是整个阶段都可以
    @Pointcut("execution(public int com.atcdu.liujun.aop.AopTarget.add(..))")
    public void commonPointCut(){}
    @Before("commonPointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("方法开始之前");
        Object[] args=joinPoint.getArgs();
        System.out.println("获取目标方法的参数列表"+ Arrays.asList(args));
    }
    @AfterReturning("commonPointCut()")
    public void afterReturn() {
        System.out.println("方法正常结束之后");
    }
    @AfterThrowing("commonPointCut()")
    public void throwEx() {
        System.out.println("方法报异常");
    }
//    @Around("execution(public int com.atcdu.liujun.aop.AopTarget.add(..))")
    public void aroud() {
        System.out.println("环绕通知");
    }
    @After("commonPointCut()")
    public void after() {
        System.out.println("方法最终结束");
    }
}
