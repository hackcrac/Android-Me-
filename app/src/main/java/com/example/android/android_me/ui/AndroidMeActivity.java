/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {
    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        if(savedInstanceState==null){
            Intent intent = getIntent();
            if(intent!=null){
                Bundle b = intent.getExtras();
                headIndex = b.getInt("headIndex");
                bodyIndex = b.getInt("bodyIndex");
                legIndex = b.getInt("legIndex");
            }
            Log.e("values of headIndex:",headIndex+"");
            Log.e("values of bodyIndex:",bodyIndex+"");
            Log.e("values of legIndex:",legIndex+"");

            HeadBodyPartFragment headBodyPartFragment = new HeadBodyPartFragment();
            BodyBodyPartFragment bodyBodyPartFragment = new BodyBodyPartFragment();
            LegBodyPartFragment legBodyPartFragment = new LegBodyPartFragment();

            headBodyPartFragment.setImageIds(AndroidImageAssets.getHeads());
            bodyBodyPartFragment.setImageIds(AndroidImageAssets.getBodies());
            legBodyPartFragment.setImageIds(AndroidImageAssets.getLegs());

            headBodyPartFragment.setImageIndex(headIndex);
            bodyBodyPartFragment.setImageIndex(bodyIndex);
            legBodyPartFragment.setImageIndex(legIndex);

            FragmentManager fragmentManager = getSupportFragmentManager();

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
}
