package com.nttdata.consultmanagement.Repository;

import com.nttdata.consultmanagement.Model.Product;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface productRepository extends ReactiveMongoRepository <Product, String> {
    Flux<Product> findByCustomerId(String customerId);
}
