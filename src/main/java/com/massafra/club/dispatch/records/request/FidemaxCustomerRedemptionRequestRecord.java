package com.massafra.club.dispatch.records.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public record FidemaxCustomerRedemptionRequestRecord(@JsonProperty("nome") String name,
                                                     @JsonProperty("cpf") String cpf,
                                                     @JsonProperty("saldo") BigInteger pointsAmount,
                                                     @JsonProperty("premio") String reward,
                                                     @JsonProperty("voucher") String voucher,
                                                     @JsonProperty("quantidade_premios") BigInteger rewardsAmount,
                                                     @JsonProperty("reais_cashback") String cashAmount) {
}
