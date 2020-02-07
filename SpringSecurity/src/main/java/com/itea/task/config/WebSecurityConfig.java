package com.itea.task.config;

import com.itea.task.filter.LessonFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user")
                .password(new BCryptPasswordEncoder().encode("user")).roles("ROLE_LESSON_USER");
        auth.inMemoryAuthentication().withUser("admin")
                .password(new BCryptPasswordEncoder().encode("admin")).roles("ROLE_LESSON_ADMIN");
        auth.inMemoryAuthentication().withUser("anonym")
                .password(new BCryptPasswordEncoder().encode("anonym")).roles("ROLE_ANONYM");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.addFilterBefore(new LessonFilter(), BasicAuthenticationFilter.class);
        http.authorizeRequests().antMatchers("/opened/**").permitAll()
                .antMatchers("/closed/**").access("hasAnyRole('ROLE_LESSON_USER', 'ROLE_LESSON_ADMIN')")
                .antMatchers("/protected/**").access("hasRole('ROLE_LESSON_ADMIN')")
                .and().formLogin().defaultSuccessUrl("/", false);
    }
}
