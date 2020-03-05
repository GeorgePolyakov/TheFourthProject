package com.example.thefourthproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CustomCircleView mCustomCircleView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCustomCircleView = findViewById(R.id.customView);
        mCustomCircleView.setOnClickListener(this);
        button = findViewById(R.id.buttonGoogleMap);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.buttonGoogleMap):
                Intent intent = new Intent(this, MapsActivity.class);
                startActivity(intent);
                break;
            case (R.id.customView):
                Intent intent1 = new Intent(this, NewsActivity.class);
                startActivity(intent1);
                break;
            default:
                Log.i("myTag", "We got error");
                break;
        }
    }
}
