package com.wheelsunspringJwt.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.transaction.annotation.Transactional;

@Configuration
public class CustomLogoutHandler implements LogoutHandler {

    public CustomLogoutHandler() {

    }

    @Override
    @Transactional
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        // Aquí simplemente puedes limpiar el contexto de seguridad si es necesario
        // Pero el token se maneja y se elimina en el cliente
        if (authentication != null) {
            authentication.setAuthenticated(false);
        }
    }
}
