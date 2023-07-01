package com.stakhovskyi.inventoryservice;

import com.stakhovskyi.inventoryservice.server.GRPCServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@Slf4j
@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) throws IOException, InterruptedException {

        ConfigurableApplicationContext context = SpringApplication.run(InventoryServiceApplication.class, args);

        GRPCServer grpcServer = context.getBean("GRPCServer", GRPCServer.class);

        grpcServer.start();
        grpcServer.server.awaitTermination();

    }
}
