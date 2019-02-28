package com.example.unit_04_assessment;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.unit_04_assessment.frag.DetailFragment;

import static com.example.unit_04_assessment.view.AnimalViewHolder.ANIMAL_IMAGE;
import static com.example.unit_04_assessment.view.AnimalViewHolder.ANIMAL_NAME;
import static com.example.unit_04_assessment.view.AnimalViewHolder.ANIMAL_WIKI;

public class SecondActivity extends AppCompatActivity implements OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        assert extras != null;

        DetailFragment detailFragment = new DetailFragment().newInstance(extras);
        detailFragment.setArguments(extras);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, detailFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onFragmentInteraction(String website) {
        Uri uri = Uri.parse(website);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
