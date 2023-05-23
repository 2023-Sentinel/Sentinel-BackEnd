package com.example.sentinelbackend.entity;

import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Data // getter, setter 자동 생성
@AllArgsConstructor // 모든 매개변수를 가진 생성자가 추가됨
@NoArgsConstructor
@Builder
public class BoardCont implements Serializable {
    private Long id;
    private String title;
    private Date date;
    private String content;

}
