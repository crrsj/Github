package br.com.github.controle;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.github.cliente.GitHubCliente;
import br.com.github.dto.RespostaRepositorio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/v1")
public class GitHubControle {
	
	@Autowired
	private  GitHubCliente gitHubCliente;	
	
    @GetMapping("/repos")
    @Operation(summary = "Endpoint responsável por listar repositórios públicos.") 
    @ApiResponse(responseCode = "200",description = " sucesso",content = {
   	@Content(mediaType = "application.json",schema = @Schema(implementation = ResponseEntity.class))
    })   
	public ResponseEntity<List<RespostaRepositorio>>listarRepositorios(@RequestHeader("token") String token){    
    var repositorios = gitHubCliente.listarRepositorios("Bearer " + token, null, "public");
	return new ResponseEntity<>(repositorios,HttpStatus.OK);
	
    }
	
}
