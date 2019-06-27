package com.example.biblecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Switch[] sw = new Switch[125];
    private double cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=1;i<=124;i++){
            sw[i]=findViewById(R.id.switch1+i-1);
        }

        final TextView textView= findViewById(R.id.textView4);
        textView.setText("이번 달 "+cnt/124*100+"% 읽으셨습니다.");

        Switch.OnCheckedChangeListener OnCheckedChangeListener = new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cnt++;
                }
                else{
                    cnt--;
                }
                textView.setText("이번 달 "+cnt/124*100+"% 읽으셨습니다.");
            }
        };

for(int i=1;i<=124;i++) {
    sw[i].setOnCheckedChangeListener(OnCheckedChangeListener);
}
    }
    public void onClick(View view){
        Intent intent=new Intent(MainActivity.this,tree.class);
        intent.putExtra("percent",cnt/124*100);
        startActivity(intent);
    }
}