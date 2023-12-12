package uz.nocc.commons.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        type = SecuritySchemeType.APIKEY,
        in = SecuritySchemeIn.HEADER,
        name = "X-Auth-Token",
        scheme = "X-Auth-Token"
)
@OpenAPIDefinition(
        info = @Info(
                title = "Kyuu Backend",
                description = "API list of Kyuu application",
                version = "1.0.0",
                contact = @Contact(name = "Jonibek, Saydali", email = "+998-99-972-02-72, +998-97-313-00-80")
        ),
        servers = @Server(url = "/"),
        security = @SecurityRequirement(name = "X-Auth-Token")
)
public class SwaggerConfig {
}
