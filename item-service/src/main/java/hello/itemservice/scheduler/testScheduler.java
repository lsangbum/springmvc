package hello.itemservice.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @writer 이상범
 * @date    231122
 * @script  스케줄러 사용 시 해당 클레스를 빈에 등록해야한다.
 * 하여, @Service, @Controller 등 @Component라는 빈으로 등록시켜주는 기능을 수행하는
 * 어노테이션을 내장한 어노테이션이 클레스레벨에 등록되어 있어야한다.
 */
@Component
public class testScheduler {
    /**
     * @writer 이상범
     * @date    231122
     * @script  스케줄러 테스트
     * @Scheduled 스프링프레임웤의 Scheduled 라는 인터페이스로 특정 메서드를 일정한 주기로 반복사용하고자 할 때에
     * 해당 메서드 위에 @Scheduled라는 어노테이션과 반복주기를 입력해준다.
     * 1000 = 1초, 10000 = 10초, 60000 = 1분, 600000 = 10분 , 3600000 = 1시간 이며,
     * 해당 어노테이션의 속성으로는 fixedRate, fixedDelay 등 다양한 속성값을 가진다.
     * 각각의 속성별로 반복주기 패턴이 다르다.
     * 예제에서 사용한 fixedRate의 경우 실행시간에 상관없이 입력시간마다 반복된다.
     *
     * 또한, @Scheduled 사용 시 main()메서드가 존재하는 위치의 클래스 레벨에
     * @EnableScheduling 이 등록되어 있어야한다.
     * 프로젝트 실행 시 @Component에 의하여 해당 클레스가 Bean으로 등록되고
     * @EnableScheduling 어노테이션은 등록된 Bean 내 @Scheduled를 감지한다.
     */
    @Scheduled(fixedRate = 1000)
    public void testPostsContainingSpecificText() {
        System.out.println("test");
    }


}
