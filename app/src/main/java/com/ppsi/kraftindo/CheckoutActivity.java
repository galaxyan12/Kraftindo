package com.ppsi.kraftindo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Button btnUploadNext = findViewById(R.id.upload_bukti_pembayaran);
        btnUploadNext.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), BuktiActivity.class);
            startActivity(intent);
        });
    }
}
