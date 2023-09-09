package com.example.orderservice.serviceclient;

import com.example.orderservice.dto.InventoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryServiceClient implements ServiceClient {

    private static final String URL = "http://inventory-service/api/inventory";

    public static final String SKUCODE = "skucode";

    private final WebClient.Builder webClientBuilder;


    @Override
    public InventoryResponse [] isInStock(List<String> skucodeList) {
        return webClientBuilder.build().get()
                .uri(URL, uriBuilder -> uriBuilder.queryParam(SKUCODE, skucodeList).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();
    }
}
