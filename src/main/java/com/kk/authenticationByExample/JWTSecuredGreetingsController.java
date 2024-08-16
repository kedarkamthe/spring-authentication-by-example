package com.kk.authenticationByExample;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class JWTSecuredGreetingsController {


    @GetMapping("/greet")
    public Map<String, Object> user(Authentication authentication) {
        // This method will return all the claims in JWT token
        if (authentication.getPrincipal() instanceof Jwt jwt )  {
            return jwt.getClaims();
        }
        return null;
    }



}
