package com.example.sentinelbackend.repository;

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

    @Query(value = "select * from board where board.dash_id=:idx", nativeQuery = true)
    Page<Board> findByDashId(@Param("idx") int idx, Pageable pageable);
}
