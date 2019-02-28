package com.example.unit_04_assessment.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unit_04_assessment.R;
import com.example.unit_04_assessment.SecondActivity;
import com.example.unit_04_assessment.model.Animal;
import com.squareup.picasso.Picasso;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    public static final String ANIMAL_NAME = "animal name";
    public static final String ANIMAL_IMAGE = "animal image";
    public static final String ANIMAL_WIKI = "animal wiki";
    private ImageView animalImageView;
    private TextView animalTextView;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        animalImageView = itemView.findViewById(R.id.animal_image_view);
        animalTextView = itemView.findViewById(R.id.animal_textview);
    }

    public void onBind(final Animal animal) {
        animalTextView.setText(animal.getAnimal());
        animalTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SecondActivity.class);
                Bundle extras = new Bundle();
                extras.putString(ANIMAL_NAME, animal.getAnimal());
                extras.putString(ANIMAL_IMAGE, animal.getImage());
                extras.putString(ANIMAL_WIKI, animal.getWiki());
                intent.putExtras(extras);
                v.getContext().startActivity(intent);
            }
        });

        Picasso.get()
                .load(animal.getImage())
                .into(animalImageView);

    }
}
