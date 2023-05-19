package com.example.sentinelbackend.controller;

import com.example.sentinelbackend.entity.Dashboard;
import com.example.sentinelbackend.repository.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DashboardController {
    @Autowired
    private DashboardRepository dashboardRepository;

    @GetMapping("/dashboards")
    public List<Dashboard> getAllDashboards() {
        return dashboardRepository.findAll();
    }

    @GetMapping("/dashboards/{id}")
    public Dashboard getDashboardById(@PathVariable Long id) {
        return dashboardRepository.findById(id).orElse(null);
    }

    @PostMapping("/Dashboards")
    public Dashboard createDashboard(@RequestBody Dashboard dashboard) {
        return dashboardRepository.save(dashboard);
    }

    @PutMapping("/Dashboards/{id}")
    public Dashboard updateDashboard(@PathVariable Long id, @RequestBody Dashboard dashboard) {
        dashboard.setId(id);
        return dashboardRepository.save(dashboard);
    }

    @DeleteMapping("/Dashboards/{id}")
    public void deleteDashboard(@PathVariable Long id) {
        dashboardRepository.deleteById(id);
    }
}