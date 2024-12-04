package com.massafra.club.dispatch.records.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public record FidemaxCustomerRedemptionRequestRecord(@JsonProperty("nome") String name,
                                                     @JsonProperty("email") String email,
                                                     @JsonProperty("sexo") String gender,
                                                     @JsonProperty("nascimento") String birthday,
                                                     @JsonProperty("telefone") String phone,
                                                     @JsonProperty("cpf") String customerId,
                                                     @JsonProperty("saldo") BigInteger pointsAmount,
                                                     @JsonProperty("premio") String rewardDescription,
                                                     @JsonProperty("voucher") String voucher,
                                                     @JsonProperty("quantidade_premios") BigInteger amountRewards,
                                                     @JsonProperty("reais_cashback") String cashback) {
}
