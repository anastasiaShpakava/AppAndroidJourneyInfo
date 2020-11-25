package com.company.journeyInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.company.journeyInfo.ui.MainPageFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragmentContainer, new MainPageFragment())
                    .commit();
        }
    }
}
