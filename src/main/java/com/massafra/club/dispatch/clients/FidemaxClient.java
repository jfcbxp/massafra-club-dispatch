package com.massafra.club.dispatch.clients;

import com.massafra.club.dispatch.configs.FeignConfig;
import com.massafra.club.dispatch.records.request.FidemaxCustomerRequestRecord;
import com.massafra.club.dispatch.records.response.FidemaxCustomerResponseRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        value = "fidemax-client",
        url = "${fidemax.url}",
        path = "/Integracao",
        configuration = FeignConfig.class
)
public interface FidemaxClient {

    @PostMapping(
            value = "/CadastrarConsumidor",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<FidemaxCustomerResponseRecord> createClient(
            @RequestBody
            FidemaxCustomerRequestRecord body);

}
