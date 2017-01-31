package pl.ironaltar.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import pl.ironaltar.services.UserService;
import pl.ironaltar.services.UserServiceImpl;

@SuppressWarnings("deprecation")
@Configuration
public class WebConfiguration {

    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(true).
                favorParameter(true).
                parameterName("mediaType").
                ignoreAcceptHeader(true).
                useJaf(false).
                defaultContentType(MediaType.APPLICATION_JSON);
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }



}
