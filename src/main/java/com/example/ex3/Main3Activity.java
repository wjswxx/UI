package com.example.ex3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;

public class Main3Activity extends AppCompatActivity {
    private TextView textView;
    private Button nexbut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        textView = (TextView) findViewById(R.id.txt);
        nexbut = findViewById(R.id.button3);
        nexbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(in);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        //装填R.Menu.my_menu菜单，并添加到menu中
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //菜单项被单击后的回调方法

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.isCheckable()){
            //勾选菜单项
            item.setCheckable(true);
        }
        //switch 判断单击哪个菜单项，并有针对性的做出响应
        switch (item.getItemId()){
            case R.id.font_10:
                textView.setTextSize(10 * 2);
                break;
            case R.id.font_16:
                textView.setTextSize(16 * 2);
                break;
            case R.id.font_20:
                textView.setTextSize(20 * 2);
                break;
            case R.id.red_font:
                textView.setTextColor(Color.RED);
                break;
            case R.id.black_font:
                textView.setTextColor(Color.BLACK);
                break;
            case R.id.plain_item:
                Toast.makeText(this, "这是一个普通菜单选项",
                        Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;

        }
        return true;
    }
}
