package com.nttdata.consultmanagement.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.nttdata.consultmanagement.Model.Product;
import com.nttdata.consultmanagement.Model.Transaction;
import com.nttdata.consultmanagement.Repository.customerRepository;
import com.nttdata.consultmanagement.Repository.productRepository;
import com.nttdata.consultmanagement.Repository.transactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class consultService {
    @Autowired
    private productRepository productRepository;
    @Autowired
    private customerRepository customerRepository;
    @Autowired
    private transactionRepository transactionRepository; 

    public Mono<Product> productsByCustomer(String id){      
      return customerRepository.findById(id)
      .flatMap(p->productRepository.findByCustomerId(id));
    }
   
    public Flux<Transaction> reportByProductandDateRange(String id, Date dateA, Date dateB){ 
      //Obtener transacciones en la fecha     
		  Flux<Transaction> transactions = transactionRepository.findByRegisterDateBetween(dateA, dateB);	
      Flux<Transaction> reports = transactions.filter(trans -> trans.getIdProduct().equals(id));
      return reports;
    }

    public Flux<Transaction> reportLastTentransactions(String id){ 
      //Obtener transacciones en la fecha
      List<Transaction> trans = transactionRepository.findByIdProduct(id).stream().limit(10).collect(Collectors.toList());
      return Flux.fromIterable(trans);
    }
    
}
