package tn.esprit.tp1_hanini_mohamed_mehdi_4twin7.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("TP étude de cas")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("HANINI Mohamed MEHDI")
                .email("hanini.mohamedmehdi@esprit.tn")
                .url("https://www.linkedin.com/in/hanini-mehdi/");
        return contact;
    }


}

