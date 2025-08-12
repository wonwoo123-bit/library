package com.dw.library.model;

import com.dw.library.dto.MemberAllDto;
import com.dw.library.dto.MemberDto;
import com.dw.library.dto.MemberUpdateDto;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Member {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String memberType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public MemberDto toDto(){
        return new MemberDto(
                this.id,
                this.email,
                null,
                this.name,
                this.phone,
                this.address,
                this.memberType
        );
    }

    public MemberAllDto memberAllDto(){
        return new MemberAllDto(
                this.id,
                this.email,
                this.name,
                this.memberType
        );
    }

    public MemberUpdateDto memberUpdateDto(){
        return new MemberUpdateDto(
                this.name,
                this.phone,
                this.address
        );
    }

}
