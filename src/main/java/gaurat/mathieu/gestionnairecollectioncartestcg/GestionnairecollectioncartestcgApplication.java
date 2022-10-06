package gaurat.mathieu.gestionnairecollectioncartestcg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableWebMvc
public class GestionnairecollectioncartestcgApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionnairecollectioncartestcgApplication.class, args);
	}
	
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("gaurat.mathieu.gestionnairecollectioncartestcg"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());                                           
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Gestionnaire de collections de cartes TCG - Spring Boot REST API Documentation")
            .description("REST APIs For managing TCG cards collections")
            .contact(new Contact("Mathieu Gaurat", "", "noreply.library.test@gmail.com"))
            .version("1.0")
            .build();
    }

}
