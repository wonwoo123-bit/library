package com.dw.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BookDto {
    private long bookId;
    @PositiveOrZero(message = "isbn은 0 이상이어야 합니다")
    private String isbn;
    // ('general_works', 'philosophy' , 'religion', 'social_sciences', 'natural_sciences', 'applied_sciences', 'arts', 'language', 'literature', 'history'),
    @NotBlank
    @Length(min = 0, max = 255, message = "도서명 이름은 255자 이하로 입력해야 합니다.")
    private String title; // 도서명
    @NotBlank
    @Length(min = 0, max = 255,
            message = "저자 이름은 255자 이하로 입력해야 합니다.")
    private String author; // 저자
    @NotBlank
    @Length(min = 0, max = 255,
            message = "출판사 이름은 255자 이하로 입력해야 합니다.")
    private String publisher; // 출판사
    @NotBlank
    @PastOrPresent(message = "출간년도는 현재 또는 과거 날짜여야 합니다")
    private int publicationYear; // 출간년도
    @NotBlank
    private String category; // 카테고리
    @NotBlank
    @PositiveOrZero(message = "총수량은 0 이상이어야 합니다")
    private int totalQuantity; // 총수량
    @NotBlank
    @Length(min = 0, max = 255,
            message = "소장위치는 255자 이하로 입력해야 합니다.")
    private String location; // 소장위치
}
