package com.dw.library.controller;

import com.dw.library.dto.MemberAllDto;
import com.dw.library.dto.MemberByEmailDto;
import com.dw.library.dto.MemberDto;
import com.dw.library.dto.MemberUpdateDto;
import com.dw.library.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping("/register")
//    회원 추가(회원가입)
    public ResponseEntity<MemberDto> registerMember(@Valid @RequestBody MemberDto memberDto){
        return new ResponseEntity<>(memberService.registerMember(memberDto), HttpStatus.CREATED);
    }

    @GetMapping("/all")
//  전체 회원 조회
    public ResponseEntity<List<MemberAllDto>> getAllMember(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return new ResponseEntity<>(memberService.getAllMember(page, size), HttpStatus.OK);
    }

    @GetMapping("/members/{email}")
//    회원 email로 회원 상세 조회
    public ResponseEntity<MemberByEmailDto> getMemberById(@PathVariable String email){
        return new ResponseEntity<>(
                memberService.getMemberByEmail(email),
                HttpStatus.OK);
    }

    @PutMapping("/members/{email}")
//    회원 수정
    public ResponseEntity<String> updateMember(
            @PathVariable String email,
            @RequestBody MemberUpdateDto memberUpdateDto) {
        memberService.updateMember(email, memberUpdateDto);
        return new ResponseEntity<>("회원 정보가 수정되었습니다.", HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody MemberDto memberDto,
                                        HttpServletRequest request) {
        String email = memberDto.getEmail();
        String password = memberDto.getPassword();
        if (memberService.validateUser(email, password)){
            HttpSession session = request.getSession(); // 세션정보 획득
            session.setAttribute("email", email); // username 저장
            return new ResponseEntity<>(
                    "Login successful",
                    HttpStatus.OK);
        }else {
            throw new UnsupportedOperationException(
                    "아이디 또는 비밀번호가 올바르지 않습니다.");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request){
        request.getSession().invalidate(); //세션 종료의 의미
        return new ResponseEntity<>(
                "성공적으로 로그아웃 되었습니다.",
                HttpStatus.OK);
    }
}

