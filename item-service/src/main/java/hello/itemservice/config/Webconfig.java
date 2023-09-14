package hello.itemservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Webconfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String connectPath = "/add/images/upload/**";
        String resourcePath = "file://add/images/upload/";
        registry.addResourceHandler(connectPath)
                .addResourceLocations(resourcePath);
    }
}
