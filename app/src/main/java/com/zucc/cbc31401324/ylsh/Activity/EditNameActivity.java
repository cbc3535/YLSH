package com.zucc.cbc31401324.ylsh.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zucc.cbc31401324.ylsh.R;

/**
 * Created by chenbaichang on 2018/3/6.
 */

public class EditNameActivity extends Activity implements
        android.view.View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.editname);
        Button btn1=(Button)findViewById(R.id.set_back);
        TextView tv1 = (TextView)findViewById(R.id.save);
        btn1.setOnClickListener(this);
        tv1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.set_back:
                finish();
                break;
            case R.id.save:
                //TODO 保存昵称
                Toast.makeText(EditNameActivity.this, "保存成功!", Toast.LENGTH_LONG).show();
                break;
            default:break;

        }
    }
}
