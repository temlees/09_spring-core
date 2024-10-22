package com.ohgiraffers.section01.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class LoggingAspect {
    /*
     * @Aspect
     * -pointcut 과 advice 를 하나의 클래스 단위로 정의하기 위한
     * 어노테이션이다
     *
     * 조인 포인트 - aop에서 특정한 실행 시점을 의미한다
     * *종류
     *   메소드 호출 = 특정메소드가 호출될 때
     *   메소드 실행 = 특정 메소드의 실행이 완료된 후
     *   예외발생 = 특정 메소드 내에서 예외가 발생할 때
     *   필드 접근  = 객체의 필드에 접근할 때
     *
     * pointcut = 특정 조건에 의해 필터링된 조인 포인트
     * 수 많은 조인 포인트중에 특정 메소드만 횡단 공통기능을 수행하기 위해사용
     * advice = 횡단 관심에 해당하는 공통 기능의 코드
     * */


    /*
     *   Pointcut = 관심 조인 포인트를 결정하여 어드바이스가 실행되는 시기를 제어한다
     *   execution = 메소드 실행조인 포인트를 매칭한다.
     *
     *   execution( * 리턴타입 . 이름(파라미터))
     *   *Service.*(..) = 매개변수가 0개 이상인 모든 메소드
     *   *Service.*(*) = 매개변수가 1개 이상인 모든 메소드
     *   *Service.*(*,*) = 매개변수가 2개 이상인 모든 메소드
     *
     * */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointCut() {
        System.out.println("이거 진짜 실행 안되나 ?");

    }

    //Before묶음 하나가 advice
    @Before("LoggingAspect.logPointCut()")
    public void logBefore(JoinPoint joinPoint) {
        // 현재 실행중인 타겟객체를 반환
        System.out.println("before joinPoint.getTarget() :" + joinPoint.getTarget());

        //호출된 메소드의 시그니처 반환
        //경로 타입 매개변수 등등 다 나오게 된다
        System.out.println("before joinPoint.getSignature() :" + joinPoint.getSignature());


        if (joinPoint.getArgs().length > 0) {
            System.out.println("before joinpoint.getArgs()[]:" + joinPoint.getArgs()[0]);

        }
    }

    @After("logPointCut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("after joinPoint.getTarget() :" + joinPoint.getTarget());
        System.out.println("after joinPoint.getSignature() :" + joinPoint.getSignature());

    }


    //aop가 적용될 메소드가 에러없이 정상적으로 실행된 이후 실행
    @AfterReturning(pointcut = "logPointCut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After Returning result :" + result);
//        if (result != null && result instanceof Map) {
//            ((Map<Integer, MemberDTO>) result).put(100, new MemberDTO(100, "가공한값"));
//        }
    }

    @AfterThrowing(pointcut = "logPointCut()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        System.out.println("After Throwing Exception :" + exception);
    }

    /*
    * Around Advice는 가장 강력한 어드바이스이다
    * 이 어드바이스는 조인포인트를 완전히 장악한다
    * 따라서 앞에 살펴본 어드바이스 모두 Around 어드바이스로 조합할 수 있다
    * 매개변수는 ProceddingJoinPoint로 고정되어있다
    * JoinPoint의 하위 인터페이스로 원본 조인포인트의 진행시점을 제어할 수 있다,
    * */

    @Around("logPointCut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //메소드 실행 전 로그 출력
        System.out.println("Arround Before : " +joinPoint.getSignature().getName());

        //원본 메소드 실행한다
        Object result  = joinPoint.proceed();
        //서비스 동작하고 결과값을 result로 받음

        if(result != null && result instanceof Map){
            ((Map<Integer,MemberDTO>)result).put(100,new MemberDTO(100,"반환값 가공"));
        }


/*
*
*  //원본 메소드 실행한다
        Object result  = joinPoint.proceed();
        //서비스 동작하고 결과값을 result로 받음

        if(result != null && result instanceof Map){
            ((Map<Integer,MemberDTO>)result).put(100,new MemberDTO(100,"반환값 가공"));
        } 주석처리하면 proceed가 못만났기때문에  실행이 안되게 된다
*  */

        //메소드 실행 후 로그 출력
        System.out.println("Arround After : " +joinPoint.getSignature().getName());

        //결과 반환
        return result;
    }
}