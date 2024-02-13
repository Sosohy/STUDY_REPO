package com.ohgiraffers.section01.autowired.subsection03.setter;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceSetter")
public class BookService {
    private BookDAO bookDAO;   // 반드시 의도한 값이 들어가서 final 붙일 수 있음

    @Autowired
    public void setBookDAO(BookDAO bookDAO){
        this.bookDAO = bookDAO;
    }

    /* 설명. 도서 목록 전체 조회 */
    public List<BookDTO> findAllBook(){
        return bookDAO.findAllBook();
    }

    /* 설명. 도서 번호로 도서 조회 */
    public BookDTO searchBookBySequence(int seq) {
        return bookDAO.searchBookBySequence(seq);
    }
}
