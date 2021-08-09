package finalexam;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Sv2021JvjbfZarovizsgaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sv2021JvjbfZarovizsgaApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Teams API")
                        .version("1.0.0")
                        .description("Teams Program"));
    }

    @Bean
    public JpaTransactionManager transactionManager(){
        return new JpaTransactionManager();
    }
}
