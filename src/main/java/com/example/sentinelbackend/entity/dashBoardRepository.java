package com.example.sentinelbackend.entity;

import com.example.sentinelbackend.entity.DashboardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface dashBoardRepository extends JpaRepository<DashboardEntity, Long> {

}