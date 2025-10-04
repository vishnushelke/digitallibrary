package org.geeksforgeeks.digitallibrary.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class UserSecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //CSRF - Cross-Site Request Forgery
        http.csrf(AbstractHttpConfigurer::disable)
                // Configure authenticated routes
                .authorizeHttpRequests(auth -> auth
                        //white-listing of APIs if there are any
                        .requestMatchers("/ping").permitAll()
                        .anyRequest().authenticated())
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .logout(LogoutConfigurer::permitAll);
        return http.build();
    }

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService user(PasswordEncoder encoder) {
        UserDetails friendUser = User.withUsername("friend").password(encoder.encode("12345")).roles("FRIEND").build();
        UserDetails familyUser = User.withUsername("family").password(encoder.encode("12345")).roles("FAMILY").build();

        return new InMemoryUserDetailsManager(friendUser, familyUser);
    }
}
