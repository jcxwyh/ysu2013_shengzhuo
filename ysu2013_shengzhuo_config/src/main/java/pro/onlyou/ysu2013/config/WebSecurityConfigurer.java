package pro.onlyou.ysu2013.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@EnableWebSecurity
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService userDetailsService(){
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        InMemoryUserDetailsManager manager =
                new InMemoryUserDetailsManager();
        manager.createUser(userBuilder.username("jcx").password("jcx").build());
        manager.createUser(userBuilder.username("wyh").password("wyh").build());

        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
             .formLogin()
                .loginPage("login")
                .usernameParameter("username")
                .passwordParameter("password")
                .failureForwardUrl("login")
                .successForwardUrl("share");
    }
}
