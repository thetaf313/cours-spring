package cours.udb.j2e.coursspring.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    public static final String ADMIN = "admin";
    public static final String USER = "user";
    public static final String SUPER = "super";


//    private final JwtAuthConverter jwtAuthConverter;
    private final JwtAuthConverter2 jwtAuthConverter2;

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        http.csrf().disable();
//
//        http.authorizeHttpRequests()
//                .requestMatchers("/login").permitAll()
//                .requestMatchers("/classe/**").hasAnyAuthority(ADMIN, USER)
//                .requestMatchers("/newclasse/**").hasAuthority(ADMIN)
//                .requestMatchers("/super/**").hasAuthority(SUPER)
//                .anyRequest().authenticated();
//
//
//        http.oauth2ResourceServer()
//                .jwt()
//                .jwtAuthenticationConverter(jwtAuthConverter);
//
//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain resourceServerFilterChain(HttpSecurity http) throws Exception {

//        http.cors(AbstractHttpConfigurer::disable);
        http.csrf(AbstractHttpConfigurer::disable);

        http.authorizeHttpRequests(auth -> auth
                .requestMatchers(new AntPathRequestMatcher("/login"))
                .permitAll()

                .requestMatchers(new AntPathRequestMatcher("/classe/**"))
                .hasAnyRole(ADMIN, USER)


                .requestMatchers(new AntPathRequestMatcher("/newclasse/**"))
                .hasRole(ADMIN)

                .requestMatchers(new AntPathRequestMatcher("/super/**"))
                .hasRole(SUPER)

                .anyRequest()
                .authenticated());

        http.sessionManagement(smc -> smc.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.oauth2ResourceServer((oauth2) -> oauth2
                .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter2)
                        .jwkSetUri("http://localhost:8080/realms/cours-spring-realm/protocol/openid-connect/certs")));

//        http.oauth2Login(Customizer.withDefaults());

        return http.build();
    }


}