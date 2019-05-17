package com.example.n.tugasbesarkelompok;

import android.content.Context;
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

public class ListViewRecyclerViewAdapter extends RecyclerView.Adapter<ListViewRecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<String> mImages;
    private ArrayList<String> mName;
    private ArrayList<String> mLatinName;

    public ListViewRecyclerViewAdapter(Context mContext, ArrayList mImages, ArrayList mName, ArrayList mLatinName) {
        this.mContext = mContext;
        this.mImages = mImages;
        this.mName = mName;
        this.mLatinName = mLatinName;
    }

    @NonNull
    @Override
    public ListViewRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_latin,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewRecyclerViewAdapter.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: " + mName.get(position));

        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .apply(new RequestOptions().override(600, 600))
                .into(holder.image);

        holder.name.setText(mName.get(position));


        holder.latinName.setText(mLatinName.get(position));


        holder.cardViewParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: " + mName.get(position));
                Toast.makeText(mContext, "Clicked : " + mName.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name,latinName;
        CardView cardViewParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.pic_category);
            name = itemView.findViewById(R.id.judul_category);
            latinName = itemView.findViewById(R.id.nama_latin_category);
            cardViewParent = itemView.findViewById(R.id.card_view_list_parent);

        }
    }
}
