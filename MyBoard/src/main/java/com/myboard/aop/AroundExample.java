package com.myboard.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.ModelAttribute;

@EnableAspectJAutoProxy
@Aspect
@Component
public class AroundExample {
	
		@Autowired
		private AOPMapper aopMapper;
		
		@ModelAttribute("active")
		public String active() {
			return "AOPModel";
		}
		
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
		        AOPModel aop = new AOPModel();
		        aop.setStdname("최성찬");
		        aop.setPointcut("postInsert()");
		        aop.setElapsedtime(elapsedTimeBySecond+"초");
		        aopMapper.insert(aop);
		        return obj;  
	    }

}
