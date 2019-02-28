package com.example.unit_04_assessment.frag;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unit_04_assessment.OnFragmentInteractionListener;
import com.example.unit_04_assessment.R;
import com.squareup.picasso.Picasso;

import static com.example.unit_04_assessment.view.AnimalViewHolder.ANIMAL_IMAGE;
import static com.example.unit_04_assessment.view.AnimalViewHolder.ANIMAL_NAME;
import static com.example.unit_04_assessment.view.AnimalViewHolder.ANIMAL_WIKI;

public class DetailFragment extends Fragment {
    private TextView animalTextView;
    private ImageView animalImageView;
    private Button button;
    private OnFragmentInteractionListener listener;


    public DetailFragment() {}

        public DetailFragment newInstance(Bundle args) {
        return new DetailFragment();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new ClassCastException("Must include OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        animalTextView = view.findViewById(R.id.frag_animal_name);
        animalImageView = view.findViewById(R.id.frag_image_view);
        button = view.findViewById(R.id.frag_button);

        final Bundle args = getArguments();
        assert args != null;

        animalTextView.setText(args.getString(ANIMAL_NAME));

        Picasso.get()
                .load(args.getString(ANIMAL_IMAGE))
                .into(animalImageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onFragmentInteraction(args.getString(ANIMAL_WIKI));
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
