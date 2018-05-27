package com.example.santos.beizerline;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Navagator extends AppCompatActivity implements View.OnClickListener {

    Button btn2;
    Button btnHigh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navagator);

        btn2 = findViewById(R.id.btn2);
        btnHigh = findViewById(R.id.btnHigh);

        btn2.setOnClickListener(this);
        btnHigh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = null;

        switch (v.getId()) {
            case R.id.btn2:
                intent = new Intent(Navagator.this, MainActivity.class);
                break;
            case R.id.btnHigh:
                intent = new Intent(Navagator.this, MainActivity2.class);
                break;
        }

        startActivity(intent);

    }
}
