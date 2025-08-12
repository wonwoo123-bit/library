package com.dw.library.service;

import com.dw.library.dto.LoanDto;
import com.dw.library.dto.LoanGetDto;
import com.dw.library.dto.LoanReturnDto;
import com.dw.library.exception.ResourceNotFoundException;
import com.dw.library.mapper.BookMapper;
import com.dw.library.mapper.LoanMapper;
import com.dw.library.mapper.MemberMapper;
import com.dw.library.model.Book;
import com.dw.library.model.Loan;
import com.dw.library.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LoanService {
    @Autowired
    LoanMapper loanMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    MemberMapper memberMapper;

    public long saveLoan(LoanDto loanDto){
        Book book = bookMapper.getBookById(loanDto.getBook());
        Member member = memberMapper.getMemberByEmail(loanDto.getMember());
        if (book == null){
            throw new ResourceNotFoundException("해당하는 책 찾을수 없음");
        }
        if (member == null){
            throw new ResourceNotFoundException("해당 이메일을 가진 유저 조회 불가능");
        }
        Loan loan = new Loan();
        loan.setMember(member);
        loan.setBook(book);
        loan.setLoanDate(LocalDateTime.now());
        loan.setDueDate(LocalDateTime.now().plusWeeks(2));
        loan.setStatus(loanDto.getStatus());
        loan.setCreatedAt(LocalDateTime.now());
        book.setAvailableQuantity(book.getAvailableQuantity()-1);

        return loanMapper.saveLoan(loan);
    }

    public List<LoanGetDto> getByOthers (String memberEmail, String status){
        return loanMapper.getByOthers(memberEmail, status).stream().map(Loan::loanGetDto).toList();
    }

    public int returnLoan(LoanReturnDto loanReturnDto){
        Member member = memberMapper.getMemberByEmail(loanReturnDto.getMemberEmail());
        if (member == null){
            throw new ResourceNotFoundException("해당 member 찾을 수 없음");
        }
        Book book = bookMapper.getBookById(loanReturnDto.getBookId());
        if (book == null){
            throw new ResourceNotFoundException("해당 책 찾을 수 없음");
        }
        Loan loan = loanMapper.getLoanById(loanReturnDto.getBookId());
        if (loan == null){
            throw new  ResourceNotFoundException(" 해당 대출 조회 불가능");
        }
        loan.setStatus(loanReturnDto.getStatus());
        loan.setCreatedAt(LocalDateTime.now());
        return loanMapper.returnLoan(loan);
    }
}
