package com.example.biblecheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
    public void Onclick2(View v){
        Intent intent=new Intent(HomeActivity.this,ChartActivity.class);
        startActivity(intent);
    }
    public void popupClick(View button){
        PopupMenu popupMenu=new PopupMenu(this,button);
        popupMenu.getMenuInflater().inflate(R.menu.popupmenu,popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.m1:
                        Intent intent=new Intent(HomeActivity.this,MainActivity.class);
                        startActivity(intent);
                        return true;
                    case R.id.m2:
                        intent=new Intent(HomeActivity.this,Main2Activity.class);
                        startActivity(intent);
                        return true;
                }
                return true;
            }
        });
        popupMenu.show();
    }
}
