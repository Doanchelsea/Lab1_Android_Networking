package com.example.doannv.andoridnesw;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadImageTask extends AsyncTask<String,Void,Bitmap> {
   private Listener mlistener;
   private ProgressDialog progressDialog;
     public LoadImageTask(Listener listener, Context context){
         mlistener = listener;
         progressDialog = new ProgressDialog(context);
     }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog.setMessage("Downloading image...");
        progressDialog.show();
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            return BitmapFactory.decodeStream((InputStream)new URL(strings[0]).getContent());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        if (bitmap != null){
            mlistener.onImgaLoad(bitmap);
        }else {
            mlistener.onError();
        }
    }
}
