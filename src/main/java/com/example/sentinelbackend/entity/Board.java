package com.example.sentinelbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="board")
//게시판을 나타내는 데 사용
public class Board {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;


    @Column(length = 50, nullable = true)   //길이가 50이고, null 허용 안함
    private String title;   //제목 column 연결

    @Column(nullable = true)   //null 허용안함
    private LocalDateTime date; //날짜 column 연결

    @Column(columnDefinition = "TEXT") //null 허용 안함
    private String content;    //내용 column 연결

    /*
    아래는 다 getter/setter 부분
    getter : 객체의 속성(property) 값을 반환하는 메서드, 외부에서 데이터 읽을 때 메소드로 이용해 읽게 해줘요 데이터는 못건드리게 해주는 보안용
    setter : 객체의 속성 값을 설정, 변경하는 메서드, 외부에서 메소드를 통해 접근하도록 해줘요 이것도 데이터 못건드리게 해줌
    */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public DashBoard getDashBoard() {
//        return dashBoard;
//    }
//
//    public void setDashBoard(DashBoard dashBoard) {
//        this.dashBoard = dashBoard;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}