package com.zucc.cbc31401324.ylsh.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zucc.cbc31401324.ylsh.R;

/**
 * Created by chenbaichang on 2018/2/6.
 */

public class LoginActivity extends Activity implements
        android.view.View.OnClickListener {
    private Context applicationContext = null ;
    private static final int LOGIN_RESULT = 1;
    private EditText et_password,et_userName;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case LOGIN_RESULT:
                    login((boolean)msg.obj);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applicationContext = getApplicationContext();
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Button btn1=(Button)findViewById(R.id.btn_login2);
        TextView tv1 = (TextView)findViewById(R.id.register);
        btn1.setOnClickListener(this);
        tv1.setOnClickListener(this);
        et_userName = findViewById(R.id.et_userName);
        et_password = findViewById(R.id.et_password);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login2:
                //TODO 判断用户手机号和密码是否匹配
                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                        result = myhttp(username , userid);
                        boolean result =true;
                        // TODO 1.1.1 登录
                        Message message = new Message();
                        message.what = LOGIN_RESULT;
                        message.obj = result;
                        handler.sendMessage(message);
                    }
                }).run();
                break;
            case R.id.register:
                Intent intent2 = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(intent2);
                break;
                default:break;

        }
    }

    @SuppressLint("ShowToast")
    private void login(boolean result){
        if (result == true) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            LoginActivity.this.startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(),"登录失败",Toast.LENGTH_LONG).show();
        }
    }
}
