package com.example.sentinelbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="dashboards")
public class DashboardEntity implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(length=255)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String srn;

    @Column
    private Date created_at;

    @PrePersist
    public void beforeCreate(){
        created_at = new Date();
    }

    @Builder
    public DashboardEntity(String title, String srn, Date created_at){
        this.title = title;
        this.srn = srn;
        this.created_at = created_at;
    }
}
