package com.dw.library.controller;

import com.dw.library.dto.LoanDto;
import com.dw.library.service.LoanService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    @Autowired
    LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanDto> saveLoan(@RequestBody LoanDto loanDto){
        return null;
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<LoanDto> getAllMembers(){
        return null;
    }

    @PutMapping("/loans/{loanId}/return")
    public ResponseEntity<LoanDto> returnLoan(){
        return null;
    }

    @GetMapping("/overdue")
}
