//package hello.itemservice.scheduler;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
///**
// * @writer 이상범
// * @date    231122
// * @script  스케줄러 사용 시 해당 클레스를 빈에 등록해야한다.
// * 하여, @Service, @Controller 등 @Component라는 빈으로 등록시켜주는 기능을 수행하는
// * 어노테이션을 내장한 어노테이션이 클레스레벨에 등록되어 있어야한다.
// */
//@Component  //해당 클래스를 Bean으로 등록시켜 @Scheduled 어노테이션을 감지할 수 있도록 함
//public class testScheduler {
//    /**
//     * @writer 이상범
//     * @date    231122
//     * @script  스케줄러 테스트
//     * @Scheduled 스프링프레임웤의 Scheduled 라는 인터페이스로 특정 메서드를 일정한 주기로 반복사용하고자 할 때에
//     * 해당 메서드 위에 @Scheduled라는 어노테이션과 반복주기를 입력해준다.
//     * 1000 = 1초, 10000 = 10초, 60000 = 1분, 600000 = 10분 , 3600000 = 1시간 이며,
//     * 해당 어노테이션의 속성으로는 fixedRate, fixedDelay 등 다양한 속성값을 가진다.
//     * 각각의 속성별로 반복주기 패턴이 다르다.
//     * 예제에서 사용한 fixedRate의 경우 실행시간에 상관없이 입력시간마다 반복된다.
//     *
//     * 또한, @Scheduled 사용 시 main()메서드가 존재하는 위치의 클래스 레벨에
//     * @EnableScheduling 이 등록되어 있어야한다.
//     * 프로젝트 실행 시 @Component에 의하여 해당 클레스가 Bean으로 등록되고
//     * @EnableScheduling 어노테이션은 등록된 Bean 내 @Scheduled를 감지한다.
//     */
//    @Scheduled(fixedRate = 1000, initialDelay = 5000)
//    public void testPostsContainingSpecificText() {
//        long time = System.currentTimeMillis();
//        System.out.println("test : " + time);
//    }
//
//    /**
//     * @script
//     * cron 속성의 앞 숫자부터 초, 분, 시, 일, 월, 요일 을 나타내면 최대 6자리이다.
//     * zone의 경우 입력하지 않는 경우 Default로 Local의 time zone으로 설정된다.
//     */
//    @Scheduled(cron = "* * * * * *", zone = "Asis/Seoul")
//    public void testCronExpession() {
//        long time = System.currentTimeMillis();
//        System.out.println("test : " + time);
//    }
//
//    /* cron 표현식 예제
//    // 매일 18시에 실행
//    @Scheduled(cron = "0 0 18 * * *")
//    public void run() {
//        System.out.println("Hello CoCo World!");
//    }
//
//    // 매달 10일,20일 14시에 실행
//    @Scheduled(cron = "0 0 14 10,20 * ?")
//    public void run() {
//        System.out.println("Hello CoCo World!");
//    }
//
//    // 매달 마지막날 22시에 실행
//    @Scheduled(cron = "0 0 22 L * ?")
//    public void run() {
//        System.out.println("Hello CoCo World!");
//    }
//
//    // 1시간 마다 실행 ex) 01:00, 02:00, 03:00 ...
//    @Scheduled(cron = "0 0 0/1 * * *")
//    public void run() {
//        System.out.println("Hello CoCo World!");
//    }
//
//    // 매일 9시00분-9시55분, 18시00분-18시55분 사이에 5분 간격으로 실행
//    @Scheduled(cron = "0 0/5 9,18 * * *")
//    public void run() {
//        System.out.println("Hello CoCo World!");
//    }
//
//    // 매일 9시00분-18시55분 사이에 5분 간격으로 실행
//    @Scheduled(cron = "0 0/5 9-18 * * *")
//    public void run() {
//        System.out.println("Hello CoCo World!");
//    }
//
//    // 매달 1일 10시30분에 실행
//    @Scheduled(cron = "0 30 10 1 * *")
//    public void run() {
//        System.out.println("Hello CoCo World!");
//    }
//
//    // 매년 3월내 월-금 10시30분에 실행
//    @Scheduled(cron = "0 30 10 ? 3 1-5")
//    public void run() {
//        System.out.println("Hello CoCo World!");
//    }
//
//    // 매달 마지막 토요일 10시30분에 실행
//    @Scheduled(cron = "0 30 10 ? * 6L")
//    public void run() {
//        System.out.println("Hello CoCo World!");
//    }*/
//}
