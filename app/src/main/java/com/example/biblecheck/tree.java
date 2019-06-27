package com.example.biblecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class tree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);

        ImageView imageView=findViewById(R.id.imageView);
        TextView textView=findViewById(R.id.textViewTree);

        Intent intent=getIntent();
        double percent=intent.getDoubleExtra("percent",-1);

        if(0<=percent&&percent<20){
            imageView.setImageResource(R.drawable.tree1);
            textView.setText("나무 1단계 성장 \n*읽은분량: "+percent);
        }
        else if(20<=percent&&percent<40){
            imageView.setImageResource(R.drawable.tree2);
            textView.setText("나무 2단계 성장 \n*읽은분량: "+percent);

        }
        else if(40<=percent&&percent<60){
            imageView.setImageResource(R.drawable.tree3);
            textView.setText("나무 3단계 성장 \n*읽은분량: "+percent);

        }
        else if(60<=percent&&percent<80){
            imageView.setImageResource(R.drawable.tree4);
            textView.setText("나무 4단계 성장 \n*읽은분량: "+percent);

        }
        else if(80<=percent&&percent<100){
            imageView.setImageResource(R.drawable.tree5);
            textView.setText("나무 5단계 성장 \n*읽은분량: "+percent);

        }
        else if(percent==100){
            imageView.setImageResource(R.drawable.end);
            textView.setText("나무 최종 성장 \n*읽은분량: "+percent);

        }
    }
    public void onCilckReward(View view){
        Toast.makeText(getApplicationContext(),"축하합니다!",Toast.LENGTH_SHORT).show();
    }
}
