package com.dw.library.mapper;

import com.dw.library.dto.LoanOverdueDto;
import com.dw.library.model.Loan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LoanMapper {
    void saveLoan(@Param("listLoan")List<Loan> listLoan);

    List<Loan> getByOthers(@Param("memberEmail") String memberEmail,
                           @Param("status") String status);

    Loan getLoanById(@Param("id") long id);

    int returnLoan(@Param("id") long id);

    List<LoanOverdueDto> getOverdueLoans();
}
