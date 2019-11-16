package com.ppsi.kraftindo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ppsi.kraftindo.Produk;
import com.ppsi.kraftindo.ProdukData;
import com.ppsi.kraftindo.R;
import com.ppsi.kraftindo.recycler.ProdukAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView rvProduk;
    private ArrayList<Produk> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rvProduk = v.findViewById(R.id.rv_produk);
        rvProduk.setHasFixedSize(true);
        list.addAll(ProdukData.getListData());
        showRecyclerView();
        return v;
    }

    private void showRecyclerView() {
        rvProduk.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        ProdukAdapter produkAdapter = new ProdukAdapter(list);
        rvProduk.setAdapter(produkAdapter);
    }
}
