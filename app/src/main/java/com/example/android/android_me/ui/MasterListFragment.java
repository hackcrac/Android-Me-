package com.example.android.android_me.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class MasterListFragment extends Fragment {

    public MasterListFragment() {
        // Required empty public constructor
    }

    public interface OnImageClickListener{
        void onImageSelected (int position);
    }

    public interface GridWidthAndButton {
        int getSize();
        boolean hideButton();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GridWidthAndButton gridWidthAndButton = (GridWidthAndButton) getActivity();
        Button button = view.findViewById(R.id.next_button);
        OnImageClickListener imageClickListener = (OnImageClickListener) getActivity();
        myRecyclerViewAdapter adapter = new myRecyclerViewAdapter(AndroidImageAssets.getAll(),imageClickListener);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        if(gridWidthAndButton.hideButton()){
            button.setVisibility(View.GONE);
        }
        int width = gridWidthAndButton.getSize();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),width);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_master_list, container, false);
    }
}