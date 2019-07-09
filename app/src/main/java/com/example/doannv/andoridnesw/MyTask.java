package com.example.doannv.andoridnesw;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MyTask extends AsyncTask<String,Long,String> {

    public void setOnLoadCompletedListenner(OnLoadCompletedListenner onLoadCompletedListenner) {
        this.onLoadCompletedListenner = onLoadCompletedListenner;
    }

    public interface OnLoadCompletedListenner{
        void onFinished(String result);
    }
    private OnLoadCompletedListenner onLoadCompletedListenner;
    private TextView textView;

    public MyTask(TextView textView) {
        this.textView = textView;
    }
    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url =   new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            String data = "";

            while (scanner.hasNext()){
                data = scanner.nextLine() + data;
            }
            return data;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    // tuong tac voi giao dien
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
        onLoadCompletedListenner.onFinished(s);
    }
}
