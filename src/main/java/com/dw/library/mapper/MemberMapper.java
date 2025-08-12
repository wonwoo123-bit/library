package com.dw.library.mapper;

import com.dw.library.dto.MemberDto;
import com.dw.library.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {
    Member getMemberByEmail(@Param("email")String email);

    void registerMember(@Param("memberDto")MemberDto memberDto);

    List<Member> getAllMember(
            @Param("offset") int offset,
            @Param("limit") int limit);

//    Member getMemberById(@Param("id")long id);
//
//    Member updateMember(@Param("MemberDto")MemberDto memberDto);
}
