package com.massafra.club.dispatch.records.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record FidemaxCustomerResponseRecord(@JsonProperty("cartao_duplicado") boolean isDuplicated,
                                            @JsonProperty("CodigoResposta") int statusCode,
                                            @JsonProperty("MensagemErro") String message) {
}
