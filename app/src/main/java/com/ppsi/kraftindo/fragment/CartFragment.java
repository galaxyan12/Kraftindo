package com.ppsi.kraftindo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ppsi.kraftindo.R;

public class CartFragment extends Fragment {

    public static String cartNamaProduk = "";
    public static String cartHargaProduk = "";
    int cartCounter = 0;
    int totalResult = 0;
    int preTotal = Integer.parseInt(cartHargaProduk);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cart, container, false);
        TextView tv_cartName = v.findViewById(R.id.cart_item_name);
        TextView tv_cartPrice = v.findViewById(R.id.cart_item_price);
        TextView tv_cartCounter = v.findViewById(R.id.cart_item_counter);
        TextView tv_Total = v.findViewById(R.id.tv_total);
        ImageView iv_cartPlus = v.findViewById(R.id.cart_item_plus);
        ImageView iv_cartMin = v.findViewById(R.id.cart_item_min);
        ImageView iv_cartTrash = v.findViewById(R.id.cart_item_trash);

        tv_cartCounter.setText("0");
        tv_cartName.setText(cartNamaProduk);
        tv_cartPrice.setText(cartHargaProduk);

        iv_cartPlus.setOnClickListener(v1 -> {
            cartCounter = cartCounter + 1;
            tv_cartCounter.setText(String.valueOf(cartCounter));
            totalResult = preTotal * cartCounter;
            tv_Total.setText(String.valueOf(totalResult));
        });

        iv_cartMin.setOnClickListener(v1 -> {
            cartCounter = cartCounter - 1;
            tv_cartCounter.setText(String.valueOf(cartCounter));
            if (cartCounter < 0) {
                cartCounter = 0;
                tv_cartCounter.setText(String.valueOf(cartCounter));
                totalResult = preTotal * cartCounter;
                tv_Total.setText(String.valueOf(totalResult));
            }
        });

        iv_cartTrash.setOnClickListener(v12 -> {
            cartCounter = 0;
            preTotal = 0;
            totalResult = 0;
            tv_cartCounter.setText("0");
            tv_cartName.setText("");
            tv_cartPrice.setText("Rp. 0");
            tv_Total.setText("Rp. 0");
        });

        return v;
    }
}
