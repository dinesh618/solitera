/*

package com.solitera.assignment.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("defaultuser")
                .password("defaultpassword")
                .roles("ADMIN")
                .build();
                return new InMemoryUserDetailsManager(userDetails);

    }
    @Bean
   public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
   {
   return    http.authorizeHttpRequests((authz)->authz.requestMatchers("/admin/**").authenticated()).httpBasic(withDefaults()).build();

   }

}
*/
