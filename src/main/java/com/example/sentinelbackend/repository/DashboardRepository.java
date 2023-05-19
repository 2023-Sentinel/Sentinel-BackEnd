package com.example.sentinelbackend.repository;
import com.example.sentinelbackend.entity.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DashboardRepository extends JpaRepository<Dashboard, Long> {

}