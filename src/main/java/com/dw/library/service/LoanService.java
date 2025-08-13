package com.dw.library.service;

import com.dw.library.dto.LoanDto;
import com.dw.library.dto.LoanGetDto;
import com.dw.library.dto.LoanReturnDto;
import com.dw.library.enums.LoanStatus;
import com.dw.library.exception.ResourceNotFoundException;
import com.dw.library.mapper.BookMapper;
import com.dw.library.mapper.LoanMapper;
import com.dw.library.mapper.MemberMapper;
import com.dw.library.model.Book;
import com.dw.library.model.Loan;
import com.dw.library.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class LoanService {
    @Autowired
    LoanMapper loanMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    MemberMapper memberMapper;


    public List<LoanDto> saveLoan(List<LoanDto> loanDtoList){
        if (loanDtoList == null || loanDtoList.isEmpty()) {
            throw new IllegalArgumentException("대출 정보가 비어있습니다.");
        }
        String memberEmail = loanDtoList.get(0).getMemberEmail();
        Member member = memberMapper.getMemberByEmail(memberEmail);
        if (member == null){
            throw new ResourceNotFoundException("해당 이메일을 가진 유저 조회 불가능");
        }
        Set<Long> bookIdSet = new HashSet<>();
        for (LoanDto dto : loanDtoList) {
            if (!bookIdSet.add(dto.getBookId())) {
                throw new ResourceNotFoundException("중복된 책이 존재합니다. 중복된 책 ID: " + dto.getBookId());
            }
        }
        List<Loan> loans = new ArrayList<>();

        for (LoanDto loanDto : loanDtoList) {
            Book book = bookMapper.findByBookId(loanDto.getBookId());

            if (book == null) {
                throw new ResourceNotFoundException("해당하는 책이 없음.");
            }

            if (book.getAvailableQuantity() <= 0) {
                throw new IllegalStateException("책의 대출 가능한 수량이 부족합니다. 책 ID: " + book.getBookId());
            }

            // 수량 감소
            book.setAvailableQuantity(book.getAvailableQuantity() - 1);
            bookMapper.updateBook(book); // 데이터베이스 반영


            LocalDateTime now = LocalDateTime.now();
            LocalDateTime dueDate = now.plusWeeks(2);
            LocalDateTime returnDate = null;

            LoanStatus status = LoanStatus.fromDates(now.toLocalDate(), null);
            Loan loan = new Loan(
                    null,
                    member,
                    book,
                    LocalDateTime.now(),
                    LocalDateTime.now().plusWeeks(2),
                    null,
                    status, // 변수명이 active → LoanStatus.ACTIVE 등으로 가정
                    null,
                    LocalDateTime.now()
            );

            loans.add(loan);
        }
        loanMapper.saveLoan(loans);
        return loanDtoList;
    }

    public List<LoanGetDto> getByOthers (String memberEmail, String status){
        return loanMapper.getByOthers(memberEmail, status).stream().map(Loan::loanGetDto).toList();
    }

    public LoanReturnDto returnLoan(long id,LoanReturnDto loanReturnDto){

        Loan loan = loanMapper.getLoanById(id);
        if (loan == null){
            throw new  ResourceNotFoundException(" 해당 대출 조회 불가능");
        }
        Member member = memberMapper.getMemberByEmail(loanReturnDto.getMemberEmail());
        if (member == null){
            throw new ResourceNotFoundException("해당 member 찾을 수 없음:" + loanReturnDto.getMemberEmail());
        }
        Book book = bookMapper.getBookById(loanReturnDto.getBookId());
        if (book == null){
            throw new ResourceNotFoundException("해당 책 찾을 수 없음");
        }

        LocalDateTime now = LocalDateTime.now();
        loan.setReturnDate(now);

        loan.setStatus(LoanStatus.fromDates(loan.getReturnDate().toLocalDate(), now.toLocalDate()));
        loan.setCreatedAt(now);


        book.setAvailableQuantity(book.getAvailableQuantity() + 1);
        bookMapper.updateBook(book);


        Loan updatedLoan = loanMapper.returnLoan(id, loan);
        return new LoanReturnDto(
                updatedLoan.getLoanId(),
                updatedLoan.getMember().getEmail(),
                updatedLoan.getBook().getBookId(),
                updatedLoan.getStatus()
        );
    }
}
