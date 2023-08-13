/*
package com.stakhovskyi.inventoryservice.server;

import com.stakhovskyi.grpc.Inventory;
import com.stakhovskyi.grpc.InventoryServiceGrpc;
import com.stakhovskyi.inventoryservice.service.InventoryService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Component
public class GRPCServer {
    public Server server;
    @Value("${grpc.server.port}")
    private int port;
    private final InventoryService inventoryService;


    public void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new GRPCInventoryServiceImpl())
                .build().start();

        log.info(" gRPC Server Start on port {} !", port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down gRPC server");
            try {
                server.shutdown().awaitTermination(30,
                        TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
        }));
    }

    @Component
    public class GRPCInventoryServiceImpl extends InventoryServiceGrpc.InventoryServiceImplBase {

        @Override
        public void isInStock(Inventory.InventoryRequest request,
                              StreamObserver<Inventory.InventoryResponse> responseObserver) {

            boolean inStock = inventoryService.isInStock(request.getSkuCode());
            Inventory.InventoryResponse response = Inventory.InventoryResponse.newBuilder()
                    .setInStock(inStock)
                    .build();

            responseObserver.onNext(response);
            log.info(" Response from inventory service!");
            responseObserver.onCompleted();
        }
    }
}


*/
