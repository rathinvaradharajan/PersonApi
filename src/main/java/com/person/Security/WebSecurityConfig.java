package com.person.Security;

import com.person.Mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static Logger logger = Logger.getLogger(PersonMapper.class.getName());

    @Autowired
    private  MyBasicAuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) {
        try {
            authenticationManagerBuilder.inMemoryAuthentication().withUser("Admin")
                    .password("12345").authorities("ROLE_USER").roles("ACTUATOR");
        } catch (Exception e) {
            logger.info("In configureGlobal() -> Exception -> "+e.getMessage());
        }
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) {
        try {
            httpSecurity
                    .cors()
                    .and()
             .authorizeRequests()
                    .antMatchers("/demo/ping").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic()
                    .authenticationEntryPoint(authenticationEntryPoint);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
