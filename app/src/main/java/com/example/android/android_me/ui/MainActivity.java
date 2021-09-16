package com.example.android.android_me.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {
    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MasterListFragment masterListFragment = new MasterListFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.master_list_fragment, masterListFragment)
                .commit();
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Item position: " + position, Toast.LENGTH_SHORT).show();
        int bodyPart = position / 12;
        int indexPostion = position-bodyPart*12;
        switch (bodyPart) {
            case 0:
                headIndex = indexPostion;
                break;
            case 1:
                bodyIndex = indexPostion;
                break;
            case 2:
                legIndex = indexPostion;
                break;
            default:
                break;
        }
        Bundle b = new Bundle();
        b.putInt("headIndex",headIndex);
        b.putInt("bodyIndex",bodyIndex);
        b.putInt("legIndex",legIndex);

        Button button = findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AndroidMeActivity.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}