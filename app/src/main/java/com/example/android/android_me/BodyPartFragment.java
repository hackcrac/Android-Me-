package com.example.android.android_me;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.data.AndroidImageAssets;


public class BodyPartFragment extends Fragment {


    public BodyPartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView imageView = view.findViewById(R.id.head_image_view);
        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));
        return view;
    }
}