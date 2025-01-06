package br.com.github.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import br.com.github.cliente.GitHubCliente;

@Configuration
public class GitHubConfiguracao {

	@Bean
	public HttpServiceProxyFactory httpServiceProxyFactory() {
		WebClient webClient = WebClient.builder().baseUrl("https://api.github.com")
		.build();		
		return HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient)).build();
	}
	
	@Bean
	public  GitHubCliente gitHubCliente(HttpServiceProxyFactory factory) {
		return factory.createClient(GitHubCliente.class);
		
	}
}
