package com.example.biblecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
    public void Onclick(View v){
        Intent intent=new Intent(HomeActivity.this,MainActivity.class);
        startActivity(intent);
    }
    public void Onclick2(View v){
        Intent intent=new Intent(HomeActivity.this,ChartActivity.class);
        startActivity(intent);
    }
}