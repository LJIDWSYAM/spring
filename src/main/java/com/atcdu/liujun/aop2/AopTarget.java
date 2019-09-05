package com.atcdu.liujun.aop2;

import org.springframework.stereotype.Component;

public class AopTarget {
    public int add(int i ,int j){
        System.out.println("执行加法");
        int a=i+j;
        return a;
    }
    public void jian(){
        System.out.println("执行减法");
    }
    public void cheng(){
        System.out.println("执行乘法");
    }
    public void chu(){
        System.out.println("执行除法");
    }
}
