package com.dw.library.dto;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDto {
    private long id;
    private String email;
    private String name;
    private String phone;
    private String address;
    private String memberType;
    private LocalDateTime updatedAt;
}
