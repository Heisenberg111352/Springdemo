package org.zwh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author zwh
 * @version V1.0
 * @Package org.zwh.aop
 * @date 2021/12/30 12:00
 */
@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(public * org.zwh.Controller.*.*(..))")
    public  void webLogs(){}


    @Before("webLogs()")
    public void deBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }

    @AfterReturning(returning = "object",pointcut = "webLogs()")
    public void deAfter(Object object)throws Throwable{
        System.out.println("方法的返回值："+object);

    }

    @AfterThrowing("webLogs()")
    public void throwss(){
        System.out.println("异常通知......");
    }

    @After("webLogs()")
    public  void after(){
        System.out.println("方法最后执行.....");
    }

//    @Around("webLogs()")
//    public Object arround(ProceedingJoinPoint pjp){
//        System.out.println("方法环绕通知开始.......");
//        try {
//            Object proceed = pjp.proceed();
//            System.out.println("方法环绕通知 结果是"+proceed);
//            return proceed;
//        }catch (Throwable e){
//            e.printStackTrace();
//            return null;
//        }
//
//    }
}
