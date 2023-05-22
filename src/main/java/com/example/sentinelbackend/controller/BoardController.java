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
    @GetMapping("/boards")
    public ResponseEntity<Page<Board>> list(@RequestParam(value="idx") int idx, @RequestParam(value="p") int page) {
        Pageable pageable = PageRequest.of(page, 5, Sort.Direction.DESC, "id");
        return new ResponseEntity<>(boardService.listById(idx, pageable), HttpStatus.OK);
    }

    @GetMapping("/boards/{id}") //게시물 조회
    public ResponseEntity<Board> detail(@PathVariable Integer id) {
        return new ResponseEntity<>(boardService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/boards") //생성
    public ResponseEntity<Board> create(@RequestBody Board board) {
        return new ResponseEntity<>(boardService.create(board), HttpStatus.CREATED);
    }

    @PutMapping("/boards/{id}") //수정
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