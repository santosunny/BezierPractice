package com.example.santos.beizerline;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MyHighView line = findViewById(R.id.mView2);

        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(300, 900));
        points.add(new Point(600, 100));
        points.add(new Point(900, 800));

        line.setPoints(points);

        line.setStep(0.1f);
        line.setDrawInterval(1000);

        line.startAnim();
    }
}
