package com.willpiears.assignment1spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Only allow the bootstrap css for login page
        http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/webjars/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
            .logout()
            .permitAll();
    }

    //Adds two temporary users to memory
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        //Default user
        UserDetails user =
            User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();

        
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user);

        //Will testing user
        UserDetails user2 =
            User.withDefaultPasswordEncoder()
            .username("will")
            .password("password")
            .roles("USER")
            .build();

        inMemoryUserDetailsManager.createUser(user2);

        return inMemoryUserDetailsManager;
    }
}
