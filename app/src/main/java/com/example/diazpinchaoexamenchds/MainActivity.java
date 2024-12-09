package com.example.diazpinchaoexamenchds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvBody;
    Button btnObtener;
    String respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBody = findViewById(R.id.tvBody);
        btnObtener = findViewById(R.id.btnObtener);

        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebService();
            }
        });
    }

    public void WebService(){

    }
}