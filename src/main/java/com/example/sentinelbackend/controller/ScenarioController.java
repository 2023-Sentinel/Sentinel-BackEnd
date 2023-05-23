package com.example.sentinelbackend.controller;

import com.example.sentinelbackend.entity.Scenario;
import com.example.sentinelbackend.repository.ScenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ScenarioController {

    @Autowired
    private ScenarioRepository scenarioRepository;

    @PostMapping("/scenarios")
    public Scenario createScenario(@RequestBody Scenario scenario) {
        return scenarioRepository.save(scenario);
    }

    @GetMapping("/scenarios")
    public List<Scenario> getAllScenarios() {
        return scenarioRepository.findAll();
    }

    @GetMapping("/scenarios/{id}")
    public Scenario getScenarioById(@PathVariable Long id) {
        return (Scenario) scenarioRepository.findById(id).orElse(null);
    }

    @PutMapping("/scenarios/{id}")
    public Scenario updateScenario(@PathVariable Long id, @RequestBody Scenario scenario) {
        Scenario existingScenario = (Scenario) scenarioRepository.findById(id).orElse(null);
        existingScenario.setScName(scenario.getScName());
        existingScenario.setData(scenario.getData());
        return scenarioRepository.save(existingScenario);
    }

    @DeleteMapping("/scenarios/{id}")
    public void deleteScenario(@PathVariable Long id) {
        scenarioRepository.deleteById(id);
    }

}
