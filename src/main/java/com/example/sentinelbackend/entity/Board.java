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
    @Id //primary key라고 연결
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동증가 값이다
    private Integer id; //column도 연결

    @Column(length = 50, nullable = false)   //길이가 50이고, null 허용 안함
    private String title;   //column도 연결

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false) //null 허용 안함
    private String content;    //column도 연결


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
