package com.example.n.tugasbesarkelompok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewCategory extends AppCompatActivity {

    private ArrayList<String> mImage = new ArrayList<>();
    private ArrayList<String> mName = new ArrayList<>();
    private ArrayList<String> mLatinName = new ArrayList<>();
    private ArrayList<String> mObatPenyakit = new ArrayList<>();
    private ArrayList<String> mDesc = new ArrayList<>();
    private ArrayList<String> mKhas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_category);

        getExtra();
    }

    private void getExtra() {

        Intent intent = getIntent();

        String test = intent.getStringExtra("item");

        switch (test){

            case "daftar_tanaman" : initDaftarTanamanRecyclerView();
            break;

            case "daftar_obat" : initDaftarObatRecyclerView();
            break;

            case "daftar_bahan_alami" : initDaftarBahanAlamiRecyclerView();
            break;

        }

    }

    private void initDaftarBahanAlamiRecyclerView() {

        mName = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.nama_bahan_alami)));
        mImage = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.foto_bahan_alami)));
//        mLatinName = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.latin_bahan_alami)));
        mDesc = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.desc_bahan_alami)));
        mKhas = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.khasiat_bahan_alami)));

        ListViewRecyclerViewAdapterDaftarBahanAlami adapter = new ListViewRecyclerViewAdapterDaftarBahanAlami(this,mImage,mName,mLatinName,mDesc,mKhas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView = findViewById(R.id.list_category_recycler_view);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void initDaftarObatRecyclerView() {

        mImage = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.foto_penyakit)));
        mName = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.nama_penyakit)));
        mDesc = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.desc_penyakit)));
        mObatPenyakit = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.obat_alami_penyakit)));


        ListViewRecyclerViewAdapterDaftarObat adapter = new ListViewRecyclerViewAdapterDaftarObat(this, mImage, mName, mDesc, mObatPenyakit );
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView = findViewById(R.id.list_category_recycler_view);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    private void initDaftarTanamanRecyclerView() {

        mImage = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.foto_tanaman)));
        mName = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.nama_tanaman)));
        mLatinName = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.latin_tanaman)));
        mDesc = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.desc_tanaman)));
        mKhas = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.khasiat)));


        ListViewRecyclerViewAdapterDaftarTanaman adapter = new ListViewRecyclerViewAdapterDaftarTanaman(this, mImage, mName, mLatinName, mDesc, mKhas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView = findViewById(R.id.list_category_recycler_view);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }


}
