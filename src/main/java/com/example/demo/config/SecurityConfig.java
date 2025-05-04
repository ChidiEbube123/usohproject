package com.example.demo.config;

import com.example.demo.service.UserService;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

     @Bean
     public PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
     }

     // In-memory UserDetailsService for demo
     @Bean
     public UserDetailsService userDetailsService(UserService userService) {
     return username -> {
     var user = userService.findByEmail(username);
     if (user == null) throw new UsernameNotFoundException("User not found");

     return User.withUsername(user.getEmail())
     .password(user.getPassword())
     .build();
     };
     }

     @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     http
     .authorizeHttpRequests(auth -> auth
     .requestMatchers("/register", "/login", "/h2-console/**").permitAll()
     .anyRequest().authenticated()
     )
     .formLogin(login -> login
     .loginPage("/login")
     .defaultSuccessUrl("/", true)
     .permitAll()
     )
     .logout(logout -> logout
     .logoutSuccessUrl("/login?logout")
     .permitAll()
     )
     .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
     .headers(headers -> headers
     .frameOptions(frameOptions -> frameOptions.disable())
     );

     return http.build();
     }
}
