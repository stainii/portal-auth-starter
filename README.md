# portal-auth-starter

Spring Boot starter to configure oauth in the Portal suite.

## Properties

| Property                        | Description                                                  | Default                                            |
|---------------------------------|--------------------------------------------------------------|----------------------------------------------------|
| portal.auth.keycloak-uri        | The uri of the authorization server WITHOUT trailing slash   | No default, always has to be configured            |
| portal.auth.realm               | The realm of the authorization server                        | portal-realm                                       |
| portal.auth.allowed-origins     | Allowed origins for CORS                                     | http://localhost:4200,https://portal.stijnhooft.be |
| portal.auth.allowed-methods     | Allowed methods for CORS                                     | GET,POST,PUT,DELETE,PATCH                          |
| portal.auth.allowed-headers     | Allowed headers for CORS                                     | *                                                  |
| portal.auth.unsecured-endpoints | List of regexes for endpoint urls that should not be secured | Empty list, so everything is secured               |
