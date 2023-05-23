package com.example.sentinelbackend.controller;
import com.example.sentinelbackend.dto.DashboardResponseDto;
import com.example.sentinelbackend.dto.DashboardSaveRequestDto;
import com.example.sentinelbackend.entity.Dashboard;
import com.example.sentinelbackend.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class DashboardController {
    private final DashboardService dashboardService;

    @PostMapping("/createDashboard")
    public Long save(@RequestBody DashboardSaveRequestDto requestDto){
        return dashboardService.save(requestDto);
    }

    @GetMapping("/dashboards/{id}")
    public DashboardResponseDto findById(@PathVariable Long id){
        return dashboardService.findById(id);
    }

    @GetMapping("/dashboards/list")
    public List<Dashboard> dashboardList(){
        return dashboardService.getDashboardList();
    }
//    @PostMapping("/createDashboard")
//    public Dashboard createDashboard(@RequestBody Dashboard dashboard) {
//
//        return dashboard;
//    }

}