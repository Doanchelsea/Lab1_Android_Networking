package com.example.doannv.andoridnesw;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

public class AsyncTaskRunner extends AsyncTask<String,String,String> {
     String resp;
    ProgressDialog progressDialog;
    TextView tvResult;
    EditText time;
    Context context;

    public AsyncTaskRunner(Context context, TextView tvResult, EditText time) {
        this.tvResult = tvResult;
        this.time = time;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context,"ProgressDiglog","Wait for"+
        time.getText().toString() +"seconds");
    }

    @Override
    protected String doInBackground(String... strings) {
        publishProgress("Sleeping...");
        try {
            int time = Integer.parseInt(strings[0]) * 1000;
            Thread.sleep(time);
            resp = "Slept for " + strings[0] + " seconds";
        } catch (InterruptedException e) {
            e.printStackTrace();
            resp  = e.getMessage();
        }
        return resp;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (progressDialog.isShowing()){
            progressDialog.dismiss();
        }
        tvResult.setText(s);
    }
}
