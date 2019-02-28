package com.example.unit_04_assessment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AnimalList {
    @SerializedName("message")

    private List<Animal> animalList;

    public AnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}
