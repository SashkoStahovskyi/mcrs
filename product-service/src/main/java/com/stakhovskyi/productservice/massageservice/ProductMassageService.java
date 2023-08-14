package com.stakhovskyi.productservice.massageservice;


import com.stakhovskyi.productservice.ivent.ProductEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductMassageService implements MassageService {

    private final KafkaTemplate<String, ProductEvent> template;


    @Override
    public void createProductMassage(ProductEvent productEvent) {
        template.send("create_product", productEvent)
                .whenComplete((result, exception) -> {
                    if (Objects.isNull(exception)) {
                        log.info("Send create product event = [" + productEvent.getName() +
                                "] with offset = [" + result.getRecordMetadata().offset() + "]");
                    } else {
                        log.info(" Unable to send create product event = [" + productEvent.getName() + "]"
                                + "due to: " + exception.getMessage());
                    }
                });

    }

    @Override
    public void updateProductMassage(ProductEvent updateProductEvent) {
        template.send("update_product", updateProductEvent)
                .whenComplete((result, exception) -> {
                    if (Objects.isNull(exception)) {
                        log.info("Send update product event = [" + updateProductEvent.getName() +
                                "] with offset = [" + result.getRecordMetadata().offset() + "]");
                    } else {
                        log.info(" Unable to send updated product event = [" + updateProductEvent.getName() + "]"
                                + "due to: " + exception.getMessage());
                    }
                });


    }

    @Override
    public void deleteProductMassage(ProductEvent deleteProductEvent) {
        template.send("delete_product", deleteProductEvent)
                .whenComplete((result, exception) -> {
                    if (Objects.isNull(exception)) {
                        log.info("Send delete product event = [" + deleteProductEvent.getId() +
                                "] with offset = [" + result.getRecordMetadata().offset() + "]");
                    } else {
                        log.info(" Unable to send delete product event = [" + deleteProductEvent.getId() + "]"
                                + "due to: " + exception.getMessage());
                    }
                });
    }
}
