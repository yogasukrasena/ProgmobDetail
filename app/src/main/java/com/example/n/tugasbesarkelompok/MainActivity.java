package com.example.n.tugasbesarkelompok;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.takusemba.multisnaprecyclerview.MultiSnapRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> mTanamanName = new ArrayList<>();
    private ArrayList<String> mTanamanPic =  new ArrayList<>();
    private ArrayList<String> mTanamanDesc =  new ArrayList<>();
    private ArrayList<String> mTanamanLat =  new ArrayList<>();
    private ArrayList<String> mTanamanKhasiat =  new ArrayList<>();

    private  ArrayList<String> mPenyakitName = new ArrayList<>();
    private  ArrayList<String> mPenyakitPic = new ArrayList<>();
    private  ArrayList<String> mPenyakitDesc = new ArrayList<>();

    private  ArrayList<String> mBahanName = new ArrayList<>();
    private  ArrayList<String> mBahanPic = new ArrayList<>();
    private  ArrayList<String> mBahanDesc = new ArrayList<>();
    private  ArrayList<String> mBahanLat = new ArrayList<>();
    private  ArrayList<String> mBahanKhasiat = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getImages();
        MenuListener();
    }


    private void MenuListener(){

        CardView menu_daftar_tanaman = findViewById(R.id.daftar_tanaman);
        menu_daftar_tanaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Daftar Tanaman Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        CardView menu_daftar_obat = findViewById(R.id.daftar_obat);
        menu_daftar_obat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Daftar Obat Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        CardView menu_bahan_alami = findViewById(R.id.bahan_alami);
        menu_bahan_alami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Bahan Alami Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getImages(){

        mTanamanName = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.nama_tanaman)));
        mTanamanPic = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.foto_tanaman)));
        mTanamanDesc = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.desc_tanaman)));
        mTanamanLat = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.latin_tanaman)));
        mTanamanKhasiat = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.khasiat)));

        mPenyakitName = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.nama_penyakit)));
        mPenyakitPic = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.foto_penyakit)));
        mPenyakitDesc = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.desc_penyakit)));

        mBahanName = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.nama_bahan_alami)));
        mBahanPic = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.foto_bahan_alami)));
        mBahanLat = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.latin_bahan_alami)));
        mBahanDesc = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.desc_bahan_alami)));
        mBahanKhasiat = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.khasiat_bahan_alami)));


        ImageView header_pic = (ImageView) findViewById(R.id.header_pic);
        String header_pic_url = "https://guardian.ng/wp-content/uploads/2016/10/Herbal-Medicine-MX-680x340-1440545288.jpg" ;
        Glide.with(this)
                .asBitmap()
                .load(header_pic_url)
                .into(header_pic);

        initFirstRecyclerView();
        initSecondRecyclerView();
        initThirdRecyclerView();
    }

    private void initFirstRecyclerView() {

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mTanamanName, mTanamanPic, mTanamanDesc, mTanamanLat, mTanamanKhasiat, 5);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        MultiSnapRecyclerView recyclerView = findViewById(R.id.first_recycler_view);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void initSecondRecyclerView() {

        RecyclerViewAdapterDua adapter = new RecyclerViewAdapterDua(this, mPenyakitName, mPenyakitPic, mPenyakitDesc, 5);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        MultiSnapRecyclerView recyclerView = findViewById(R.id.second_recycler_view);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void initThirdRecyclerView() {

        RecyclerViewAdapterTiga adapter = new RecyclerViewAdapterTiga(this, mBahanName, mBahanPic, mBahanDesc, mBahanKhasiat, mBahanLat, 5);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        MultiSnapRecyclerView recyclerView = findViewById(R.id.third_recycler_view);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }


}


