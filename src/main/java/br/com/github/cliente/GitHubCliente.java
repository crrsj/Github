package br.com.github.cliente;

import java.util.List;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import br.com.github.dto.RespostaRepositorio;


public interface GitHubCliente {

	@GetExchange("/user/repos")
    public List<RespostaRepositorio>listarRepositorios(
    	@RequestHeader("Authorization")	String token,
    	@RequestHeader(value = "X-GitHub-Api-Version",defaultValue = "2022-11-28")
    	String apiVersion,
    	@RequestParam("visibility") String visibility
    		
  	);
		
	
	
	
}
