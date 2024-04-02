package com.helloIftekhar.springJwt.config;

import com.helloIftekhar.springJwt.model.Token;
import com.helloIftekhar.springJwt.repository.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class CustomLogoutHandler implements LogoutHandler {

    private final TokenRepository tokenRepository;

    public CustomLogoutHandler(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    @Transactional
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String tokenValue = authHeader.substring(7);
            tokenRepository.findByToken(tokenValue).ifPresent(token -> {
                token.setLoggedOut(true);
                tokenRepository.save(token);
            });
        }
    }
}
