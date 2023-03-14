package com.example.demo.security.configure;

import com.example.demo.security.jwt.JwtAuthenticationFilter;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class  SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/**");
        http.authorizeRequests().antMatchers("/", "/login","/api/movies/showing","/api/movies/showing/search","/register","/movie","/user").permitAll();
        http.antMatcher("/movie/**").httpBasic().authenticationEntryPoint(restServicesEntryPoint()).and()
             .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
             .antMatchers(HttpMethod.GET,"/movie/**").access("hasRole('ROLE_ADMIN')").and()
             .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                     .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
        // http.httpBasic().authenticationEntryPoint(restServicesEntryPoint());
        // http.authorizeRequests()
        //         .antMatchers("/", "/login","/api/movies/showing","/api/movies/showing/search","/register","/user").permitAll()
        //         .anyRequest().authenticated()
        //         .and().csrf().disable();
        // http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        //         .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
        // http.sessionManagement()
        //         .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors();
    }
}
