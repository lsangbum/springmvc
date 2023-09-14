package hello.itemservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* connectPath = 실행중인 소스 내 해당 url 로 호출이 있는 경우
         * resourcePath = 실행중인 서비스 외부 경로 root 부터 시작하는 경우 file:/// 슬레쉬3개 경로는 반드시 /로 닫혀있어야함
         */
        String connectPath = "/app/images/upload/**";
        String resourcePath = "file:///app/images/upload/";
        registry.addResourceHandler(connectPath)
                .addResourceLocations(resourcePath);
    }
}
