package desafio.itau.springboot.controller;

import desafio.itau.springboot.model.Transaction;
import desafio.itau.springboot.dto.TransactionRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import desafio.itau.springboot.service.TransactionService;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest request){
        if (request.getDateHour().isAfter(OffsetDateTime.now())) {
            return ResponseEntity.unprocessableContent().build();
        }
        transactionService.addTransaction(new Transaction(request.getValue(), request.getDateHour()));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransactions(){
        transactionService.clearTransactions();
        return ResponseEntity.ok().build();
    }
}
