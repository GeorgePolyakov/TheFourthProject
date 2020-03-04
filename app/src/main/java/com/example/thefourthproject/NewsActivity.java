package com.example.thefourthproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements UsersAdapter.OnItemCustomClickListener {

    RecyclerView recyclerView;
    List<UserModel> userModelList = new ArrayList<>();
    Pair[] pairs;
    int[] names = {R.drawable.clock, R.drawable.chair, R.drawable.table, R.drawable.cupboard, R.drawable.vase};
    UsersAdapter usersAdapter;

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
            UserModel userModel = new UserModel(s);
            userModelList.add(userModel);
        }
        usersAdapter = new UsersAdapter(userModelList, this);
        recyclerView.setAdapter(usersAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onItemClicked(int position, ImageView ivLogo) {
        List<Pair<View, String>> listOfViews = new ArrayList<>();
        listOfViews.add(Pair.create((View) ivLogo, "ivLogo"));
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(
                NewsActivity.this, listOfViews.toArray(new android.util.Pair[]{})).toBundle();
        int drawableId = usersAdapter.getItem(position);
        Intent intent = new Intent(NewsActivity.this, ProductActivity.class);
        Log.i("myTag", ivLogo.getId() + "");
        intent.putExtra("logo", drawableId);
        startActivity(intent, bundle);
    }
}
