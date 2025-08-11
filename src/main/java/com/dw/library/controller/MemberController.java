package com.dw.library.controller;

import com.dw.library.dto.MemberDto;
import com.dw.library.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    @PostMapping
//    회원 추가(회원가입)
    public ResponseEntity<MemberDto> registerMember(@RequestBody MemberDto memberDto){
        return null;
    }

    @GetMapping
//  전체 회원 조회
    public ResponseEntity<List<MemberDto>> getAllMember(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return null;
    }

    @GetMapping("/members/{memberId}")
//    회원 id로 회원 상세 조회
    public ResponseEntity<MemberDto> getMemberById(@PathVariable long id){
        return null;
    }

    @PutMapping("/members/{memberId}")
    public ResponseEntity<MemberDto> updateMember(@RequestBody MemberDto memberDto){
        return null;
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

