package com.dw.library.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class LoanPopDto {
    private Long bookId;
    private String title;
    private String author;
}
