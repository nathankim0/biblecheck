package com.example.biblecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private Switch[] sw = new Switch[125];
    TextView textView;
    private Boolean a;
    private int cnt;
    String strCnt;
    SharedPreferences pref;
    SharedPreferences.Editor ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //저장된 cnt있으면 가져오기 없으면 0으로 초기화
        pref = getSharedPreferences( "pref2" , MODE_PRIVATE);
        ed = pref.edit();
        cnt=pref.getInt("savedCnt2",0);

        //스위치뷰
        for(int i=1;i<=124;i++){
            sw[i]=findViewById(R.id.switch1+i-1);
            a=pref.getBoolean("state2"+i,false);
            sw[i].setChecked(a);
        }

        //텍스트뷰
        textView= findViewById(R.id.textView4);
        //읽은분량 바로 변경
        strCnt = String.format("%.2f", (double)cnt/124*100);
        textView.setText("이번 달 "+strCnt+"% 읽으셨습니다.");

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
                strCnt = String.format("%.2f", (double)cnt/124*100);
                textView.setText("이번 달 "+strCnt+"% 읽으셨습니다.");
                //값저장
                ed.putInt( "savedCnt2" , cnt);
                for(int i=1;i<=124;i++) {
                    ed.putBoolean("state2"+i,sw[i].isChecked());
                }
                ed.commit();
            }
        };

        for(int i=1;i<=124;i++) {
            sw[i].setOnCheckedChangeListener(OnCheckedChangeListener);
        }

    }
    public void onClick(View view){
        Intent intent=new Intent(Main2Activity.this,tree.class);
        intent.putExtra("cnt2",cnt);
        startActivity(intent);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.clear:
                for(int i=1;i<=124;i++){
                    sw[i].setChecked(false);
                    ed.putBoolean("state2"+i,sw[i].isChecked());
                }
                ed.putInt( "savedCnt2" , cnt);
                ed.commit();
                strCnt = String.format("%.2f", (double)cnt/124*100);
                textView.setText("이번 달 "+strCnt+"% 읽으셨습니다.");
                return true;
            case R.id.all_check:
                for(int i=1;i<=124;i++){
                    sw[i].setChecked(true);
                    ed.putBoolean("state2"+i,sw[i].isChecked());
                }
                ed.putInt( "savedCnt2" , cnt);
                ed.commit();
                strCnt = String.format("%.2f", (double)cnt/124*100);
                textView.setText("이번 달 "+strCnt+"% 읽으셨습니다.");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
