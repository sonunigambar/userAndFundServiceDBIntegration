package com.codingcure.userService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebclientConfig {
	
	@Bean
	public WebClient getWebClient(WebClient.Builder builder) {
		return builder.build();
	}

}
