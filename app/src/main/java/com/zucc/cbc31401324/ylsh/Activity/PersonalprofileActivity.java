package com.zucc.cbc31401324.ylsh.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.zucc.cbc31401324.ylsh.R;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by chenbaichang on 2018/3/6.
 */

public class PersonalprofileActivity extends Activity implements
        android.view.View.OnClickListener {
    private CircleImageView circleImageView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.personalprofile);
        Button btn=(Button)findViewById(R.id.pic_more);
        Button btn1=(Button)findViewById(R.id.name_more);
        Button btn2=(Button)findViewById(R.id.sex_more);
        Button btn3=(Button)findViewById(R.id.profile_more);
        Button btn4=(Button)findViewById(R.id.contactinfo_more);
        Button btn5=(Button)findViewById(R.id.set_back);
        circleImageView = findViewById(R.id.iv_icon);
        btn.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        //TODO 获取头像、昵称、性别
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pic_more:
//                Toast.makeText(PersonalprofileActivity.this, "头像选择!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(PersonalprofileActivity.this, ChangeHeadPicActivity.class);
//                PersonalprofileActivity.this.startActivity(intent);
                PersonalprofileActivity.this.startActivityForResult(intent,0);
                break;
            case R.id.name_more:
                Intent intent1 = new Intent(PersonalprofileActivity.this, EditNameActivity.class);
                PersonalprofileActivity.this.startActivity(intent1);
                break;
            case R.id.sex_more:
                Intent intent2 = new Intent(PersonalprofileActivity.this, EditSex.class);
                PersonalprofileActivity.this.startActivity(intent2);
                break;
            case R.id.profile_more:
                Intent intent3 = new Intent(PersonalprofileActivity.this, EditProfile.class);
                PersonalprofileActivity.this.startActivity(intent3);
                break;
            case R.id.contactinfo_more:
                Intent intent4 = new Intent(PersonalprofileActivity.this, EditContactInfoActivity.class);
                PersonalprofileActivity.this.startActivity(intent4);
                break;
            case R.id.set_back:
                finish();
                break;
            default:break;

        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==0&&resultCode ==0){
            circleImageView.setImageURI(Uri.fromFile((File)data.getExtras().get("0")));
        }
    }

}
