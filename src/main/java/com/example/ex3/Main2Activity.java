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
                Intent in =new Intent(Main2Activity.this,Main3Activity.class);
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
                Toast.makeText(mContext, "ok",LENGTH_SHORT).show();
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