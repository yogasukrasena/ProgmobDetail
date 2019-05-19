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

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class RecyclerViewAdapterTiga extends RecyclerView.Adapter<RecyclerViewAdapterTiga.ViewHolder> {

    private final int count;
    private ArrayList<String> mBahanName = new ArrayList<>();
    private ArrayList<String> mBahanPic = new ArrayList<>();
    private ArrayList<String> mBahanDesc = new ArrayList<>();
//    private ArrayList<String> mBahanLat = new ArrayList<>();
    private ArrayList<String> mBahanKhasiat = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapterTiga(Context mContext, ArrayList<String> mBahanName,
                                   ArrayList<String> mBahanPic, ArrayList<String> mBahanDesc,
                                   ArrayList<String> mBahanKhasiat, int count) {
        this.mBahanName = mBahanName;
        this.mBahanPic = mBahanPic;
        this.mBahanDesc = mBahanDesc;
//        this.mBahanLat = mTanamanLat;
        this.mBahanKhasiat = mBahanKhasiat;
        this.mContext = mContext;
        this.count = count;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterTiga.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterTiga.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called : "+ mBahanName.get(position));

        Glide.with(mContext)
                .asBitmap()
                .load(mBahanPic.get(position))
                .into(holder.image);


        holder.name.setText(mBahanName.get(position));

        holder.CardViewparent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mBahanName.get(position), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, DetailObatActivity.class);
                intent.putExtra("Image_name", mBahanName.get(position));
                intent.putExtra("Image_pic", mBahanPic.get(position));
                intent.putExtra("Image_desc", mBahanDesc.get(position));
//                intent.putExtra("Image_lat", mBahanLat.get(position));
                intent.putExtra("Image_khas", mBahanKhasiat.get(position));
                mContext.startActivities(new Intent[]{intent});
            }
        });
    }

    @Override
    public int getItemCount() {
        return count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
