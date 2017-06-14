package com.aidijing.config;

import com.aidijing.security.JwtAuthenticationEntryPoint;
import com.aidijing.security.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author : 披荆斩棘
 * @date : 2017/6/8
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity( prePostEnabled = true )
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private UserDetailsService          userDetailsService;

    @Autowired
    public void configureAuthentication ( AuthenticationManagerBuilder authenticationManagerBuilder ) throws Exception {
        authenticationManagerBuilder
                .userDetailsService( this.userDetailsService )
                .passwordEncoder( passwordEncoder() );
    }


    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean () throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

    @Override
    protected void configure ( HttpSecurity httpSecurity ) throws Exception {
        httpSecurity
                // we don't need CSRF because our token is invulnerable
                .csrf().disable()

                .exceptionHandling().authenticationEntryPoint( authenticationEntryPoint ).and()

                // don't create session
                // 不创建会话
                .sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS ).and()

                .authorizeRequests()
                //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                // allow anonymous resource requests
                // 允许匿名资源请求
                .antMatchers(
                        HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                ).permitAll()
                .antMatchers( "/auth/**" ).permitAll()
                .anyRequest().authenticated();

        // Custom JWT based security filter
        // 基于定制JWT安全过滤器
        httpSecurity.addFilterBefore( authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class );

        // disable page caching
        // 禁用页面缓存
        httpSecurity.headers().cacheControl();
    }
}
