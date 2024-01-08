package hello.itemservice;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@Slf4j
@EnableScheduling	//스케줄을 활성화 하고, Bean으로 등록된 @Scheduled 를 감지하기 위한 어노테이션
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
@EnableBatchProcessing	//스프링 배치 활성화, 사용 시 스프링 배치 프레임워크 의존성 필요
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
		log.info("slf4j spring project new start");
	}

}
