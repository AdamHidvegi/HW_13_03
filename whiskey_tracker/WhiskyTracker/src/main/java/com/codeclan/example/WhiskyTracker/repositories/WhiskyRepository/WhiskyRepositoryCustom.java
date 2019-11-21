package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {
    List<Whisky> findSpecificWhiskyFromSpecificDistillery(String name, Integer age);
    List<Whisky> findEveryWhiskyInSpecificRegion(String region);
}
