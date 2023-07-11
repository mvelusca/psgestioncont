package fr.amexio.ecm_as_a_service;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ECM as a Service API", version = "1.0", description = "Project Information"))
public class EcmApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcmApplication.class, args);
    }

}
