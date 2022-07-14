package com.example.land.controller;

import com.example.land.dto.TransactionDTO;
import com.example.land.entity.Transaction;
import com.example.land.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/transaction")
public class TransactionController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    TransactionService transactionService;

    @GetMapping("")
    public List<TransactionDTO> getAll(){
        return transactionService.getAll().stream().map(transaction ->modelMapper.map(transaction,TransactionDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> getTransaction(@PathVariable("id") Long id){
        Transaction transaction = transactionService.getTransaction(id);
        TransactionDTO transactionDTO = modelMapper.map(transaction, TransactionDTO.class);
        return ResponseEntity.ok().body(transactionDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transactionDTO){
        Transaction transactionRequest = modelMapper.map(transactionDTO, Transaction.class);
        Transaction transaction = transactionService.createTransaction(transactionRequest);
        TransactionDTO transactionResponse =modelMapper.map(transaction, TransactionDTO.class);
        return new ResponseEntity<TransactionDTO>(transactionResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TransactionDTO> updateTransaction(@RequestBody TransactionDTO transactionDTO,@PathVariable("id") Long id){
        Transaction transactionRequest = modelMapper.map(transactionDTO, Transaction.class);
        Transaction transaction = transactionService.updateTransaction(transactionRequest,id);
        TransactionDTO transactionResponse =modelMapper.map(transaction, TransactionDTO.class);
        return ResponseEntity.ok().body(transactionResponse);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteTransaction(@PathVariable("id") Long id){
        return transactionService.deleteTransaction(id);
    }
}
