package kurly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication//(exclude = {MultipartAutoConfiguration.class})
public class KuklyApplication {
	public static void main(String[] args) {
		SpringApplication.run(KuklyApplication.class, args);
	}

}
