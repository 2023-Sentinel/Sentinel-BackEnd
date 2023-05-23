package com.example.sentinelbackend.dto;

import com.example.sentinelbackend.entity.DashboardEntity;
import lombok.Getter;

import java.util.Date;

@Getter
public class DashboardResponseDto {
    private Long id;
    private String title;
    private String srn;
    private Date created_at;

    public DashboardResponseDto(DashboardEntity entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.srn = entity.getSrn();
        this.created_at = entity.getCreated_at();
    }
}
