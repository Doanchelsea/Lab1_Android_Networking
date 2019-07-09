package com.example.doannv.andoridnesw;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class B2L1Activity extends AppCompatActivity {
    private static int OK = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b2_l1);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(B2L1Activity.this,B1L1Activity.class);
                startActivity(intent);
                finish();
            }
        },OK);
    }
}
