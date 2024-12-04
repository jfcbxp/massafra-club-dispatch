package com.massafra.club.dispatch.records.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record FidemaxCustomerRedemptionRequestRecord(@JsonProperty("nome") String name,
                                                     @JsonProperty("email") String email,
                                                     @JsonProperty("sexo") String gender,
                                                     @JsonProperty("nascimento") String birthday,
                                                     @JsonProperty("telefone") String phone,
                                                     @JsonProperty("cpf") String customerId,
                                                     @JsonProperty("saldo") BigDecimal pointsAmount,
                                                     @JsonProperty("premio") String rewardDescription,
                                                     @JsonProperty("voucher") String voucher,
                                                     @JsonProperty("quantidade_premios") BigDecimal amountRewards,
                                                     @JsonProperty("reais_cashback") BigDecimal cashback) {
}
