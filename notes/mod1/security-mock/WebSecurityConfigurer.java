package com.wecp.library.security;

@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests().antMatchers("/api/v1/issue-book").permitAll().anyRequest().authenticated().and().httpBasic();
    }

    // protected void configure(HttpSecurity http) throws Exception {
    //     http
    //         .authorizeRequests()
    //             .antMatchers("/api/v1/students").authenticated()
    //             .antMatchers("/api/v1/courses").hasRole("ADMIN")
    //             .antMatchers("/api/v1/enrollments").authenticated()
    //             .antMatchers("/api/v1/students/{id}").authenticated()
    //             .antMatchers("/api/v1/courses/{id}").authenticated()
    //             .anyRequest().permitAll()
    //         .and()
    //         .httpBasic()
    //         .and()
    //         .csrf().disable();
    // }

    /*@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }*/

}