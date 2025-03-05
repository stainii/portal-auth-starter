package be.stijnhooft.portal.auth;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "portal.auth")
public record AuthConfigurationProperties (
        String keycloakUri,
        String realm,
        List<String> allowedOrigins,
        List<String> allowedMethods,
        List<String> allowedHeaders,
        String[] unsecuredEndpoints
) {
}
