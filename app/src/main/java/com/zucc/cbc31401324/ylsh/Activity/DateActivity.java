package com.zucc.cbc31401324.ylsh.Activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.zucc.cbc31401324.ylsh.R;
import com.zucc.cbc31401324.ylsh.SiteMoreChoiceActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by chenbaichang on 2018/3/22.
 */

public class DateActivity extends Activity implements
        android.view.View.OnClickListener {
    private DatePickerDialog mDataPicker;
    public TextView okcalendar;
    private TextView oksite;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.date);
        oksite = findViewById(R.id.ok_site);
        okcalendar = (TextView)findViewById(R.id.ok_calendar);
        Button btn = (Button)findViewById(R.id.back);
        btn.setOnClickListener(this);
        TextView tv = (TextView) findViewById(R.id.ok);
        tv.setOnClickListener(this);
        Button btn1 = (Button)findViewById(R.id.calendar_more);
        btn1.setOnClickListener(this);
        Button btn2 = (Button)findViewById(R.id.site_more);
        btn2.setOnClickListener(this);
//        TextView btn3 = (TextView)findViewById(R.id.ok);
//        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.calendar_more:
            openDatePicker();
                break;
            case R.id.back:
                finish();
                break;
            case R.id.site_more:
                Intent intent2 = new Intent(DateActivity.this, SiteMoreChoiceActivity.class);
                DateActivity.this.startActivityForResult(intent2,0);
                break;
            case R.id.ok:
                //TODO 向后台传约钓信息 同时 回到上一级页面
//                Intent intent = new Intent(DateActivity.this, Fragment_Together_Activity.class);
//                DateActivity.this.startActivity(intent);
                finish();
                break;
            default:break;

        }
    }

    private void openDatePicker(){
        getDatePickerDialog();
        mDataPicker.show();
    }
    private void getDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        mDataPicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日  EE");
                okcalendar.setText(df.format(calendar.getTime()));
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode ==0&&resultCode==0){
            oksite.setText(data.getExtras().getString("0"));
        }
    }

}
