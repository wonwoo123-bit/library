package com.dw.library.service;

import com.dw.library.mapper.MemberMapper;
import com.dw.library.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public boolean validateUser(String email,
                                String password){
        Member member = memberMapper.getUserByEmail(email);
        return member != null && passwordEncoder.matches(password,member.getPassword());
    }

}
