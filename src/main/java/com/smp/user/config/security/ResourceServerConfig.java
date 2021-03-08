package com.smp.user.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final String ROOT_PATTERN = "/**";
	private static final String OAUTH2_SCOPE_WRITE = "#oauth2.hasScope('write')";
	private static final String OAUTH2_SCOPE_READ = "#oauth2.hasScope('read')";

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers(
						"/v2/api-docs",
						"/configuration/ui", 
						"/swagger-resources/**", 
						"/actuator/**",
						"/swagger-ui.html", 
						"/webjars/**")
				.permitAll().antMatchers(HttpMethod.GET, ROOT_PATTERN).access(OAUTH2_SCOPE_READ)
				.antMatchers(HttpMethod.POST, ROOT_PATTERN).access(OAUTH2_SCOPE_WRITE)
				.antMatchers(HttpMethod.PATCH, ROOT_PATTERN).access(OAUTH2_SCOPE_WRITE)
				.antMatchers(HttpMethod.PUT, ROOT_PATTERN).access(OAUTH2_SCOPE_WRITE)
				.antMatchers(HttpMethod.DELETE, ROOT_PATTERN).access(OAUTH2_SCOPE_WRITE).anyRequest().authenticated()
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.stateless(true);
	}

	@Bean
	public MethodSecurityExpressionHandler createExpressionHandler() {
		return new OAuth2MethodSecurityExpressionHandler();
	}
}
