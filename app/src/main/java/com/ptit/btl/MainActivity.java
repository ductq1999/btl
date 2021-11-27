package com.ptit.btl;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        Button btn1  = findViewById(R.id.btn1);

        btn1.setOnClickListener(v -> {
            startActivity(new Intent(this, HomeActivity.class));
        });

        Button btn2  = findViewById(R.id.btn2);

        btn2.setOnClickListener(v -> {
            startActivity(new Intent(this, HomeHangActivity.class));
        });


    }
}