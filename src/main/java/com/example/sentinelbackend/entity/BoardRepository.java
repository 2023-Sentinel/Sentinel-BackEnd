package com.example.sentinelbackend.entity;

import com.example.sentinelbackend.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


//게시판을 저장하고 검색하는 데 사용
public interface BoardRepository extends JpaRepository<Board, Integer> {
    /*@Query(value = "select * from board where board.dash_id=:idx", nativeQuery = true)
    List<Board> findByDashId(@Param("idx") int idx);*/

    @Query(value = "select * from board where board.dash_id=:idx", nativeQuery = true)  // SQL 쿼리인데 이게 board 테이블에서 dash_id랑 idx값이 서로 일치하는 모든 게시물을 검색하는 거
    Page<Board> findByDashId(@Param("idx") int idx, Pageable pageable);
}