package cours.udb.j2e.coursspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class CoursSpringApplication {
    public static void main(String[] args) {

        SpringApplication.run(CoursSpringApplication.class, args);
    }

}
