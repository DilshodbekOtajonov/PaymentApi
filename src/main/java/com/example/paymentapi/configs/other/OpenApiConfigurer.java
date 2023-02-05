package com.example.paymentapi.configs.other;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

/**
 * @author "Otajonov Dilshodbek"
 * @since 03/02/23/16:46 (Friday)
 * spring-boot-features/IntelliJ IDEA
 */


@Configuration
@OpenAPIDefinition(
        info = @Info(title = "Payment application API", version = "v1",
                description = "This API just for learning purposes\n\nreminder: use jwt token for closed apis. login and register are only open apis",
                contact = @Contact(name = "Dilshodbek", url = "https://forbes.com", email = "dilshodbekotajonov95@gmail.com"),
                license = @License(name = "Apache Foundation", url = "http://apache.org")
        ),
        security = {
                @SecurityRequirement(
                        name = "Bearer"
                )
        }
)
@SecurityScheme(
        name = "Bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "Bearer"
)
public class OpenApiConfigurer {

}
