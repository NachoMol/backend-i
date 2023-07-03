package com.example.clase23.security;


import com.example.clase23.service.AppUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private AppUsuarioService appUsuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/index.html").hasAnyRole("ADMIN","USER")
                .antMatchers("/odontologos/**","/get_all_odontologos.html").hasRole("ADMIN")
                .antMatchers("/odontologos/**","/post_odontologos.html").hasRole("ADMIN")
                .antMatchers("/odontologos/**","/delete_odontologos.html").hasRole("ADMIN")
                .antMatchers("/odontologos/**","/put_odontologos.html").hasRole("ADMIN")
                .antMatchers("/pacientes/**","/post_pacientes.html").hasRole("ADMIN")
                .antMatchers("/pacientes/**","/get_all_pacientes.html").hasRole("ADMIN")
                .antMatchers("/pacientes/**","/put_pacientes.html").hasRole("ADMIN")
                .antMatchers("/pacientes/**","/delete_pacientes.html").hasRole("ADMIN")
                .antMatchers("/turnos/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/swagger-ui.html","/swagger-ui/**","/v3/api-docs/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .logout();
                /*.csrf().disable()
                .authorizeRequests()
                .anyRequest().permitAll();*/

    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(appUsuarioService);
        return provider;
    }

}
