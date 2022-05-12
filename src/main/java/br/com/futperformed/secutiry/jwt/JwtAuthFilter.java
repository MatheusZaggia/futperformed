package br.com.futperformed.secutiry.jwt;

import br.com.futperformed.service.impl.TimeServiceImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {


    private JwtService jwtService;
    private TimeServiceImpl timeService;

    public JwtAuthFilter(JwtService jwtService, TimeServiceImpl timeService) {
        this.jwtService = jwtService;
        this.timeService = timeService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authorization = httpServletRequest.getHeader("Authorization");

        if(authorization != null && authorization.startsWith("Bearer")) {
            String token = authorization.split(" ")[1];
            boolean isValid = jwtService.tokenValido(token);

            if(isValid){
                String loginUsuario = jwtService.obterLoginUsuario(token);
                UserDetails usuario = timeService.loadUserByUsername(loginUsuario);
                UsernamePasswordAuthenticationToken user =
                        new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

                user.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(user);

            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);


    }
}
