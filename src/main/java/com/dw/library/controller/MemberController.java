package com.dw.library.controller;

import com.dw.library.dto.MemberDto;
import com.dw.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberDto> registerMember(@RequestBody MemberDto memberDto){
        return null;
    }

    @GetMapping
    public ResponseEntity<MemberDto> registerMember(){
        return null;
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberDto> getMemberById(@PathVariable long id){
        return null;
    }

}



//post : registerMember
//
//get  c
//get /{memberId} : getMemberById
//get /statistics/member-loans/{memberId} : getMemberLoans
