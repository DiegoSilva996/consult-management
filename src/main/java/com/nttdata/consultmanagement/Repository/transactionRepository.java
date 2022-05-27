package com.nttdata.consultmanagement.Repository;

import java.util.Date;
//import java.util.List;
import java.util.List;

import com.nttdata.consultmanagement.Model.Transaction;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

public interface transactionRepository extends ReactiveMongoRepository <Transaction, String>{
    Flux <Transaction> findByRegisterDateBetween( Date startDate, Date endDate);   
    List<Transaction> findByIdProduct(String idProduct); 
}
