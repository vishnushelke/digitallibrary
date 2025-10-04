package org.geeksforgeeks.digitallibrary.configuration;

import org.geeksforgeeks.digitallibrary.service.core.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// Commented code imports
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class UserSecurityConfiguration {

    private final IUserService userService;

    public UserSecurityConfiguration(IUserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //CSRF - Cross-Site Request Forgery
        http.csrf(AbstractHttpConfigurer::disable)
                // Configure authenticated routes
                .authorizeHttpRequests(auth ->
                        //white-listing of APIs if there are any
                        auth.requestMatchers("/ping").permitAll()
                        .anyRequest().authenticated()
                )
//                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll) --> For earlier(commented) approach
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userService);
        provider.setPasswordEncoder(this.getEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager getAuthManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * This was added as a basic security check - moved to advanced by adding above function to authenticate using email
    @Bean
    public UserDetailsService user(PasswordEncoder encoder) {
        UserDetails friendUser = User.withUsername("friend").password(encoder.encode("12345")).roles("FRIEND").build();
        UserDetails familyUser = User.withUsername("family").password(encoder.encode("12345")).roles("FAMILY").build();

        return new InMemoryUserDetailsManager(friendUser, familyUser);
    }*/
}
