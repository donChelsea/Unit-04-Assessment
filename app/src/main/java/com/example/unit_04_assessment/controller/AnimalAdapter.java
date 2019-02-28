package com.example.unit_04_assessment.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.unit_04_assessment.R;
import com.example.unit_04_assessment.model.Animal;
import com.example.unit_04_assessment.view.AnimalViewHolder;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    private List<Animal> animalList;

    public AnimalAdapter(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new AnimalViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.animal_list_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder animalViewHolder, int i) {
        animalViewHolder.onBind(animalList.get(i));
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }
}
