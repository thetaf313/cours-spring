package cours.udb.j2e.coursspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class CoursSpringApplication {
    public static void main(String[] args) {

        SpringApplication.run(CoursSpringApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }


}
