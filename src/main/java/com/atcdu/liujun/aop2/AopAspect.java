package com.atcdu.liujun.aop2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;


public class AopAspect {
    public void before(JoinPoint joinPoint) {
        System.out.println("方法开始之前");
        Object[] args=joinPoint.getArgs();
        System.out.println("获取目标方法的参数列表"+ Arrays.asList(args));
    }

    public void afterReturn() {
        System.out.println("方法正常结束之后");
    }

    public void throwEx() {
        System.out.println("方法报异常");
    }

    public void aroud() {
        System.out.println("环绕通知");
    }

    public void after() {
        System.out.println("方法最终结束");
    }
}
