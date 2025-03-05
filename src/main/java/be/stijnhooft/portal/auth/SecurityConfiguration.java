package be.stijnhooft.portal.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@RequiredArgsConstructor
@Slf4j
@PropertySource("classpath:/auth-default.properties")
public class SecurityConfiguration {

    private final AuthConfigurationProperties configurationProperties;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.debug("Configuring security filter chain of portal-auth");
        return http
                .cors(cors -> {
                    var corsConfig = new CorsConfiguration();
                    corsConfig.setAllowedOrigins(configurationProperties.allowedOrigins());
                    corsConfig.setAllowedMethods(configurationProperties.allowedMethods());
                    corsConfig.setAllowedHeaders(configurationProperties.allowedHeaders());
                    corsConfig.setAllowCredentials(true);
                    cors.configurationSource(_ -> corsConfig);
                })
                .authorizeHttpRequests(authorize -> {
                    try {
                        authorize
                                .requestMatchers(configurationProperties.unsecuredEndpoints()).permitAll()
                                .anyRequest().authenticated();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(Customizer.withDefaults())
                )
                .build();
    }
}
