package com.example.doannv.andoridnesw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class B1L1SActivity extends AppCompatActivity {
    private ImageView imgBai1;
    private TextView tvBai1;
    private Button btnLoadMore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b1_l1_s);
        imgBai1 = (ImageView) findViewById(R.id.imgBai1);
        tvBai1 = (TextView) findViewById(R.id.tvBai1);
        btnLoadMore = (Button) findViewById(R.id.btnLoadMore);
        btnLoadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                            final Bitmap bitmap  = loadImage("http://thuvienanhdep.net/wp-content/uploads/2016/10/hinh-anh-dep-nhat-the-gioi-ve-su-hoan-hao-khien-moi-nguoi-ngo-ngang2.jpg");
                            imgBai1.post(new Runnable() {
                                @Override
                                public void run() {
                               tvBai1.setText("Image Downloaded");
                               imgBai1.setImageBitmap(bitmap);
                                }
                            });
                    }
                });
                thread.start();
            }
        });

    }
    private Bitmap loadImage(String link){
        URL url;
        Bitmap bitmap = null;
        try {
            url = new URL(link);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
