package com.example.security.jwt;

import com.example.security.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService,
                                   UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String path = request.getRequestURI();

<<<<<<< HEAD
        // ✅ Skip JWT only for truly PUBLIC endpoints
        if (path.equals("/api/v1/auth/login")
                || path.equals("/api/v1/auth/forgot-password")
                || path.equals("/api/v1/auth/reset-password")) {

=======
        // 🔓 SKIP JWT FILTER FOR PUBLIC AUTH ENDPOINTS
        if (path.startsWith("/api/v1/auth/") && !path.equals("/api/v1/auth/me")) {
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader("Authorization");
        String jwt = null;
        String username = null;

<<<<<<< HEAD
        // ✅ Extract JWT
=======
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            jwt = authHeader.substring(7);
            username = jwtService.extractUsername(jwt);
        }

<<<<<<< HEAD
        // ✅ Authenticate user using JWT
=======
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
        if (username != null &&
                SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails =
                    userDetailsService.loadUserByUsername(username);

            if (jwtService.isTokenValid(jwt, userDetails)) {

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                authToken.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                SecurityContextHolder.getContext()
                        .setAuthentication(authToken);
<<<<<<< HEAD

                // 🔒 Enforce first-login password change rule
                if (userDetails instanceof User user) {

                    if (user.isMustChangePassword()
                            && !path.equals("/api/v1/auth/me/password")) {

                        response.sendError(
                                HttpServletResponse.SC_FORBIDDEN,
                                "Password change required"
                        );
                        return;
                    }
                }
=======
>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
            }
        }

        filterChain.doFilter(request, response);
    }
<<<<<<< HEAD
=======


>>>>>>> 985c4a38cd5976c42713aa6a5f975a1278287d1b
}
