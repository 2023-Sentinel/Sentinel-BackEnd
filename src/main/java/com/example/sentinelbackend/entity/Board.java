package com.example.sentinelbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor // 모든 매개변수를 가진 생성자가 추가됨
@NoArgsConstructor
@Entity
@Table(name="board")
//게시판을 나타내는 데 사용
public class Board {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(length = 50, nullable = true)   //길이가 50이고, null 허용 안함
    private String title;   //제목 column 연결

    @Column//null 허용안함
    private Date date; //날짜 column 연결

    @Column(columnDefinition = "TEXT") //null 허용 안함
    private String content;    //내용 column 연결

    @PrePersist
    public void beforeCreate(){
        date = new Date();
    }
    @Builder
    public Board(String title, Date date, String content){
        this.title = title;
        this.content = content;
        this.date = date;
    }
}