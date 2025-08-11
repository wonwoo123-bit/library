package com.dw.library.mapper;

import com.dw.library.dto.MemberDto;
import com.dw.library.model.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {

    void registerMember(@Param("MemberDto")MemberDto memberDto);

    List<Member> getAllMember();

    Member getMemberById(@Param("id")long id);

    Member updateMember(@Param("MemberDto")MemberDto memberDto);

}
