package com.example.android.android_me.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener, MasterListFragment.GridWidthAndButton {
    private int headIndex;
    private int bodyIndex;
    private int legIndex;
    private boolean twoSidePane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MasterListFragment masterListFragment = new MasterListFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.master_list_fragment, masterListFragment)
                .commit();

        if(findViewById(R.id.android_me_linear_layout)!=null){
            twoSidePane = true;

            if(savedInstanceState==null){
                HeadBodyPartFragment headBodyPartFragment = new HeadBodyPartFragment();
                BodyBodyPartFragment bodyBodyPartFragment = new BodyBodyPartFragment();
                LegBodyPartFragment legBodyPartFragment = new LegBodyPartFragment();

                headBodyPartFragment.setImageIds(AndroidImageAssets.getHeads());
                bodyBodyPartFragment.setImageIds(AndroidImageAssets.getBodies());
                legBodyPartFragment.setImageIds(AndroidImageAssets.getLegs());

                fragmentManager.beginTransaction().setReorderingAllowed(true)
                        .replace(R.id.head_container, headBodyPartFragment)
                        .commit();
                fragmentManager.beginTransaction().setReorderingAllowed(true)
                        .replace(R.id.body_container, bodyBodyPartFragment)
                        .commit();
                fragmentManager.beginTransaction().setReorderingAllowed(true)
                        .replace(R.id.leg_container,legBodyPartFragment)
                        .commit();
            }
        }
        else{
            twoSidePane = false;
        }
    }

    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Item position: " + position, Toast.LENGTH_SHORT).show();
        int bodyPart = position / 12;
        int indexPosition = position-bodyPart*12;
        if(twoSidePane){
            FragmentManager fragmentManager = getSupportFragmentManager();
            switch (bodyPart) {
                case 0:
                    headIndex = indexPosition;
                    HeadBodyPartFragment headFragment = new HeadBodyPartFragment();
                    headFragment.setImageIds(AndroidImageAssets.getHeads());
                    headFragment.setImageIndex(headIndex);
                    fragmentManager.beginTransaction().replace(R.id.head_container,headFragment).commit();
                    break;
                case 1:
                    bodyIndex = indexPosition;
                    BodyBodyPartFragment bodyFragment = new BodyBodyPartFragment();
                    bodyFragment.setImageIds(AndroidImageAssets.getBodies());
                    bodyFragment.setImageIndex(bodyIndex);
                    fragmentManager.beginTransaction().replace(R.id.body_container,bodyFragment).commit();
                    break;
                case 2:
                    legIndex = indexPosition;
                    LegBodyPartFragment legFragment = new LegBodyPartFragment();
                    legFragment.setImageIds(AndroidImageAssets.getLegs());
                    legFragment.setImageIndex(legIndex);
                    fragmentManager.beginTransaction().replace(R.id.leg_container,legFragment).commit();
                    break;
                default:
                    break;

            }
        }
        else{
            switch (bodyPart) {
                case 0:
                    headIndex = indexPosition;
                    break;
                case 1:
                    bodyIndex = indexPosition;
                    break;
                case 2:
                    legIndex = indexPosition;
                    break;
                default:
                    break;
            }
            Bundle b = new Bundle();
            b.putInt("headIndex",headIndex);
            b.putInt("bodyIndex",bodyIndex);
            b.putInt("legIndex",legIndex);
            Button button = findViewById(R.id.next_button);
            button.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this,AndroidMeActivity.class);
                intent.putExtras(b);
                startActivity(intent);
            });
        }
    }

    @Override
    public int getSize() {
        if(twoSidePane){
            return 2;
        }
        return 3;
    }

    @Override
    public boolean hideButton() {
        if(twoSidePane){
            return true;
        }
        return false;
    }
}