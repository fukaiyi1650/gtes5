package com.yitiankeji.aop;

import com.thoughtworks.xstream.XStream;
import com.yitiankeji.dao.LogDao;
import com.yitiankeji.entity.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Component
public class LogAspect {

    @Autowired
    private LogDao logDao;

    @Pointcut("execution(public com.yitiankeji.**.*Service.*(..))")
    public void pointcunt() {
    }

    @Around("pointcunt")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 时间
        Log log = new Log();
        log.setCreateTime(new Date());
        // 方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        log.setMethodName(method.toString());
        // 参数
        Object[] args = joinPoint.getArgs();
        XStream stream = new XStream();
        log.setArgs(stream.toXML(args));
        // 返回值
        try {
            Object result = joinPoint.proceed();
            log.setResult(stream.toXML(result));
            return result;
        } catch (Throwable e) {
            // 异常
            log.setError(true);
            log.setException(stream.toXML(e));
            throw e;
        } finally {
            logDao.save(log);
        }
    }
}
