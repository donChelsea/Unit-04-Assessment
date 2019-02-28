package com.example.unit_04_assessment.network;

import com.example.unit_04_assessment.model.AnimalList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AnimalService {
    @GET("JDVila/storybook/master/echinoderms.json")
    Call<AnimalList> getAnimalList();
}
