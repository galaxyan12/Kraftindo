package com.ppsi.kraftindo.recycler;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ppsi.kraftindo.DetailActivity;
import com.ppsi.kraftindo.Produk;
import com.ppsi.kraftindo.R;

import java.util.ArrayList;

public class ProdukAdapter extends RecyclerView.Adapter<ProdukAdapter.ProdukViewHolder> {
    private ArrayList<Produk> listProduk;

    public ProdukAdapter(ArrayList<Produk> list) {
        this.listProduk = list;
    }

    @NonNull
    @Override
    public ProdukViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_produk, viewGroup, false);
        return new ProdukViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProdukViewHolder holder, final int position) {
        final Produk produk = listProduk.get(position);

        Glide.with(holder.itemView.getContext())
                .load(produk.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvName.setText(produk.getName());
        holder.tvDetail.setText(produk.getDetail());
        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent moveIntent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                moveIntent.putExtra(DetailActivity.PRODUK_NAME, produk.getName());
                moveIntent.putExtra(DetailActivity.PRODUK_DETAIL, produk.getDetail());
                moveIntent.putExtra("photo", listProduk.get(position).getPhoto());
                holder.itemView.getContext().startActivity(moveIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listProduk.size();
    }

    public class ProdukViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;
        Button btnBuy, btnDetail;

        ProdukViewHolder(View itemView){
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
            btnBuy = itemView.findViewById(R.id.btn_set_buy);
            btnDetail = itemView.findViewById(R.id.btn_set_detail);
        }
    }
}
