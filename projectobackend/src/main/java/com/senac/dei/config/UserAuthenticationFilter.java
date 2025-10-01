package com.senac.dei.config;

import com.senac.dei.entity.Usuario;
import com.senac.dei.repository.UsuarioRepository;
import com.senac.dei.service.JwtTokenService;
import com.senac.dei.service.UserDetailsImpl;
import com.senac.dei.entity.Usuario;
import com.senac.dei.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import static com.senac.dei.config.SecurityConfiguration.ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED;

@Component
public class UserAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenService jwtTokenService; // Service que definimos anteriormente

    @Autowired
    private UsuarioRepository userRepository; // Repository que definimos anteriormente

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, IOException {
        // Verifica se o endpoint requer autenticação antes de processar a requisição
        System.out.println(checkIfEndpointIsNotPublic(request) + " "  + request.getRequestURI());
        if (checkIfEndpointIsNotPublic(request)) {

            String token = recoveryToken(request); // Recupera o token do cabeçalho Authorization da requisição
            if (token != null) {
                String subject = jwtTokenService.getSubjectFromToken(token); // Obtém o assunto (neste caso, o nome de usuário) do token
                Usuario user = userRepository.findByusuario_email(subject).get(); // Busca o usuário pelo email (que é o assunto do token)
                UserDetailsImpl userDetails = new UserDetailsImpl(user); // Cria um UserDetails com o usuário encontrado

                // Cria um objeto de autenticação do Spring Security
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(userDetails.getUsername(), null, userDetails.getAuthorities());

                // Define o objeto de autenticação no contexto de segurança do Spring Security
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                    throw new RuntimeException("O token está ausente.");
            }
        }
        // Continua o processamento da requisição
        filterChain.doFilter(request, response);
    }

    // Recupera o token do cabeçalho Authorization da requisição
    private String recoveryToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }
        return null;
    }

    private boolean checkIfEndpointIsNotPublic(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        if (requestURI.contains(".png") || requestURI.contains(".js") || requestURI.contains(".css")){
            return false;
        }
        for (String publicEndpoint : SecurityConfiguration.ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED) {
            if (requestURI.contains(publicEndpoint)) {
                // Found a match (it is public), so the function should return false
                return false;
            }
        }
        // No match found (it is not public), so the function returns true
        return true;
    }


//    private boolean checkIfEndpointIsNotPublic(HttpServletRequest request) {
//        String requestURI = request.getRequestURI();
//        return !Arrays.asList(SecurityConfiguration.ENDPOINTS_WITH_AUTHENTICATION_NOT_REQUIRED).contains(requestURI);
//    }
}