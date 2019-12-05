package com.ppsi.kraftindo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ppsi.kraftindo.fragment.ProfileFragment;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        CircleImageView editPickPhoto = findViewById(R.id.circle_profile_edit);
        editPickPhoto.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
            intent.setType("image/*");
            startActivityForResult(intent, 1);
        });

        EditText editNama = findViewById(R.id.edit_nama);
        EditText editEmail = findViewById(R.id.edit_email);
        EditText editPhoneNumber = findViewById(R.id.edit_handphone);
        EditText editAddress = findViewById(R.id.edit_alamat);

        Button btnKonfirmasi = findViewById(R.id.btn_konfirmasi_edit);
        btnKonfirmasi.setOnClickListener(v -> {

            ProfileFragment.resultNama = editNama.getText().toString();
            ProfileFragment.resultEmail = editEmail.getText().toString();
            ProfileFragment.resultPhonumb = editPhoneNumber.getText().toString();
            ProfileFragment.resultAddress = editAddress.getText().toString();

            final ProgressDialog progressDialog = new ProgressDialog(EditActivity.this, R.style.AppTheme_Dark_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Editing...");
            progressDialog.show();

            new android.os.Handler().postDelayed(
                    () -> {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        progressDialog.dismiss();
                    }, 3000);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {

            CircleImageView editPickPhoto = findViewById(R.id.circle_profile_edit);

            List<Bitmap> bitmaps = new ArrayList<>();

            ClipData clipData = data.getClipData();

            if (clipData != null) {
                for (int i = 0; i < clipData.getItemCount(); i++) {
                    Uri imageUri = clipData.getItemAt(i).getUri();
                    try {
                        InputStream is = getContentResolver().openInputStream(imageUri);
                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        bitmaps.add(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                Uri imageUri = data.getData();
                try {
                    InputStream is = getContentResolver().openInputStream(imageUri);

                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    bitmaps.add(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            new Thread(() -> {
                for (Bitmap b : bitmaps) {
                    runOnUiThread(() -> {
                        editPickPhoto.setImageBitmap(b);
                    });
                }
            }).start();
        }
    }
}
