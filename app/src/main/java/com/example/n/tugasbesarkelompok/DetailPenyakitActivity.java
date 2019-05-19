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
            String obatPenyakit = getIntent().getStringExtra("image_obat_penyakit");

            setImage(imagePic, imageName, imageDesc, obatPenyakit);
        }
    }

    private void setImage(String imagePic, String imageName, String imageDesc, String obatPenyakit){
        TextView mPenyakitName = findViewById(R.id.detail_judul);
        mPenyakitName.setText(imageName);

        TextView mPenyakitDesc = findViewById(R.id.detail_deskripsi);
        mPenyakitDesc.setText(imageDesc);

        TextView mObatPenyakit = findViewById(R.id.obat_alami_penyakit);
        mObatPenyakit.setText(obatPenyakit);

        ImageView mPenaykitPic = findViewById(R.id.detail_pic);
        Glide.with(this)
                .asBitmap()
                .load(imagePic)
                .into(mPenaykitPic);
    }
}
