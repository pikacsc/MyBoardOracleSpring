package com.myboard.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@EnableAspectJAutoProxy
@Aspect
@Component
public class AroundExample {
	
	
	   protected Log log = LogFactory.getLog(AroundExample.class);
	   public AroundExample() {
		   System.out.println("/////////////////////////////////////////////////////////////////////////////Asepect");
	   }
	     
		@Around("execution(* com.myboard.web.controller.BoardController.postInsert(..))")  
		public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
			   StopWatch watch = new StopWatch();
		        watch.start();
		        Object obj=pjp.proceed();  
		        watch.stop();
		        Double elapsedTimeBySecond = watch.getTotalTimeSeconds();
		        System.out.println("──────────────────────────insertBoard 메소드 소요시간 = "+elapsedTimeBySecond+"초───────────────────────────");
		        return obj;  
	    }

}
