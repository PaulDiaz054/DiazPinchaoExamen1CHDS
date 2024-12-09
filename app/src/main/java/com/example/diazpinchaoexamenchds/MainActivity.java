package com.example.diazpinchaoexamenchds;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    TextView tvBody;
    Button btnObtener;

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

    public void WebService() {
        String url = "http://192.168.137.163:3000/Diaz";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(() -> tvBody.setText("Error al conectar con el servidor: " + e.getMessage()));
            }

            @Override
            public void onResponse(Call call, Response response) {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) {
                        throw new IOException("Código de error: " + response.code());
                    }
                    String respuesta = responseBody.string();
                    runOnUiThread(() -> {
                        tvBody.setText(respuesta);
                        Log.i("Response", respuesta);
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    runOnUiThread(() -> tvBody.setText("Error al procesar la respuesta: " + e.getMessage()));
                }
            }
        });
    }
}
