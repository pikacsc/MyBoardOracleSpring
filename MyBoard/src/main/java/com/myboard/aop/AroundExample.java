package com.myboard.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AroundExample {
	
	
	   protected Log log = LogFactory.getLog(AroundExample.class);
	   public AroundExample() {
		   System.out.println("/////////////////////////////////////////////////////////////////////////////Asepect");
	   }
	     
		@Around("excution(* com.myboard.web.controller..*(..))")
		public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
			
			
			//스톱워치 시작
			long startTime = System.currentTimeMillis();
			Object retVal = pjp.proceed();
			//스톱워치 멈춤
			long elapsedTime = System.currentTimeMillis() - startTime;
	        log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 게시판 insert 소요 시간 :" +elapsedTime*1000 +"초");
	        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 게시판 insert 소요 시간 :" +elapsedTime*1000 +"초");
	        return retVal;
	    }

}
