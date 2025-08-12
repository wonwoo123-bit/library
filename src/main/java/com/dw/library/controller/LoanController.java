package com.dw.library.controller;

import com.dw.library.dto.LoanDto;
import com.dw.library.dto.LoanGetDto;
import com.dw.library.service.LoanService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    @Autowired
    LoanService loanService;

    @PostMapping
//    도서대출
    public ResponseEntity<Long> saveLoan(@RequestBody LoanDto loanDto){
        return new ResponseEntity<>(loanService.saveLoan(loanDto), HttpStatus.CREATED);
    }

    @GetMapping("/search")
//    멤버id로 조회
    public ResponseEntity<List<LoanGetDto>> getByOthers(
            @RequestParam(required = false) String memberEmail,
            @RequestParam(required = false) String status){
        return new ResponseEntity<>(loanService.getByOthers(memberEmail,status), HttpStatus.OK);
    }

    @PutMapping("/return")
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