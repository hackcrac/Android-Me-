package com.example.android.android_me.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.android_me.R;

import java.util.List;

public class myRecyclerViewAdapter extends RecyclerView.Adapter<myRecyclerViewAdapter.ViewHolder> {
    private List<Integer> list;
    private ImageView imageView;
    private final MasterListFragment.OnImageClickListener imageClickListener;

    public myRecyclerViewAdapter(List<Integer> list, MasterListFragment.OnImageClickListener listener) {
        this.list = list;
        imageClickListener = listener;
    }

    @NonNull
    @Override
    public myRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myRecyclerViewAdapter.ViewHolder holder, int position) {
        imageView.setImageResource(list.get(position));
        final int pos = position;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageClickListener.onImageSelected(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
