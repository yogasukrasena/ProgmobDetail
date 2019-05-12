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
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final int count;
    private ArrayList<String> mTanamanName = new ArrayList<>();
    private ArrayList<String> mTanamanPic = new ArrayList<>();
    private ArrayList<String> mTanamanDesc = new ArrayList<>();
    private ArrayList<String> mTanamanLat = new ArrayList<>();
    private ArrayList<String> mTanamanKhasiat = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> obatNames, ArrayList<String> obatPics,
                               ArrayList<String> mDesc, ArrayList<String> mLat, ArrayList<String> mKhas, int count) {
        this.mTanamanName = obatNames;
        this.mTanamanPic = obatPics;
        this.mContext = mContext;
        this.mTanamanDesc = mDesc;
        this.mTanamanLat = mLat;
        this.mTanamanKhasiat = mKhas;
        this.count = count;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, final int position) {

        Log.d(TAG, "onBindViewHolder: called : "+ mTanamanName.get(position));

        Glide.with(mContext)
                .asBitmap()
                .load(mTanamanPic.get(position))
                .into(holder.image);


        holder.name.setText(mTanamanName.get(position));

        holder.CardViewparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mTanamanName.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, DetailObatActivity.class);
                intent.putExtra("Image_name", mTanamanName.get(position));
                intent.putExtra("Image_pic", mTanamanPic.get(position));
                intent.putExtra("Image_desc", mTanamanDesc.get(position));
                intent.putExtra("Image_lat", mTanamanLat.get(position));
                intent.putExtra("Image_khas", mTanamanKhasiat.get(position));
                mContext.startActivities(new Intent[]{intent});
            }
        });

    }

    @Override
    public int getItemCount() {
        return count;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        CardView CardViewparent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.top_obat_pic);
            name = itemView.findViewById(R.id.top_obat_name);
            CardViewparent = itemView.findViewById(R.id.card_view_parent);

        }
    }

}
