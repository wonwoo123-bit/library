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
public class MemberUpdateDto {
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;
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
}
