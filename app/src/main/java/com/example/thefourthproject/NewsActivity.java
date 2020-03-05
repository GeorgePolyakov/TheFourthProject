package com.example.thefourthproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements ProductsRecycleAdapter.OnItemCustomClickListener {

    RecyclerView recyclerView;
    List<ProductModel> productModelList = new ArrayList<>();
    Pair[] pairs;
    int[] names = {R.drawable.clock, R.drawable.chair, R.drawable.table, R.drawable.cupboard, R.drawable.vase};
    ProductsRecycleAdapter productsRecycleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        recyclerView = findViewById(R.id.recyclerview);
        this.getSupportActionBar().setTitle("");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        for (int s : names) {
            ProductModel productModel = new ProductModel(s);
            productModelList.add(productModel);
        }
        productsRecycleAdapter = new ProductsRecycleAdapter(productModelList, this);
        recyclerView.setAdapter(productsRecycleAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemClicked(int position, ImageView ivLogo) {
        List<Pair<View, String>> listOfViews = new ArrayList<>();
        listOfViews.add(Pair.create((View) ivLogo, "ivLogo"));
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(
                NewsActivity.this, listOfViews.toArray(new android.util.Pair[]{})).toBundle();
        int drawableId = productsRecycleAdapter.getItem(position);
        Intent intent = new Intent(NewsActivity.this, ProductActivity.class);
        Log.i("myTag", ivLogo.getId() + "");
        intent.putExtra("logo", drawableId);
        startActivity(intent, bundle);
    }
}
