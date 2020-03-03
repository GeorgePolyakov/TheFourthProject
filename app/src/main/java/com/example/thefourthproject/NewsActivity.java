package com.example.thefourthproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity implements View.OnClickListener, UsersAdapter.SelectedUser {

    Button button;
    ImageView imageView;
    RecyclerView recyclerView;
    List<UserModel> userModelList = new ArrayList<>();
    Pair[] pairs;
    int[] names = {R.drawable.clock,R.drawable.chair,R.drawable.table,R.drawable.cupboard,R.drawable.vase};
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recyclerview);
        this.getSupportActionBar().setTitle("");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        button.setOnClickListener(this);

        for(int s:names){
            UserModel userModel = new UserModel(s);
            userModelList.add(userModel);
        }
        usersAdapter = new UsersAdapter(userModelList,this);
        recyclerView.setAdapter(usersAdapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void selectedUser(UserModel userModel) {
        imageView =  findViewById(R.id.imageRecycle);

       // startActivity(new Intent(NewsActivity.this, ProductActivity.class).putExtra("data", userModel));
        Intent intent = new Intent(NewsActivity.this, ProductActivity.class);
        pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(imageView, "imageTransition");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pairs);
        startActivity(intent, options.toBundle());
        imageView = null;
    }

    @Override
    public void onClick(View v) {

    }
}
