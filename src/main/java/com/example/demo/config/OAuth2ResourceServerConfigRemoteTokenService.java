package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
@Order(1)
public class OAuth2ResourceServerConfigRemoteTokenService extends ResourceServerConfigurerAdapter{
	@Bean
	@Primary
	public RemoteTokenServices tokenServices() {
		final RemoteTokenServices tokenService = new RemoteTokenServices();
		tokenService.setCheckTokenEndpointUrl("https://test.examsdaily.in:8443/edaily-auth/oauth/check_token");
		tokenService.setClientId("fooClientIdPassword");
        tokenService.setClientSecret("password");
		return tokenService;
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.anonymous().and().authorizeRequests()
		.antMatchers("/home*").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().permitAll()
		.and().csrf().disable();
	}
}
