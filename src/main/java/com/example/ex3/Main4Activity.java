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
    int [] imageId = new int[]{R.mipmap.timg,R.mipmap.timg,R.mipmap.timg,R.mipmap.timg,R.mipmap.timg,R.mipmap.timg};
    //定义并初始化保存列表项文字的数
    String[] title = new String[]{"One","Two","Three","Four","Five","Six"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        //获取列表视图
        listview = findViewById(R.id.listView2);
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
        adapter = new SimpleAdapter(this, listItems, R.layout.items2, new String[]{"title","image"},new int[]{R.id.title,R.id.image});
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
                ((TextView)mMultiSelectActionBarView.findViewById(R.id.title)).setText("selected");

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
            if(isFirst){
                mSelectedCount.setText("1");
                isFirst = false;
            }else{
                mSelectedCount.setText(listview.getCheckedItemCount()+"");
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
