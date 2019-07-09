package com.example.doannv.andoridnesw;

import android.app.ProgressDialog;
import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class B1L1Activity extends AppCompatActivity {
    ProgressDialog progressDialog;
    private ImageView imgBai1;
    private TextView tvBai1;
    String url = "http://thuvienanhdep.net/wp-content/uploads/2016/10/hinh-anh-dep-nhat-the-gioi-ve-su-hoan-hao-khien-moi-nguoi-ngo-ngang2.jpg";
    Bitmap bitmap = null;
    private Button btnLoadMore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b1_l1);
        imgBai1 = (ImageView) findViewById(R.id.imgBai1);
        tvBai1 = (TextView) findViewById(R.id.tvBai1);
        btnLoadMore = (Button) findViewById(R.id.btnLoadMore);
        btnLoadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = ProgressDialog.show(B1L1Activity.this,"","DowLoading...");

                         Runnable runnable = new Runnable() {
                             @Override
                             public void run() {
                                 bitmap = downloadBitmap(url);
                                 Message message = messageHandle.obtainMessage();
                                 Bundle bundle = new Bundle();
                                 String threadMessage = "Image download";
                                 bundle.putString("message", threadMessage);
                                 message.setData(bundle);
                                 messageHandle.sendMessage(message);
                             }
                         };
                         Thread thread = new Thread(runnable);
                         thread.start();

                     }
        });
    }
    private Handler messageHandle = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Bundle bundle = message.getData();
            String messageb = bundle.getString("message");
            tvBai1.setText(messageb);
            imgBai1.setImageBitmap(bitmap);
            progressDialog.dismiss();
        }

    };




    private Bitmap downloadBitmap(String link) {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
