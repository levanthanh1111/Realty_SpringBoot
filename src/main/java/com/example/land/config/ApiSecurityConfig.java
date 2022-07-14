package com.example.land.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth){
        try{
            auth.inMemoryAuthentication()
                    .withUser("user").password("{noop}thanh").roles("USER")
                    .and()
                    .withUser("admin").password("{noop}thanh").roles("ADMIN");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
             //   .antMatchers("/api/books/**").hasRole("USER")
                .antMatchers("/api/**").hasRole("ADMIN")
                //     .antMatchers("/api/v1/products/delete/*").hasRole("ADMIN")
                //    .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}