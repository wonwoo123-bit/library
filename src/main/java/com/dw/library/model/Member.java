package com.dw.library.model;

import com.dw.library.dto.MemberDto;
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

}
