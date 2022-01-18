package com.gmail.grechich.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                    .csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/")
                    .hasAnyRole("USER", "ADMIN")
                    .antMatchers("/addCasting","/register","/saveCasting","/users", "/allUsers","/newuser", "/deleteUser")
                    .hasAnyRole("ADMIN")
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/login")
                .and()
                    .formLogin()
                    .loginPage("/loginP")
                    .loginProcessingUrl("/j_spring_security_check")
                    .failureUrl("/error")
                    .usernameParameter("j_login")
                    .passwordParameter("j_password")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout");
    }
}
