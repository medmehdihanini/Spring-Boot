package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.configuration.OpenAPIConfig;
@EnableScheduling

@SpringBootApplication
public class Tp1HaniniMohamedMehdi4twin7Application {
	public static void main(String[] args) {
		SpringApplication.run(Tp1HaniniMohamedMehdi4twin7Application.class, args);
	}

}
