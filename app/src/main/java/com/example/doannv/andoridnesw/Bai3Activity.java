package com.example.doannv.andoridnesw;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Bai3Activity extends AppCompatActivity implements Listener {
    private ImageView imgBai1;
    private TextView tvBai1;
    private Button btnLoadMore;
    public static  final String URL = "http://thuvienanhdep.net/wp-content/uploads/2016/10/hinh-anh-dep-nhat-the-gioi-ve-su-hoan-hao-khien-moi-nguoi-ngo-ngang2.jpg";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        imgBai1 = (ImageView) findViewById(R.id.imgBai1);
        tvBai1 = (TextView) findViewById(R.id.tvBai1);
        btnLoadMore = (Button) findViewById(R.id.btnLoadMore);
        btnLoadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnLoadMore:
                        new LoadImageTask(  Bai3Activity.this,Bai3Activity.this).execute(URL);
                        break;
                }
            }
        });
    }

    @Override
    public void onImgaLoad(Bitmap bitmap) {
        imgBai1.setImageBitmap(bitmap);
        tvBai1.setText("Image Dowuload");
    }

    @Override
    public void onError() {
        tvBai1.setText("Error Dowuload image");
    }
}
