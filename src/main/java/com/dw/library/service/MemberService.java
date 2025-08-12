package com.dw.library.service;

import com.dw.gameshop_mybatis.exception.InvalidRequestException;
import com.dw.library.dto.MemberAllDto;
import com.dw.library.dto.MemberDto;
import com.dw.library.mapper.MemberMapper;
import com.dw.library.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public List<MemberAllDto> getAllMember(int page, int size){
        int offset = page * size;
        return memberMapper.getAllMember(offset, size).stream().map(Member::memberAllDto).toList();
    }











//    로그인 + 회원가입로직

    public boolean validateUser(String email,
                                String password){
        Member member = memberMapper.getMemberByEmail(email);
        return member != null && passwordEncoder.matches(password,member.getPassword());
    }

    public MemberDto registerMember(MemberDto memberDto){
        Member member =memberMapper.getMemberByEmail(memberDto.getEmail());
        if (member != null){
            throw new InvalidRequestException("이미 있는 이메일");
        }
        String encode = passwordEncoder.encode(memberDto.getPassword());
        memberDto.setPassword(encode);
        memberMapper.registerMember(memberDto);
        memberDto.setPassword(null); // 응답전에 비밀번호 필드 null 값 변경
        return memberDto;
    }

}
