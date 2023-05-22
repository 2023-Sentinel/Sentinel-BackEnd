package com.example.sentinelbackend.service;

import com.example.sentinelbackend.entity.Board;
import com.example.sentinelbackend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
//게시판을 처리하는 데 사용
public class BoardService {
    //BoardRepository 클래스를 주입받는 필드
    @Autowired  //의존성 주입
    BoardRepository boardRepository;

    /*public List<Board> list() {
        return boardRepository.findAll();
    }*/
    /*public List<Board> listById(int idx) {
        return boardRepository.findByDashId(idx);
    }*/
    public Page<Board> listById(int idx, Pageable pageable) {
        return boardRepository.findByDashId(idx, pageable);
    }


    public Board findById(Integer id) {
        return boardRepository.findById(id).orElse(null);
    }

    public Board create(Board board) {  //새로운 게시물을 생성하는 메소드
        return boardRepository.save(board);
    }

    public Board update(Integer id, Board board) {
        Board existingBoard = boardRepository.findById(id).orElse(null);
        existingBoard.setTitle(board.getTitle());
        existingBoard.setContent(board.getContent());
        //existingBoard.setWriter(board.getWriter());
        return boardRepository.save(existingBoard);
    }

    /*
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
    */
}
