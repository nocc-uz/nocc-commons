package uz.nocc.commons.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.request.WebRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Jonibek Amirkulov (thejwa)
 * @since 30/11/23 Thursday
 */

@Configuration
public class ApplicationConfig {
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ");

    @Bean("runner")
    public CommandLineRunner runner() {
        return args -> System.out.printf("START: %s%n", format.format(new Date()));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public ErrorAttributes errorAttributes() {
        return new DefaultErrorAttributes() {

            @Override
            public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
                Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);

                Object timestamp = System.currentTimeMillis();
                Object message = errorAttributes.get("message");
                String error = String.valueOf(errorAttributes.get("error"));

                Map<String, Object> responseEntity = new LinkedHashMap<>();

                responseEntity.put("data", null);
                if (Objects.isNull(message)) {
                    responseEntity.put("errorMessage", error.substring(0, Math.min(22, error.length())));
                } else {
                    responseEntity.put("errorMassage", message);
                }
                responseEntity.put("timestamp", timestamp);
                return responseEntity;
            }
        };
    }
}
