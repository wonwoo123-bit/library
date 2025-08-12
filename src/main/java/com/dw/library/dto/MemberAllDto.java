package com.dw.library.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberAllDto {
    @NotNull
    private long id;
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;
    @NotBlank(message = "이름은 필수 입력값입니다")
    @Length(min = 0, max = 255,
            message = "이름 255자 이하로 입력해야 합니다.")
    private String name;
    @NotBlank
    private String memberType; // (STUDENT/TEACHER/GENERAL)
}
