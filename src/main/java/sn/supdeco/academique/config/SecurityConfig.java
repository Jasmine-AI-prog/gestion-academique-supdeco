package sn.supdeco.academique.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
            .requestMatchers("/", "/connexion", "/css/**", "/js/**", "/h2-console/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/api/**").hasAnyRole("ADMIN", "ENSEIGNANT")
            .anyRequest().authenticated())
            .formLogin(form -> form.loginPage("/connexion").defaultSuccessUrl("/tableau-de-bord", true).permitAll())
            .logout(logout -> logout.logoutUrl("/deconnexion").logoutSuccessUrl("/connexion?logout").permitAll())
            .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**", "/api/**"))
            .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));
        return http.build();
    }
    @Bean PasswordEncoder passwordEncoder(){ return new BCryptPasswordEncoder(); }
    @Bean UserDetailsService users(PasswordEncoder encoder){
        return new InMemoryUserDetailsManager(
            User.withUsername("admin").password(encoder.encode("admin123")).roles("ADMIN").build(),
            User.withUsername("enseignant").password(encoder.encode("enseignant123")).roles("ENSEIGNANT").build());
    }
}
