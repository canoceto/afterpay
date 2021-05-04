package com.clearpay.demo.security;

import com.clearpay.demo.models.User;
import com.clearpay.demo.service.UserService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    UserService userService;

    public SecurityFilter(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!request.getMethod().equals(HttpMethod.OPTIONS.toString())) {
            if (handleAuthorizationHeader(request, response)) {
                onAuthorizedRequest(request, response, filterChain);
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }

    private boolean handleAuthorizationHeader(HttpServletRequest request, HttpServletResponse response) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer")) {
            String tokenId = removeBearer(header).trim();
            try {
                User user = userService.getByTokenId(tokenId);
                request.setAttribute("user", user);
                return true;
            } catch (FirebaseAuthException e) {
                try {
                    response.sendError(HttpStatus.UNAUTHORIZED.value(), "Bad authorization token");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            } catch (Exception e) {
                try {
                    response.sendError(HttpStatus.UNAUTHORIZED.value(), "Could't verify authorization token");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        }
        return false;
    }

    private String removeBearer(String header) {
        return header.substring(7);
    }

    private void onAuthorizedRequest(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        try {
            chain.doFilter(request, response);
        } catch (ServletException err) {
            if (err.getCause() instanceof UnauthorizedUserRoleException) {
                try {
                    response.sendError(HttpStatus.UNAUTHORIZED.value(), err.getCause().getMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
