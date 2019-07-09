package com.example.doannv.andoridnesw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Lab1Activity extends AppCompatActivity {
    Button btnbai1,btnbai2,btnbai3,btnbai4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        btnbai1 = findViewById(R.id.btnbai1);
        btnbai2 = findViewById(R.id.btnbai2);
        btnbai3 = findViewById(R.id.btnbai3);
        btnbai4 = findViewById(R.id.btnbai4);
        btnbai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab1Activity.this,B1L1SActivity.class);
                startActivity(intent);
            }
        });
        btnbai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab1Activity.this,B2L1Activity.class);
                startActivity(intent);
            }
        });
        btnbai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab1Activity.this,Bai3Activity.class);
                startActivity(intent);
            }
        });
        btnbai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Lab1Activity.this,Bai4Activity.class);
                startActivity(intent);
            }
        });
    }
}
