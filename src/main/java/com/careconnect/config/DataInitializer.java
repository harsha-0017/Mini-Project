package com.careconnect.config;

import com.careconnect.model.Category;
import com.careconnect.model.HealthCamp;
import com.careconnect.repository.HealthCampRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner seedCamps(HealthCampRepository repository) {
        return args -> {
            if (repository.count() > 0) return;
            repository.save(new HealthCamp("Free Eye Screening Camp", Category.EYE, "Bengaluru",
                    "BBMP Community Hall, Jayanagar", LocalDate.now().plusDays(4), LocalTime.of(9, 0),
                    "Free vision screening, eye pressure checks and referrals for cataract care.",
                    "Netradhama Foundation", "+91 98765 43210", 150));
            repository.save(new HealthCamp("Community Blood Donation Drive", Category.BLOOD, "Mysuru",
                    "Mysuru Palace Grounds", LocalDate.now().plusDays(9), LocalTime.of(10, 0),
                    "Donate blood and help local hospitals keep their emergency supplies ready.",
                    "Mysuru Red Cross", "+91 99887 66554", 100));
            repository.save(new HealthCamp("Vaccination and Wellness Camp", Category.VACCINATION, "Mangaluru",
                    "St. Mary's School", LocalDate.now().plusDays(14), LocalTime.of(8, 30),
                    "Routine vaccinations and basic health checks for children and families.",
                    "Coastal Care NGO", "+91 91234 56789", 200));
            repository.save(new HealthCamp("Senior Care Health Camp", Category.SENIOR_CARE, "Hubballi",
                    "Karnataka Institute Community Centre", LocalDate.now().plusDays(20), LocalTime.of(9, 30),
                    "Blood pressure, diabetes and mobility screening with geriatric doctors.",
                    "Arogya Seva Trust", "+91 90123 45678", 80));
        };
    }
}
