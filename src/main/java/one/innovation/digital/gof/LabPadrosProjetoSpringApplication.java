package one.innovation.digital.gof;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring Boot gerado via Spring Initializr
 * Os seguintes módulos foram selecionados:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 *
 * Dependência adicional adicionado via pom.xml:
 * - Springdoc
 */

@EnableFeignClients
@SpringBootApplication
public class LabPadrosProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadrosProjetoSpringApplication.class, args);
	}

}
