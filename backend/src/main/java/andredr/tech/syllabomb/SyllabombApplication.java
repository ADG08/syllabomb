package andredr.tech.syllabomb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SyllabombApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyllabombApplication.class, args);
	}

}
