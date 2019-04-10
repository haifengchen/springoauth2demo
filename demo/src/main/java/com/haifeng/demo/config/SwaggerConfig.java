package com.haifeng.demo.config;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import java.util.*;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .securitySchemes(Collections.singletonList(securitySchema()))
                .securityContexts(Collections.singletonList(securityContext()))
                .apiInfo(apiInfo()).select().paths(postPaths())
                .build();
    }

    private Predicate<String> postPaths() {
        return or(regex("/product/.*"), regex("/order/.*"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Haifeng Test API")
                .description("Haifeng Test API")
                .contact("haifeng_chen@yeah.net").license("MIT")
                .licenseUrl("haifeng_chen@yeah.net").version("1.0").build();
    }


    private OAuth securitySchema() {

        List<AuthorizationScope> authorizationScopeList = new ArrayList();
        authorizationScopeList.add(new AuthorizationScope("select", "all"));
//        authorizationScopeList.add(new AuthorizationScope("read", "read all"));
//        authorizationScopeList.add(new AuthorizationScope("trust", "trust all"));
//        authorizationScopeList.add(new AuthorizationScope("write", "access all"));

        List<GrantType> grantTypes = new ArrayList();
        GrantType creGrant = new ResourceOwnerPasswordCredentialsGrant(authLink);

        grantTypes.add(creGrant);
        creGrant = new ClientCredentialsGrant(authLink);

        grantTypes.add(creGrant);

        return new OAuth("oauth2schema", authorizationScopeList, grantTypes);

    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.ant("/order/**"))
                .build();
    }

    private List<SecurityReference> defaultAuth() {

        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = new AuthorizationScope("read", "read all");
//        authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
//        authorizationScopes[2] = new AuthorizationScope("write", "write all");
        authorizationScopes[0] = new AuthorizationScope("select", "all");

        return Collections.singletonList(new SecurityReference("oauth2schema", authorizationScopes));
    }
    private String clientId;
    private String clientSecret;
    @Value("${swagger.token-uri}")
    private String authLink;

    @Bean
    public SecurityConfiguration securityInfo() {
        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("grant_type","password");
        return new SecurityConfiguration(clientId, clientSecret, "", "","",queryParam,true);
    }
}
