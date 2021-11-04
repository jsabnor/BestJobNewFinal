package com.equipo2.BestJobNew.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * Clase encargada de la configuracion de la seguridad de la aplicacion
 * Equipo Back: Clemen & Josema
 * Equipo Front: Heyanabanana & Javier_scr
 * @author Clemen & Josema
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * Metodo sobreescrito del WebSecurityConfigurerAdapter
     */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().authorizeRequests()
                //Solo se premitiran acceso a los usuarios que tengan los roles de ADMIN y USER a las siguientes endpoints
                .antMatchers("/swagger-ui").hasRole("USER")
                .antMatchers("/api/v1/ofertas").hasRole("ADMIN")
                .antMatchers("/api/v1/tecnologias").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic();
    }


    /**
     * Metodo que configura los usuarios en memoria para acceder a las zonas habilitadas para ello
     * @param auth AutenticationMAnagerBuilder
     * @throws Exception si los datos de autenticacion no son los correctos
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication()
               .passwordEncoder(new BCryptPasswordEncoder())
               .withUser("admin").password(passwordEncoder().encode("password")).roles("USER", "ADMIN")
               .and()
               .withUser("user").password(passwordEncoder().encode("password")).roles("USER");
    }

    /**
     * Metodo que codifica
     * @return codificado
     */
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // Expose the UserDetailsService as a Bean
    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Bean
    protected CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

}
