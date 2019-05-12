package com.example.n.tugasbesarkelompok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailObatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_obat);

        getIncomingIntent();
    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("Image_pic") && getIntent().hasExtra("Image_name")){

            String imagePic = getIntent().getStringExtra("Image_pic");
            String imageName = getIntent().getStringExtra("Image_name");
            String imageDesc = getIntent().getStringExtra("Image_desc");
            String imageLat = getIntent().getStringExtra("Image_lat");
            String imageKhas = getIntent().getStringExtra("Image_khas");

            setImage(imagePic, imageName, imageDesc, imageLat, imageKhas);
        }
    }

    private void setImage(String imagePic, String imageName, String imageDesc, String imageLat, String imageKhas){

        TextView mTanamanNama = findViewById(R.id.detail_judul);
        mTanamanNama.setText(imageName);

        ImageView mTanamanPic = findViewById(R.id.detail_pic);
        Glide.with(this)
                .asBitmap()
                .load(imagePic)
                .into(mTanamanPic);

        TextView mTanamanDesc = findViewById(R.id.detail_deskripsi);
        mTanamanDesc.setText(imageDesc);

        TextView mTanamanLat = findViewById(R.id.detail_nama_latin);
        mTanamanLat.setText(imageLat);

        TextView mTanamanKhasiat = findViewById(R.id.khasiat_satu);
        mTanamanKhasiat.setText(imageKhas);
    }
}
