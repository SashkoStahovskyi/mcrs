package com.stakhovskyi.productservice.massageservice;

import com.stakhovskyi.productservice.ivent.ProductEvent;

public interface MassageService {

    void createProductMassage(ProductEvent productEvent);

    void updateProductMassage(ProductEvent updateProductEvent);

    void deleteProductMassage(ProductEvent deleteProductEvent);

}
