package com.example.biblecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Switch[] sw = new Switch[125];
    private Boolean a;
    private int cnt;
    SharedPreferences pref;
    SharedPreferences.Editor ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //저장된 cnt있으면 가져오기 없으면 0으로 초기화
        pref = getSharedPreferences( "pref" , MODE_PRIVATE);
        ed = pref.edit();
        cnt=pref.getInt("savedCnt",0);

        //스위치뷰
        for(int i=1;i<=124;i++){
            sw[i]=findViewById(R.id.switch1+i-1);
            a=pref.getBoolean("state"+i,false);
            sw[i].setChecked(a);
        }

        //텍스트뷰
        final TextView textView= findViewById(R.id.textView4);
        //읽은분량 바로 변경
        textView.setText("이번 달 "+(double)cnt/124*100+"% 읽으셨습니다.");

        //스위치뷰 리스너
        Switch.OnCheckedChangeListener OnCheckedChangeListener = new Switch.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){ //on시, cnt증가
                    cnt++;
                }
                else{ //off시, cnt 감소
                    cnt--;
                }
                textView.setText("이번 달 "+(double)cnt/124*100+"% 읽으셨습니다.");
                //값저장
                ed.putInt( "savedCnt" , cnt);
                for(int i=1;i<=124;i++) {
                    ed.putBoolean("state"+i,sw[i].isChecked());
                }
                ed.commit();
            }
        };

        for(int i=1;i<=124;i++) {
      sw[i].setOnCheckedChangeListener(OnCheckedChangeListener);
        }

    }
    public void onClick(View view){
        Intent intent=new Intent(MainActivity.this,tree.class);
        intent.putExtra("percent",(double)cnt/124*100);
        startActivity(intent);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
            ed.clear();		//전체데이터 삭제
            ed.commit();
            finish();
            return true;
    }
}
