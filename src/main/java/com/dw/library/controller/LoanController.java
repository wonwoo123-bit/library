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
//    도서대출
    public ResponseEntity<LoanDto> saveLoan(@RequestBody LoanDto loanDto){
        return null;
    }

    @GetMapping("/{memberId}")
//    멤버id로 조회
    public ResponseEntity<LoanDto> getAllMembers(){
        return null;
    }

    @PutMapping("/loans/{loanId}/return")
//    도서반납
    public ResponseEntity<LoanDto> returnLoan(){
        return null;
    }

    @GetMapping("/overdue")
//    연체도서 조회
    public ResponseEntity<LoanDto> overdue (){
        return null;
    }
}