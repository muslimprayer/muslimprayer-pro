package com.muslim.prayer.pro.interceptor;

import com.muslim.prayer.pro.dto.PrayerTime;
import com.muslim.prayer.pro.dto.Response;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author :XXX
 * @description : Muslim Prayer ProInterceptor
 * @date : 2022/7/20 17:10
 */
@Component
@Aspect
@Slf4j
public class MuslimPrayerProInterceptor {
    @Pointcut("execution(* com.muslim.prayer.pro.MuslimPrayerProApp.*(..))")
    public void muslimPrayerProPointCut() {
    }

    @Around("muslimPrayerProPointCut()")
    public Object interceptor(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            log.error("muslim prayer pro interceptor exception,e:{}", e.getMessage());
            return Response.builder().build().getFail();
        }
    }

}
