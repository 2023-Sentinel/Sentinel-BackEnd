package com.example.sentinelbackend.controller;

import com.example.sentinelbackend.entity.Board;

import com.example.sentinelbackend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/api/boards")  //시나리오 인덱스에 해당하는 게시물 목록 조회
    public ResponseEntity<Page<Board>> list(@RequestParam(value="idx") int idx, @RequestParam(value="p") int page) {    //시나리오 id, 페이지 번호(페이지는 0부터)
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.DESC, "id"); //넘겨받은 페이지 번호, 게시글 5개씩 보이게, 내림차순 정렬, 게시판 id기준으로
        return new ResponseEntity<>(boardService.listById(idx, pageable), HttpStatus.OK);   //서버 측 성공 상태 응답
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