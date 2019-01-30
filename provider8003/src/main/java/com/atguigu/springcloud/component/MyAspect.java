package com.atguigu.springcloud.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class MyAspect {

    @Pointcut(value = "@annotation(com.atguigu.springcloud.component.NameInterface)")
    public void log(){}

    @AfterReturning(value = "log()",returning = "rvt")//returning表示目标方法的返回值
    public void AfterReturning(JoinPoint joinPoint,Object rvt) throws Exception {
        Object[] args = joinPoint.getArgs();//获取参数值
        for(Object o : args){
            System.out.println(o);
        }
        System.out.println(rvt);
        System.out.println(joinPoint.getArgs()[0]+"getArgs");
        System.out.println(joinPoint.getKind()+"getKind");
        System.out.println(joinPoint.getSourceLocation()+"getSourceLocation");
        System.out.println(joinPoint.getTarget()+"getTarget");
        System.out.println(joinPoint.getStaticPart()+"getStaticPart");
        System.out.println(joinPoint.getThis()+"getThis");
        System.out.println(joinPoint.getSignature().getDeclaringType()+"getDeclaringType");
        System.out.println(joinPoint.getSignature().getModifiers()+"getModifiers");
        System.out.println(joinPoint.getSignature().getDeclaringTypeName()+"-----"+joinPoint.getSignature().getName());
        Class c = Class.forName(joinPoint.getSignature().getDeclaringTypeName());
        System.out.println(c);
        Method method = c.getDeclaredMethod(joinPoint.getSignature().getName(), String.class,Integer.class);
        System.out.println(method.getName());
        NameInterface declaredAnnotation = method.getDeclaredAnnotation(NameInterface.class);
        System.out.println(declaredAnnotation.value());
    }
}
