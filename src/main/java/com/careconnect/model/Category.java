package com.careconnect.model;

public enum Category {
    EYE("Eye Care"),
    BLOOD("Blood Donation"),
    VACCINATION("Vaccination"),
    DENTAL("Dental"),
    WOMENS_HEALTH("Women's Health"),
    SENIOR_CARE("Senior Care"),
    MENTAL_HEALTH("Mental Health");

    private final String label;

    Category(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
