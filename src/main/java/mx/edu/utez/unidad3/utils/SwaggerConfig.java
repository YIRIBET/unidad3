package mx.edu.utez.unidad3.utils;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static java.awt.SystemColor.info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI config(){
        return new OpenAPI().info(new Info()
                .title("APi REST de almacenes")
                .description("documentacion de los endpoint del servicio de amacenes")
                .version("V1.0")
        );
    }
}
