package com.example.ex3;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.test.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class MainActivity extends Activity implements OnItemClickListener{
    private ListView listview;
    private Button nexbut;
    //定义并初始化保存图片ID的数组
    int [] imageId = new int[]{R.mipmap.lion,R.mipmap.tiger,R.mipmap.monkey,R.mipmap.dog,R.mipmap.cat,R.mipmap.elephant};
    //定义并初始化保存列表项文字的数
    String[] title = new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取列表视图
        listview = (ListView) findViewById(R.id.listView1);
        //创建list集合
        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        //通过for循环将图片id和列表项文字放到Map中，并添加到list集合中
        for(int i=0;i<imageId.length;i++)

        {
            //实例化Map对象
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("image", imageId[i]);
            map.put("title", title[i]);
            //将map对象添加到List集合
            listItems.add(map);
        }
        //参数一context：上下文
        //参数二data：数据源 ，一个Map组成的List集合
        //参数三resource:列表项的布局文件
        //参数四from:Map的键名
        //参数五to:绑定数据视图中的id,与from成对应关系
        final SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.items, new String[]{"title","image"},new int[]{R.id.title,R.id.image});
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        nexbut = findViewById(R.id.button1);
        nexbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in =new Intent(MainActivity.this,Main2Activity.class);
                startActivity(in);
            }
        });

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub
        if (((ListView)parent).getTag() != null){
            ((View)((ListView)parent).getTag()).setBackgroundDrawable(null);
        }
        ((ListView)parent).setTag(view);
        view.setBackgroundColor(Color.RED);

        switch ( position )

        {
            //根据position的值显示title数组中的内容

            case 0 : Toast.makeText(this, ""+title[position]+id,
                    Toast.LENGTH_SHORT).show();
            break;

            case 1 :Toast.makeText(this, ""+title[position],
                    Toast.LENGTH_SHORT).show();
            break;

            case 2 :Toast.makeText(this, ""+title[position],
                    Toast.LENGTH_SHORT).show();
            break;

            case 3 :Toast.makeText(this, ""+title[position],
                   Toast.LENGTH_SHORT).show();
            break;

            case 4 :Toast.makeText(this, ""+title[position],
                    Toast.LENGTH_SHORT).show();
            break;

            case 5 :Toast.makeText(this, ""+title[position],
                    Toast.LENGTH_SHORT).show();
            break;

            default :return;

        }

    }

}





