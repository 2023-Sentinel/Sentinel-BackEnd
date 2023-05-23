package com.example.sentinelbackend.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data // getter, setter 자동 생성
@AllArgsConstructor // 모든 매개변수를 가진 생성자가 추가됨
@NoArgsConstructor
@Builder
public class Dashboard implements Serializable {
    private Long id;
    private String title;
    private String srn;
    private Date createdAt;

}
//@Entity
//public class Dashboard {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String title;
//
//    private String srn;
//
//    private LocalDateTime createdAt;
//
//    public Dashboard() {}
//
//    public Dashboard(String title, String srn, LocalDateTime createdAt) {
//        this.title = title;
//        this.srn = srn;
//        this.createdAt = createdAt;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getSrn() {
//        return srn;
//    }
//
//    public void setSrn(String srn) {
//        this.srn = srn;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }
//}