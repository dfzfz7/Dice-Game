package com.dicegame.securityjwt.security;

import static com.dicegame.securityjwt.security.Constants.LOGIN_URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	 
		// Use methods from UserDetailsService
		@Autowired	
		private UserDetailsService userDetailsService;
			
		// Define UserDetailsService to get the users and the encoder for passwords
		@Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) 
	      throws Exception {
			
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	        
			// Set up default users in memory authentication // STATIC USERS
			/*auth.inMemoryAuthentication().withUser("player") 
	          .password(passwordEncoder().encode("player")).roles("PLAYER");
	        auth.inMemoryAuthentication().withUser("admin")
	          .password(passwordEncoder().encode("admin")).roles("ADMIN");*/
	    }
	    
		// Password encoder 
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    // Set up HTTP Security - Any request to the application is authenticated with HTTP basic authentication
	    protected void configure(HttpSecurity http) throws Exception {
	 
	    	http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // Disable use of Cookies
	    		.cors().and().csrf().disable() // Activate default CORS values and disable CSRF
	    		.authorizeRequests()
	    		.antMatchers(HttpMethod.POST, LOGIN_URL).permitAll()
	    		/*.antMatchers(HttpMethod.POST, "/**").hasAnyRole("ADMIN","PLAYER") // Players and ADMIN can create/post
	    		.antMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN") // Only ADMIN can update/put
	    		.antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN") // Only ADMIN can delete*/
	        	.anyRequest().authenticated().and()
	        		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
	    			.addFilter(new JWTAuthorizationFilter(authenticationManager()));
	  
		        //.and().httpBasic(); // Basic Authentication	    	
	    }
	
}
