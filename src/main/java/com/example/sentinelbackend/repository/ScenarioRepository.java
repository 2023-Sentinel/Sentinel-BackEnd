package com.example.sentinelbackend.repository;

import com.example.sentinelbackend.entity.Scenario;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ScenarioRepository extends PagingAndSortingRepository<Scenario, Long> {

    Scenario save(Scenario scenario);

    Optional<Object> findById(Long id);

    void deleteById(Long id);

    List<Scenario> findAll();
}