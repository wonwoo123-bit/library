package com.dw.library.mapper;

import com.dw.library.model.Loan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoanMapper {
    long saveLoan(@Param("Loan")Loan loan);

}
