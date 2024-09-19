@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{
    
    // @Override
    // protected void configurer(HttpSecurity http) throws Exception{
    //     http.csrf().disable().authorizeRequests().antMatchers("/api/v1").permitAll().anyRequests().authenticated().and().httpBasic();
    // }
    @Override
    protected void configurer(HttpSecurity http) throws Exception{
        http.csrf().disable()
            .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/").authenticated()
                .antMatchers("/").hasRole("ADMIN")
                .anyRequest().authenticated()
                .anyRequest().permitAll()
            .and().httpBasic();
    }

}
