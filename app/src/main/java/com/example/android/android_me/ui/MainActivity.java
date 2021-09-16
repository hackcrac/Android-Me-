package com.example.android.android_me.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MasterListFragment masterListFragment = new MasterListFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.master_list_fragment,masterListFragment)
                .commit();
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this,"Item position: "+position,Toast.LENGTH_SHORT).show();
    }
}