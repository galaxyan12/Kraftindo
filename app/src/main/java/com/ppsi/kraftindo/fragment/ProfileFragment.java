package com.ppsi.kraftindo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.ppsi.kraftindo.EditActivity;
import com.ppsi.kraftindo.LoginActivity;
import com.ppsi.kraftindo.R;
import com.ppsi.kraftindo.RegisterActivity;

public class ProfileFragment extends Fragment {

    public static String resultNama = "Kuay Rai Kub";
    public static String resultEmail = "kuayraikub@rocketmail.com";
    public static String resultPhonumb = "+84175947781";
    public static String resultAddress = "Nguyen Thau Hoc Street, Chao Onh Lang War, District 1, Vietnam";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        TextView tv_NamaValue = v.findViewById(R.id.profile_nama_value);
        TextView tv_EmailValue = v.findViewById(R.id.profile_email_value);
        TextView tv_PhonumbValue = v.findViewById(R.id.profile_phonumb_value);
        TextView tv_AdressValue = v.findViewById(R.id.profile_address_value);

        tv_NamaValue.setText(resultNama);
        tv_EmailValue.setText(resultEmail);
        tv_PhonumbValue.setText(resultPhonumb);
        tv_AdressValue.setText(resultAddress);

        CardView cardLogout = v.findViewById(R.id.profile_logout);
        cardLogout.setOnClickListener(v1 -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });
        CardView cartEdit = v.findViewById(R.id.profile_edit);
        cartEdit.setOnClickListener(v12 -> {
            Intent intent = new Intent(getActivity(), EditActivity.class);
            startActivity(intent);
        });
        return v;
    }
}
