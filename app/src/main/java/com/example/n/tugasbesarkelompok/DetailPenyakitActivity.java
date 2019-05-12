package com.example.n.tugasbesarkelompok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailPenyakitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penyakit);

        getIncomingIntent();
    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("Image_pic") && getIntent().hasExtra("Image_name")){

            String imagePic = getIntent().getStringExtra("Image_pic");
            String imageName = getIntent().getStringExtra("Image_name");
            String imageDesc = getIntent().getStringExtra("Image_desc");

            setImage(imagePic, imageName, imageDesc);
        }
    }

    private void setImage(String imagePic, String imageName, String imageDesc){
        TextView mPenyakitName = findViewById(R.id.detail_judul);
        mPenyakitName.setText(imageName);

        TextView mPenyakitDesc = findViewById(R.id.detail_deskripsi);
        mPenyakitDesc.setText(imageDesc);

        ImageView mPenaykitPic = findViewById(R.id.detail_pic);
        Glide.with(this)
                .asBitmap()
                .load(imagePic)
                .into(mPenaykitPic);
    }
}
