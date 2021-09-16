package com.example.android.android_me.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;


public class BodyBodyPartFragment extends Fragment {

    private static final String LOG_TAG ="BodyBodyPartFragment";
    private static final String ARRAY_LIST = "arrayList";
    private static final String ARRAY_LIST_INDEX = "arrayListIndex";
    private List<Integer> ImageIds;
    private int ImageIndex;

    public BodyBodyPartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e(LOG_TAG, "onCreateView: is being called " );
        if(savedInstanceState!=null){
            ImageIds = savedInstanceState.getIntegerArrayList(ARRAY_LIST);
            ImageIndex = savedInstanceState.getInt(ARRAY_LIST_INDEX);
        }
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_body_body_part, container, false);
        final ImageView imageView = view.findViewById(R.id.body_image_view);
        if(ImageIds!=null){
            imageView.setImageResource(ImageIds.get(ImageIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(ImageIndex< ImageIds.size()-1){
                        ImageIndex++;
                        imageView.setImageResource(ImageIds.get(ImageIndex));
                    }
                    else{
                        ImageIndex =0;
                        imageView.setImageResource(ImageIds.get(ImageIndex));
                    }
                }
            });
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(ARRAY_LIST, (ArrayList<Integer>) ImageIds);
        outState.putInt(ARRAY_LIST_INDEX,ImageIndex);
    }

}