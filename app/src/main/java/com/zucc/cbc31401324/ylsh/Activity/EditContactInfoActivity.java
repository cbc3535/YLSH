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
 * Created by chenbaichang on 2018/3/7.
 */

public class EditContactInfoActivity extends Activity implements
        android.view.View.OnClickListener {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.editcontact);
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
                //TODO 保存联系方式
                Toast.makeText(EditContactInfoActivity.this, "保存成功!", Toast.LENGTH_LONG).show();
                break;
            default:break;

        }
    }
}
