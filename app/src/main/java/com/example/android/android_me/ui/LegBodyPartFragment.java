package com.example.android.android_me.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.List;


public class LegBodyPartFragment extends Fragment {
    private static final String LOG_TAG ="LegBodyPartFragment";
    private List<Integer> ImageIds;
    private int ImageIndex;

    public LegBodyPartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leg_body_part, container, false);
        ImageView imageView = view.findViewById(R.id.leg_image_view);
        if(ImageIds!=null){
            imageView.setImageResource(ImageIds.get(ImageIndex));
        }
        else{
            Log.d(LOG_TAG,"This Fragment has a null list of image id's");
        }
        return view;
    }

    public void setImageIds(List<Integer> imageIds) {
        ImageIds = imageIds;
    }

    public void setImageIndex(int imageIndex) {
        ImageIndex = imageIndex;
    }
}