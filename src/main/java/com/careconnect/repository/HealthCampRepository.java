package com.careconnect.repository;

import com.careconnect.model.Category;
import com.careconnect.model.HealthCamp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HealthCampRepository extends JpaRepository<HealthCamp, Long> {
    List<HealthCamp> findByDateGreaterThanEqualOrderByDateAscStartTimeAsc(LocalDate date);
    List<HealthCamp> findByCityContainingIgnoreCaseAndDateGreaterThanEqualOrderByDateAscStartTimeAsc(
            String city, LocalDate date);
    List<HealthCamp> findByCategoryAndDateGreaterThanEqualOrderByDateAscStartTimeAsc(
            Category category, LocalDate date);
    List<HealthCamp> findByCityContainingIgnoreCaseAndCategoryAndDateGreaterThanEqualOrderByDateAscStartTimeAsc(
            String city, Category category, LocalDate date);
}
