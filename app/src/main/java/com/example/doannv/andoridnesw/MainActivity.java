package com.example.doannv.andoridnesw;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tvText);
        MyTask myTask = new MyTask(textView);
        myTask.execute("http://docbao.vn");
        MyTask.OnLoadCompletedListenner onLoadCompletedListenner = new MyTask.OnLoadCompletedListenner() {
            @Override
            public void onFinished(String result) {
                textView.setText(result);
            }
        };
        myTask.setOnLoadCompletedListenner(onLoadCompletedListenner);
    }
}


