package com.dw.library.dto;

import com.dw.library.model.Member;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDto {
    @NotNull
    private long id;
    @NotBlank(message = "이메일은 필수 입력값입니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;
    private String password;
    @NotBlank(message = "이름은 필수 입력값입니다")
    @Length(min = 0, max = 255,
            message = "이름 255자 이하로 입력해야 합니다.")
    private String name;
    @NotBlank(message = "전화번호는 필수 입력값입니다")
    @Pattern(regexp = "^[0-9]{3}-[0-9]{4}-[0-9]{4}$",
            message = "전화번호 형식이 올바르지 않습니다)")
    private String phone;
    @NotBlank(message = "주소는 필수 입력값입니다")
    @Length(min = 0, max = 255,
            message = "주소는 255자 이하로 입력해야 합니다.")
    private String address;


    @NotBlank
    // @ValidEnum(enumClass = Member.class)
    private String memberType; // (STUDENT/TEACHER/GENERAL) ???
}
