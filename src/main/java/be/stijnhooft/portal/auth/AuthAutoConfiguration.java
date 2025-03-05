package be.stijnhooft.portal.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableConfigurationProperties(AuthConfigurationProperties.class)
@Import({SecurityConfiguration.class})
@Slf4j
public class AuthAutoConfiguration {

    public AuthAutoConfiguration() {
      log.debug("Setting up portal-auth-starter");
    }

}
