package com.example.sentinelbackend.service;

import com.example.sentinelbackend.dto.DashboardResponseDto;
import com.example.sentinelbackend.dto.DashboardSaveRequestDto;
import com.example.sentinelbackend.entity.Dashboard;
import com.example.sentinelbackend.entity.DashboardEntity;
import com.example.sentinelbackend.entity.dashBoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DashboardService {
    private final dashBoardRepository dashboardRepository;

    @Transactional
    public Long save(DashboardSaveRequestDto requestDto){
        return dashboardRepository.save(requestDto.toEntity()).getId();
    }

    public DashboardResponseDto findById(Long id){
        DashboardEntity entity = dashboardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("ERROR_ILG"));

        return new DashboardResponseDto(entity);
    }

    public List<Dashboard> getDashboardList() {
        List<DashboardEntity> dashboardEntities = dashboardRepository.findAll();
        List<Dashboard> dtos = new ArrayList<>();

        for (DashboardEntity entity : dashboardEntities) {
            Dashboard dto = Dashboard.builder()
                    .id(entity.getId())
                    .title(entity.getTitle())
                    .srn(entity.getSrn())
                    .createdAt(entity.getCreated_at())
                    .build();

            dtos.add(dto);
        }

        return dtos;
    }

}
