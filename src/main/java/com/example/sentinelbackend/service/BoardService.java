package com.example.sentinelbackend.service;

import com.example.sentinelbackend.entity.Board;
import com.example.sentinelbackend.entity.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
//게시판을 처리하는 데 사용
public class BoardService {
    //BoardRepository 클래스를 주입받는 필드
    @Autowired  //의존성 주입
            BoardRepository boardRepository;    //BoardRepository에 써져있는 설명 보면 알 수 있는데 그런 설정 가진 변수를 여기서 쓸 수 있게 생성

    /*public List<Board> list() {
        return boardRepository.findAll();
    }*/
    /*public List<Board> listById(int idx) {
        return boardRepository.findByDashId(idx);
    }*/
    public Page<Board> listById(int idx, Pageable pageable) {
        return boardRepository.findByDashId(idx, pageable); //idx랑 pageable을 boardrepository의 findByDashId 함수에 넣어 나온 값 반환
    }

    //게시물을 id 값으로 조회해서 해당 게시물 반환, 반환값: boardrepository의 findbyid(함수 값) 없으면 빈 값 출력
    public Board findById(Integer id) {
        return boardRepository.findById(id).orElse(null);
    }

    public Board create(Board board) {  //새로운 게시물을 생성하는 메소드
        return boardRepository.save(board);   //board라는 변수로 boardrepository에서 save메소드에 board 넣어주는 건데, 게시글 만들어서 저장하는 거
    }

    public Board update(Integer id, Board board) {  //기존 게시글 수정 메소드
        Board existingBoard = boardRepository.findById(id).orElse(null);    //id값으로 기존 게시물 조회하는거
        existingBoard.setTitle(board.getTitle());
        existingBoard.setContent(board.getContent());
        //existingBoard.setWriter(board.getWriter());
        return boardRepository.save(existingBoard); //전달받은 board 객체 내용으로 기존 게시물(제목하고 내용) 업데이트 후 저장해서 반환
    }

    /*
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
    */
}