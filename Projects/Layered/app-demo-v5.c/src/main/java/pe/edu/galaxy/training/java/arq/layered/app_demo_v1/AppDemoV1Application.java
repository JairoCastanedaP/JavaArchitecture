package pe.edu.galaxy.training.java.arq.layered.app_demo_v1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AppDemoV1Application {

	public static void main(String[] args) {
		SpringApplication.run(AppDemoV1Application.class, args);
	}

}
