# UIcomponents


MainActivity:

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

public class MainActivity extends Activity implements OnItemClickListener {
    private ListView listview;
    private Button nexbut;
    //定义并初始化保存图片ID的数组
    int[] imageId = new int[]{R.mipmap.lion, R.mipmap.tiger, R.mipmap.monkey, R.mipmap.dog, R.mipmap.cat, R.mipmap.elephant};
    //定义并初始化保存列表项文字的数
    String[] title = new String[]{"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取列表视图
        listview = (ListView) findViewById(R.id.listView1);
        //创建list集合
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        //通过for循环将图片id和列表项文字放到Map中，并添加到list集合中
        for (int i = 0; i < imageId.length; i++) {
            //实例化Map对象
            Map<String, Object> map = new HashMap<String, Object>();
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
        final SimpleAdapter adapter = new SimpleAdapter(this, listItems, R.layout.items, new String[]{"title", "image"}, new int[]{R.id.title, R.id.image});
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(this);
        nexbut = findViewById(R.id.button1);
        nexbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(in);
            }
        });

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        // TODO Auto-generated method stub
        if (((ListView) parent).getTag() != null) {
            ((View) ((ListView) parent).getTag()).setBackgroundDrawable(null);
        }
        ((ListView) parent).setTag(view);
        view.setBackgroundColor(Color.RED);

        switch (position) {
            //根据position的值显示title数组中的内容

            case 0:
                Toast.makeText(this, "" + title[position] + id,
                        Toast.LENGTH_SHORT).show();
                break;

            case 1:
                Toast.makeText(this, "" + title[position],
                        Toast.LENGTH_SHORT).show();
                break;

            case 2:
                Toast.makeText(this, "" + title[position],
                        Toast.LENGTH_SHORT).show();
                break;

            case 3:
                Toast.makeText(this, "" + title[position],
                        Toast.LENGTH_SHORT).show();
                break;

            case 4:
                Toast.makeText(this, "" + title[position],
                        Toast.LENGTH_SHORT).show();
                break;

            case 5:
                Toast.makeText(this, "" + title[position],
                        Toast.LENGTH_SHORT).show();
                break;

            default:
                return;

        }

    }

}




Main2Activity:

package com.example.ex3;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.R;

import static android.widget.Toast.LENGTH_SHORT;

public class Main2Activity extends Activity implements OnClickListener {
    private TextView text1;
    private Button nexbut;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main2);
        mContext = this;
        initView();
        nexbut = findViewById(R.id.button2);
        nexbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(in);
            }
        });

    }

    private void initView() {
        text1 = (TextView) findViewById(R.id.text1);
        text1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        dialogShow1();

    }

    /**
     * 自定义布局
     * setView()只会覆盖AlertDialog的Title与Button之间的那部分，而setContentView()则会覆盖全部，
     * setContentView()必须放在show()的后面
     */
    private void dialogShow1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.update_manage_dialog, null);
        TextView content = (TextView) v.findViewById(R.id.dialog_title);
        // 获取布局中的控件
        final EditText username = (EditText) v.findViewById(R.id.username);
        final EditText password = (EditText) v.findViewById(R.id.password);
        Button btn_sure = (Button) v.findViewById(R.id.dialog_btn_sure);
        Button btn_cancel = (Button) v.findViewById(R.id.dialog_btn_cancel);
        //builder.setView(v);//这里如果使用builer.setView(v)，自定义布局只会覆盖title和button之间的那部分
        final Dialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setContentView(v);//自定义布局应该在这里添加，要在dialog.show()的后面
        // dialog.getWindow().setGravity(Gravity.CENTER);//可以设置显示的位置
        btn_sure.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Toast.makeText(mContext, "ok", LENGTH_SHORT).show();
            }
        });

        btn_cancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
                Toast.makeText(mContext, "no", LENGTH_SHORT).show();
            }
        });
    }


}



Main3Activity:

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
                Intent in = new Intent(Main3Activity.this, Main4Activity.class);
                startActivity(in);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        //装填R.Menu.my_menu菜单，并添加到menu中
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    //菜单项被单击后的回调方法

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.isCheckable()) {
            //勾选菜单项
            item.setCheckable(true);
        }
        //switch 判断单击哪个菜单项，并有针对性的做出响应
        switch (item.getItemId()) {
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




Main4Activity:


package com.example.ex3;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.test.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main4Activity extends Activity {
    private ListView listview;
    SimpleAdapter adapter;
    //定义并初始化保存图片ID的数组
    int[] imageId = new int[]{R.mipmap.timg, R.mipmap.timg, R.mipmap.timg, R.mipmap.timg, R.mipmap.timg, R.mipmap.timg};
    //定义并初始化保存列表项文字的数
    String[] title = new String[]{"One", "Two", "Three", "Four", "Five", "Six"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //获取列表视图
        listview = findViewById(R.id.listView2);
        //创建list集合
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        //通过for循环将图片id和列表项文字放到Map中，并添加到list集合中
        for (int i = 0; i < imageId.length; i++) {
            //实例化Map对象
            Map<String, Object> map = new HashMap<String, Object>();
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
        adapter = new SimpleAdapter(this, listItems, R.layout.items2, new String[]{"title", "image"}, new int[]{R.id.title, R.id.image});
        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        ListView.MultiChoiceModeListener callback = new MyMultiChoiceModeListener();
        listview.setMultiChoiceModeListener(callback);
        listview.setAdapter(adapter);
    }

    private class MyMultiChoiceModeListener implements ListView.MultiChoiceModeListener {

        boolean isFirst = true;
        private TextView mSelectedCount;
        private View mMultiSelectActionBarView;

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            //这里返回true
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.context_2, menu);
            if (mMultiSelectActionBarView == null) {
                mMultiSelectActionBarView = LayoutInflater.from(Main4Activity.this)
                        .inflate(R.layout.list_multi_select_actionbar, null);

                mSelectedCount = (TextView) mMultiSelectActionBarView.findViewById(R.id.selected_conv_count);
                ((TextView) mMultiSelectActionBarView.findViewById(R.id.title)).setText("selected");

            }
            mode.setCustomView(mMultiSelectActionBarView);//设置新的ActionBar样式
            return true;
        }

        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {

            //添加列表项被点击后的响应
            //激活actionMode之后，再次点击listview中的item项时，就会触发,可以在Adapter类中添加相关的方法当这个方法执行时，对item项进行相应的处理，如改变背景等。
            /**
             * 当item选中状态改变时调用
             * 在这里修改通知adapter更新选中数目
             */
            if (isFirst) {
                mSelectedCount.setText("1");
                isFirst = false;
            } else {
                mSelectedCount.setText(listview.getCheckedItemCount() + "");
            }
            adapter.notifyDataSetChanged();
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            //这里返回true
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            //这里返回true,用来处理ActionMode中菜单的点击事件
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }


    }

}
