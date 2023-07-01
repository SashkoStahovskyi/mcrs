package com.example.orderservice.config;


import com.stakhovskyi.grpc.InventoryServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GRPCClientConfig {

   /* @Value("${grpc.target.server}")
    private String target;

    // chanel-connection
    @Bean
    public ManagedChannel getManagedChannel() {
        return  ManagedChannelBuilder.forTarget("localhost:8082")
                .usePlaintext().build();
    }

    // stub
    @Bean
    public InventoryServiceGrpc.InventoryServiceBlockingStub getStub () {
        return InventoryServiceGrpc.newBlockingStub(getManagedChannel());
    }*/

}




