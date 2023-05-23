package com.example.sentinelbackend.dto;

import com.example.sentinelbackend.entity.DashboardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
public class DashboardSaveRequestDto {
    private String title;
    private String srn;
    private Date created_at;

    @Builder
    public DashboardSaveRequestDto(String title, String srn, Date created_at){
        this.title = title;
        this.srn = srn;
        this.created_at = created_at;
    }

    public DashboardEntity toEntity(){
        return DashboardEntity.builder().title(title).srn(srn).created_at(created_at).build();
    }
}
