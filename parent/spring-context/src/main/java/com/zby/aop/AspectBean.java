package com.zby.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectBean {
	// ���������Ҫʹ������������ʽ������Ϊһ�����õ�
	@Pointcut("execution(* com.zby.aop..*(..))")
	public void myPointCut() {

	}

	// ����ע�������ֵΪ����ķ�����
	@Before("myPointCut()")
	public void myBefore(JoinPoint joinPoint) {
		System.out.println("ǰ��֪ͨ �� " + joinPoint.getSignature().getName());
	}

	// ����ֻ��һ������������ֻ������ã�����ֱ��д�������ʽ
	@AfterReturning(value = "execution(* com.zby.aop..*(..))", returning = "ret")
	public void myAfterReturning(JoinPoint joinPoint, Object ret) {
		System.out.println("����֪ͨ �� " + joinPoint.getSignature().getName() + " , -->" + ret);
	}

	//
	@Around("myPointCut()")
	public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("����ִ֪ͨ�з���ǰ");
		// �ֶ�ִ��Ŀ�귽��
		Object obj = joinPoint.proceed();

		System.out.println("����ִ֪ͨ�з�����");
		return obj;
	}

	@AfterThrowing(value = "myPointCut()", throwing = "e")
	public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
		System.out.println("�׳��쳣֪ͨ �� " + e.getMessage());
	}

	@After("myPointCut()")
	public void myAfter(JoinPoint joinPoint) {
		System.out.println("����֪ͨ");
	}
}
