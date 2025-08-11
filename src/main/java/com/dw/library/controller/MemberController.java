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
//    회원 추가(회원가입)
    public ResponseEntity<MemberDto> registerMember(@RequestBody MemberDto memberDto){
        return null;
    }

    @GetMapping
//  전체 회원 조회
    public ResponseEntity<MemberDto> getAllMember(){
        return null;
    }

    @GetMapping("/members/{memberId}")
//    회원 id로 조회
    public ResponseEntity<MemberDto> getMemberById(@PathVariable long id){
        return null;
    }

}

