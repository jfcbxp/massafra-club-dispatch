package com.massafra.club.dispatch.clients;

import com.massafra.club.dispatch.dto.request.CreateClientRequestDTO;
import com.massafra.club.dispatch.dto.response.FidemaxResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        value = "fidemax-client",
        url = "${fidemax.url}",
        path = "/Integracao"
)
public interface FidemaxClient {

    @PostMapping(value = "/CadastrarConsumidor")
    FidemaxResponseDTO createClient(CreateClientRequestDTO body);

}
