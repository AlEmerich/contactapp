package com.calinfo.contactapp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests().antMatchers("/**").authenticated()
                .antMatchers("/h2-console/**").permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
