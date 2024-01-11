package com.massafra.club.dispatch.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FidemaxResponseDTO {

    @JsonProperty("cartao_duplicado")
    private boolean isDuplicated;

    @JsonProperty("CodigoResposta")
    private int statusCode;

    @JsonProperty("MensagemErro")
    private String message;
}
