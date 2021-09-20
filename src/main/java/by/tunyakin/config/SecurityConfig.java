package by.tunyakin.config;

import by.tunyakin.model.enums.Role;
import by.tunyakin.service.AuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity(debug = true)
@PropertySource("classpath:application.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthProvider authProvider;

    @Bean
    PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
        return passwordEncoder;
    }

    private static String CLIENT_PROPERTY_KEY = "spring.security.oauth2.client.registration.";
    private static List<CommonOAuth2Provider> clients = Arrays.asList(
            CommonOAuth2Provider.GOOGLE
    );

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository(Environment env) {
        List<ClientRegistration> registrations = clients.stream()
                .map(c -> getRegistration(c, env))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return new InMemoryClientRegistrationRepository(registrations);
    }

    private ClientRegistration getRegistration(CommonOAuth2Provider client, Environment env) {

        String clientName = client.name().toLowerCase();

        String clientId = env.getProperty(CLIENT_PROPERTY_KEY + clientName + ".client-id");

        if (clientId == null) {
            return null;
        }

        String clientSecret = env.getProperty(CLIENT_PROPERTY_KEY + clientName + ".client-secret");

        if (clientSecret == null) {
            return null;
        }

        return client.getBuilder(clientSecret)
                .clientId(clientId).clientSecret(clientSecret).build();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic()
                .and().formLogin()
                .loginPage("/signIn")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .failureUrl("/signIn")
                .and().oauth2Login()
                .loginPage("/signIn/google")
                .failureUrl("/")
                .and().logout()
                .logoutSuccessUrl("/")
                .and().exceptionHandling()
                .and().authorizeRequests()
                .antMatchers("/signUp/**").permitAll()
                .antMatchers("/signIn/**").permitAll()
                .antMatchers("/profile/**").hasAnyRole("ADMIN", "DOCTOR", "PATIENT", "USER")
                .antMatchers("/medicalCard/**").hasAnyRole("PATIENT", "DOCTOR")
                .antMatchers("/doctorUserList/**").hasAnyRole("DOCTOR")
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider);
    }
}