package com.dw.library.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
public enum LoanStatus {
    active("active"),
    returned("returned"),
    overdue("overdue");

    private final String code;

    LoanStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static LoanStatus fromDates(LocalDate borrowDate, LocalDate returnDate) {
        if (returnDate != null) {
            return returned;
        }

        long daysBetween = ChronoUnit.DAYS.between(borrowDate, LocalDate.now());

        if (daysBetween > 14) { // 연체 기준: 14일
            return overdue;
        }

        return active;
    }
}
