package com.ppsi.kraftindo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DialogCustom extends AppCompatDialogFragment {
    private EditText editTulisan;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog, null);
        builder.setView(view)
                .setTitle("Custom")
                .setNegativeButton("Cancel", (dialog, which) -> {

                })
                .setPositiveButton("OK", (dialog, which) -> {

                });
        editTulisan = view.findViewById(R.id.tambah_tulisan);

        return builder.create();
    }
}
