package com.example.unit_04_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unit_04_assessment.controller.AnimalAdapter;
import com.example.unit_04_assessment.model.Animal;
import com.example.unit_04_assessment.model.AnimalList;
import com.example.unit_04_assessment.network.AnimalService;
import com.example.unit_04_assessment.network.RetrofitSingleton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        retrofit = new RetrofitSingleton().getInstance();
        AnimalService animalService = retrofit.create(AnimalService.class);
        Call<AnimalList> animalListCall = animalService.getAnimalList();
        animalListCall.enqueue(new Callback<AnimalList>() {
                    @Override
                    public void onResponse(Call<AnimalList> call, Response<AnimalList> response) {
                        Log.d(TAG, response.body().getAnimalList().get(0).getAnimal());
                        List<Animal> animals = response.body().getAnimalList();
                        recyclerView.setAdapter(new AnimalAdapter(animals));
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    }

                    @Override
                    public void onFailure(Call<AnimalList> call, Throwable t) {
                        Log.d(TAG, "onFailure: something went wrong");
                    }
                });
    }
}
