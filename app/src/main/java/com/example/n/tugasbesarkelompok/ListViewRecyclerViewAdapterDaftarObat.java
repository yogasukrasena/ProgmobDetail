package com.example.n.tugasbesarkelompok;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class ListViewRecyclerViewAdapterDaftarObat extends RecyclerView.Adapter<ListViewRecyclerViewAdapterDaftarObat.ViewHolder>{

    private Context mContext;
    private ArrayList<String> mImages;
    private ArrayList<String> mName;
    private ArrayList<String> mDesc;
    private ArrayList<String> mObatPenyakit;

    public ListViewRecyclerViewAdapterDaftarObat(Context mContext, ArrayList<String> mImages, ArrayList<String> mName, ArrayList<String> mDesc,ArrayList<String> mObatPenyakit) {
        this.mContext = mContext;
        this.mImages = mImages;
        this.mName = mName;
        this.mDesc = mDesc;
        this.mObatPenyakit = mObatPenyakit;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_daftar_obat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: " + mName.get(position));

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .apply(new RequestOptions().override(600, 600))
                .into(holder.image);

        holder.name.setText(mName.get(position));

        holder.cardViewParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + mName.get(position));
                Toast.makeText(mContext, "Clicked : " + mName.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, DetailPenyakitActivity.class);
                intent.putExtra("Image_name", mName.get(position));
                intent.putExtra("Image_pic", mImages.get(position));
                intent.putExtra("Image_desc", mDesc.get(position));
                intent.putExtra("image_obat_penyakit", mObatPenyakit.get(position));
                mContext.startActivities(new Intent[]{intent});

            }
        });
    }

    @Override
    public int getItemCount() {
        return mName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        CardView cardViewParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.pic_list_daftar_obat);
            name = itemView.findViewById(R.id.judul_list_daftar_obat);
            cardViewParent = itemView.findViewById(R.id.card_view_list_daftar_obat_parent);
        }
    }
}
