package com.ust.appointment.config;

//import com.wecp.library.security.WebSecurityConfigurer;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity //@EnableGlobalMethodSecurity (Authorization)
@EnableGlobalMethodSecurity(PrePostEnabled = true)
public class temp extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("-----").permitAll().anyRequest().and().httpBasic();
    }

}
