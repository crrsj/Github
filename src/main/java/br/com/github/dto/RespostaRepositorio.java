package br.com.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RespostaRepositorio(
		String id,
		@JsonProperty("html_url")String htmlurl,
		@JsonProperty("private")boolean isPrivate) {

}
