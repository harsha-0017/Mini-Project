package com.careconnect.service;

import com.careconnect.model.Category;
import com.careconnect.model.HealthCamp;
import com.careconnect.repository.HealthCampRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HealthCampService {
    private final HealthCampRepository repository;

    public HealthCampService(HealthCampRepository repository) {
        this.repository = repository;
    }

    public List<HealthCamp> search(String city, Category category) {
        LocalDate today = LocalDate.now();
        boolean hasCity = city != null && !city.isBlank();
        if (hasCity && category != null) {
            return repository.findByCityContainingIgnoreCaseAndCategoryAndDateGreaterThanEqualOrderByDateAscStartTimeAsc(
                    city.trim(), category, today);
        }
        if (hasCity) {
            return repository.findByCityContainingIgnoreCaseAndDateGreaterThanEqualOrderByDateAscStartTimeAsc(
                    city.trim(), today);
        }
        if (category != null) {
            return repository.findByCategoryAndDateGreaterThanEqualOrderByDateAscStartTimeAsc(category, today);
        }
        return repository.findByDateGreaterThanEqualOrderByDateAscStartTimeAsc(today);
    }

    public HealthCamp get(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public HealthCamp save(HealthCamp camp) {
        return repository.save(camp);
    }

    public long count() {
        return repository.count();
    }

    public long cityCount() {
        return repository.findAll().stream().map(HealthCamp::getCity).distinct().count();
    }
}
