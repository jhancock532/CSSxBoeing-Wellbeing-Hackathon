package packages.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer{
    
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/search").setViewName("search");
        registry.addViewController("/principles").setViewName("principles");
        registry.addViewController("/contribute").setViewName("contribute");
        registry.addViewController("/site-information").setViewName("site-information");
    }
    
}
