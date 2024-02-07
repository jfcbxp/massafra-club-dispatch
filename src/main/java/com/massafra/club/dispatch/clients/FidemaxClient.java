package com.massafra.club.dispatch.clients;

import com.massafra.club.dispatch.configs.FidemaxFeignConfig;
import com.massafra.club.dispatch.records.request.FidemaxCustomerRequestRecord;
import com.massafra.club.dispatch.records.request.FidemaxLoyaltyRequestRecord;
import com.massafra.club.dispatch.records.response.FidemaxCustomerResponseRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "fidemax-client",
        value = "fidemax-client",
        url = "${fidemax.url}",
        path = "/Integracao",
        configuration = FidemaxFeignConfig.class
)
public interface FidemaxClient {

    @PostMapping(
            value = "/CadastrarConsumidor",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    FidemaxCustomerResponseRecord sendCustomer(
            @RequestBody
            FidemaxCustomerRequestRecord body);

    @PostMapping(
            value = "/PontuaConsumidor",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    FidemaxCustomerResponseRecord sendLoyalty(
            @RequestBody
            FidemaxLoyaltyRequestRecord body);

}
