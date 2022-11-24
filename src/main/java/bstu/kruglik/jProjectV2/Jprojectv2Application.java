package bstu.kruglik.jProjectV2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("bstu.kruglik.*")
@EnableJpaRepositories("bstu.kruglik.*")
public class Jprojectv2Application {

    public static void main(String[] args) {
        SpringApplication.run(Jprojectv2Application.class, args);
    }

}
