package mx.edu.utez.unidad3.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
public class MainSecurity {
    @Bean
    public SecurityFilterChain doFilterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable()).cors(c -> c.configurationSource(corsRegistry()))
                .authorizeHttpRequests((auth -> auth
                .requestMatchers("/**").permitAll()
                .anyRequest().authenticated())
        );
        return http.build();
    }

    private CorsConfigurationSource corsRegistry(){
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true);

        //en donde lo queremos aplicar
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;

    }
}
