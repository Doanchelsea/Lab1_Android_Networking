package com.example.doannv.andoridnesw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai4Activity extends AppCompatActivity {
    private EditText edText;
    private Button btnText;
    private TextView tvText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        edText = (EditText) findViewById(R.id.edText);
        btnText = (Button) findViewById(R.id.btnText);
        tvText = (TextView) findViewById(R.id.tvText);
        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnText:
                        AsyncTaskRunner asyncTaskRunner = new AsyncTaskRunner(Bai4Activity.this,tvText,edText);
                        String spleetime = edText.getText().toString();
                        asyncTaskRunner.execute(spleetime);
                        break;
                }
            }
        });
    }
}
