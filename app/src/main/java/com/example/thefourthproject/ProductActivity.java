package com.example.thefourthproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductActivity extends AppCompatActivity {

    private TextView tvUser;
    private ImageView ivLogo;
    private int logo;
    private Resources res;
    private String product;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        tvUser = findViewById(R.id.selectedUser);
        logo = getIntent().getIntExtra("logo", 0);
        ivLogo = findViewById(R.id.imageView2);
        ivLogo.setImageResource(logo);
        ivLogo.setTransitionName("ivLogo");
        if(logo==R.drawable.vase) {
            Toast.makeText(this, "Обычное Toast сообщение",
                    Toast.LENGTH_SHORT).show();
        }
        setDescription();
    }

    public void setDescription()
    {
        res = tvUser.getContext().getResources();
        switch (logo) {
            case (R.drawable.clock):
                tvUser.setText(res.getString(R.string.wall_clock_description));
                break;
            case (R.drawable.chair):
                tvUser.setText(res.getString(R.string.chair_description));
                break;
            case (R.drawable.table):
                tvUser.setText(res.getString(R.string.table_description));
                break;
            case (R.drawable.cupboard):
                tvUser.setText(res.getString(R.string.cupboard_description));
                break;
            case (R.drawable.vase):
                tvUser.setText(res.getString(R.string.vase_description));
                break;
            default:
                Log.i("myTag", "Intent Failure");
                break;
        }

    }
}