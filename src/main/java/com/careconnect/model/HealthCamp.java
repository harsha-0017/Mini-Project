package com.careconnect.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class HealthCamp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please enter a camp title")
    @Size(max = 120, message = "Title must be 120 characters or fewer")
    private String title;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Please select a category")
    private Category category;

    @NotBlank(message = "Please enter the city")
    private String city;

    @NotBlank(message = "Please enter the venue")
    private String venue;

    @NotNull(message = "Please select a date")
    @FutureOrPresent(message = "Camp date cannot be in the past")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    @NotNull(message = "Please select a start time")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @NotBlank(message = "Please add a description")
    @Size(max = 1000, message = "Description must be 1000 characters or fewer")
    @Column(length = 1000)
    private String description;

    @NotBlank(message = "Please enter organizer details")
    private String organizerName;

    @NotBlank(message = "Please enter a contact number")
    @Pattern(regexp = "^[0-9+() -]{7,20}$", message = "Please enter a valid contact number")
    private String contact;

    @Min(value = 1, message = "Capacity must be at least 1")
    private int capacity;

    public HealthCamp() {
    }

    public HealthCamp(String title, Category category, String city, String venue, LocalDate date,
                      LocalTime startTime, String description, String organizerName,
                      String contact, int capacity) {
        this.title = title;
        this.category = category;
        this.city = city;
        this.venue = venue;
        this.date = date;
        this.startTime = startTime;
        this.description = description;
        this.organizerName = organizerName;
        this.contact = contact;
        this.capacity = capacity;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getVenue() { return venue; }
    public void setVenue(String venue) { this.venue = venue; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getOrganizerName() { return organizerName; }
    public void setOrganizerName(String organizerName) { this.organizerName = organizerName; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}
