package com.sde.spbsecurityinmemory.Configurations;

import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class InMemoryConfig {


    @Bean
    UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("Alex").password(passwordEncoder().encode("1234@@")).roles("president").build());
        manager.createUser(User.withUsername("Fred").password(passwordEncoder().encode("5678@@")).roles("manager").build());
        manager.createUser(User.withUsername("Leo").password(passwordEncoder().encode("@1234@")).roles("employee").build());
        manager.createUser(User.withUsername("William").password(passwordEncoder().encode("#1234#")).roles("worker").build());
                return manager;
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    // @Bean
    // SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)throws Exception{
    //     httpSecurity.authorizeHttpRequests((authorizeHttpRequests)->authorizeHttpRequests.requestMatchers("/testApi1/testPresident").hasRole("presdient")
    //     .requestMatchers("/testApi1/testPresident").hasRole("presdient")
    //     .requestMatchers("/testApi1/testPresident").hasRole("presdient")
    //     .requestMatchers("/testApi1/testPresident").hasRole("presdient")
    //     .requestMatchers("/testApi1/testPresident").hasRole("presdient").anyRequest().authenticated()).formLogin(withDefaults)
    //     .logout();
        
    //     return httpSecurity.build();
    // }


    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
			.requestMatchers("/testApi1/testPresident").hasRole("presdient")
        .requestMatchers("/testApi1/testManager").hasRole("manager")
        .requestMatchers("/testApi1/testEmployee").hasRole("employee")
        .requestMatchers("/testApi1/testWorker").hasRole("worker")
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				.loginPage("/testApi1/testSecurity")
				.permitAll()
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}
}
