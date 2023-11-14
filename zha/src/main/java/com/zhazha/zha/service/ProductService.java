package com.zhazha.zha.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhazha.zha.model.Product;
import com.zhazha.zha.repository.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    public Mono<Product> findByProductID(int id) {
        return productRepository.findByProductId(id);
    }

    public Flux<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public Flux<Product> findByDescription(String des) {
        return productRepository.findByDescription(des);
    }

    public Flux<Product> findByPrice(float price) {
        return productRepository.findByPrice(price);
    }

    public Mono<Product> save(Product product) {
        return productRepository.save(product);
    }

    public Mono<Product> update(int id, Product product) {
        return productRepository.findByProductId(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalProduct -> {
                    if (optionalProduct.isPresent()) {
                        product.setProductId(id);
                        return productRepository.save(product);
                    }
                    return Mono.empty();
                });
    }

    public Mono<Void> deleteByNumber(int id) {
        return productRepository.deleteByProductId(id);
    }
}
