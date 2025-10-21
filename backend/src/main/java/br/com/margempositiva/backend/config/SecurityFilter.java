package br.com.margempositiva.backend.config;

import br.com.margempositiva.backend.autenticacao.services.TokenService;
import br.com.margempositiva.backend.usuario.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("==============================================");
        System.out.println(">>>> [SECURITY FILTER] INICIANDO FILTRO <<<<");

        var token = this.recoverToken(request);

        if (token != null) {
            System.out.println(">>>> [SECURITY FILTER] Token encontrado no header.");
            var email = tokenService.validateToken(token);
            System.out.println(">>>> [SECURITY FILTER] Email extraído do token: " + email);

            if (email != null && !email.isEmpty()) {
                UserDetails user = usuarioRepository.findByEmail(email).orElse(null);

                if (user != null) {
                    System.out.println(">>>> [SECURITY FILTER] Usuário encontrado no banco: " + user.getUsername());
                    var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                    
                   
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    System.out.println(">>>> [SECURITY FILTER] Usuário autenticado e colocado no Contexto de Segurança.");
                } else {
                    System.out.println("!!!! [SECURITY FILTER] ERRO: Email do token não corresponde a nenhum usuário no banco.");
                }
            } else {
                 System.out.println("!!!! [SECURITY FILTER] ERRO: Token inválido ou expirado.");
            }
        } else {
            System.out.println(">>>> [SECURITY FILTER] Nenhum token JWT encontrado no header 'Authorization'.");
        }
        
        System.out.println(">>>> [SECURITY FILTER] Encaminhando requisição para o próximo filtro...");
        System.out.println("==============================================");
        
    
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) {
            return null;
        }
        return authHeader.replace("Bearer ", "");
    }
}