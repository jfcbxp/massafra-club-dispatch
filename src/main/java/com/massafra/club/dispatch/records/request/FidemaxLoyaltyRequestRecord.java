package com.massafra.club.dispatch.records.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public record FidemaxLoyaltyRequestRecord(@JsonProperty("cpf") String cgc,
                                          @JsonProperty("telefone") String phone,
                                          @JsonProperty("pontuacao_reais") BigInteger points,
                                          @JsonProperty("tipo_compra") String orderType,
                                          @JsonProperty("verificador") String id,
                                          @JsonProperty("estorno") boolean rollback) {
}
