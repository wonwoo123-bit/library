package com.dw.library.mapper;

import com.dw.library.model.Loan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoanMapper {
    long saveLoan(@Param("loan")Loan loan);

    List<Loan> getByOthers(@Param("memberEmail") String memberEmail,
                           @Param("status") String status);

    Loan getLoanById(@Param("id") long id);

    int returnLoan(@Param("loan") Loan loan);
}
