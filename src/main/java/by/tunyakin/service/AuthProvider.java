package by.tunyakin.service;

import by.tunyakin.model.User;
import by.tunyakin.service.api.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthProvider(IUserService userService) {
        this.userService = userService;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        {
            String login = authentication.getName();
            String password = (String) authentication.getCredentials();

            User user = userService.getByLogin(login);

            if (user != null && (user.getLogin().equals(login))) {
                if (!passwordEncoder.matches(password, user.getPassword())) {
                    throw new BadCredentialsException("Wrong password");
                }

                Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

                return new UsernamePasswordAuthenticationToken(user, password, authorities);
            } else
                throw new BadCredentialsException("Username not found");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
