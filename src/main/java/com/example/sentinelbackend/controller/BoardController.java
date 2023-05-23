package com.example.sentinelbackend.controller;

import com.example.sentinelbackend.entity.Board;

import com.example.sentinelbackend.entity.BoardCont;
import com.example.sentinelbackend.entity.Dashboard;
import com.example.sentinelbackend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    @Autowired  //의존성 주입
    BoardService boardService;

    /*@GetMapping("/boards")  //게시물 목록 조회
    //@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC)
    public ResponseEntity<Iterable<Board>> list(@RequestParam(value="idx") int idx) {
        //return new ResponseEntity<>(boardService.list(), HttpStatus.OK);
        return new ResponseEntity<>(boardService.listById(idx), HttpStatus.OK);
    }*/
    @GetMapping("/api/boards/list")
    public List<BoardCont> boardList(){
        return boardService.getBoardList();
    }

    @GetMapping("/api/boards/{id}") //선택한 게시물 보기
    public ResponseEntity<Board> detail(@PathVariable Integer id) { //url로 온 게시물 id를 매개변수로 받음
        return new ResponseEntity<>(boardService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/api/createBoards") //게시물 생성
    public ResponseEntity<Board> create(@RequestBody Board board) { //HTTP Body에 담긴 데이터를 매핑하여 가지고 오는 어노테이션
        return new ResponseEntity<>(boardService.create(board), HttpStatus.CREATED);    //ResponseEntity는 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스
    }

    @PutMapping("/api/boards/{id}") //게시물 수정
    public ResponseEntity<Board> update(@PathVariable Integer id, @RequestBody Board board) {
        return new ResponseEntity<>(boardService.update(id, board), HttpStatus.OK);
    }

    /*
    @DeleteMapping("/boards/{id}")  //삭제
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boardService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    */
}