package com.example.sentinelbackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "scenarios")
public class Scenario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String scName;

    private String data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getScName() {
        return scName;
    }

    public void setScName(String scName) {
        this.scName = scName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}