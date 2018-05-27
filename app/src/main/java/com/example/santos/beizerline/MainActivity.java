package com.example.santos.beizerline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyView line = findViewById(R.id.mView);
        line.setStep(0.1f);
        line.setDrawInterval(1000);

        line.startAnim();
    }
}