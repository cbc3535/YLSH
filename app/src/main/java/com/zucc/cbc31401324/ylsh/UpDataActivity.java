package com.zucc.cbc31401324.ylsh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.zucc.cbc31401324.ylsh.Activity.MainActivity;
import com.zucc.cbc31401324.ylsh.Bin.PositionEntity;
import com.zucc.cbc31401324.ylsh.View.SettingItemViewBtn;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

/**
 * Created by chenbaichang on 2018/3/20.
 */

public class UpDataActivity extends Activity implements View.OnClickListener {
    private static String mTAG = "UpDataActivity";

    SettingItemViewBtn PositionBtn;
    SettingItemViewEdit TitleEdit;
    SettingItemViewEdit TitleEdit1;
    SettingItemViewEdit TitleEdit2;
    SettingItemViewEdit TitleEdit3;
    SettingItemViewEdit TitleEdit4;
    SettingItemViewEdit TitleEdit5;
    SettingItemViewEdit Charge;
    Button upload_data_btn;
    ImageView updata_back;

    PositionEntity entity = new PositionEntity();
    private String myCentureLatitude;
    private String myCentureLongitude;
    private String myCentureAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题栏
        setContentView(R.layout.updata);

        findView();
        initData();
    }

    /**
     * 找控件
     */
    private void findView() {
        PositionBtn = (SettingItemViewBtn) findViewById(R.id.myPosition);
        PositionBtn.setOnClickListener(this);

        TitleEdit = (SettingItemViewEdit) findViewById(R.id.myTitle);
        TitleEdit1 = (SettingItemViewEdit)findViewById(R.id.charge_type);
        TitleEdit2 = (SettingItemViewEdit)findViewById(R.id.site_location);
        TitleEdit3 = (SettingItemViewEdit)findViewById(R.id.site_type);
        TitleEdit4 = (SettingItemViewEdit)findViewById(R.id.site_mode);
        TitleEdit5 = (SettingItemViewEdit)findViewById(R.id.site_info);



        upload_data_btn = (Button) findViewById(R.id.myupload_data_btn);
        upload_data_btn.setOnClickListener(this);

        updata_back = (ImageView) findViewById(R.id.updata_back);
        updata_back.setOnClickListener(this);
    }

    /**
     * 发起云存储请求
     */
    private void storage() {
        LBSStorageActivity.request(getRequestParams(), mHandler);
    }

    /**
     * 设定云检索参数
     *
     * @return
     */
    private HashMap<String, String> getRequestParams() {
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            myCentureLatitude = Double.toString(PositionEntity.latitue);
            myCentureLongitude = Double.toString(PositionEntity.longitude);
            myCentureAddress = PositionEntity.address;

            Log.e(mTAG, myCentureLatitude + "-" + myCentureLongitude + "-"
                    + myCentureAddress);

            String titleString = TitleEdit.getMyRightTextView().getText()
                    .toString();
            String titleString1 = TitleEdit1.getMyRightTextView().getText()
                    .toString();
            String titleString2 = TitleEdit2.getMyRightTextView().getText()
                    .toString();
            String titleString3 = TitleEdit3.getMyRightTextView().getText()
                    .toString();
            String titleString4 = TitleEdit4.getMyRightTextView().getText()
                    .toString();
            String titleString5 = TitleEdit5.getMyRightTextView().getText()
                    .toString();
            map.put("latitude", myCentureLatitude);
            map.put("longitude", myCentureLongitude);
            map.put("address", myCentureAddress);
            map.put("title", titleString);
            map.put("info_text", titleString5);
            map.put("mode_text", titleString4);
            map.put("type_text", titleString3);
            map.put("location_text", titleString2);
            map.put("charge", titleString1);
            map.put("image", "null");
            map.put("zan", "0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 3:
                    if (msg.obj == null) {
                        Log.e(mTAG, "msg接收数据为空");
                    } else {
                        String result = msg.obj.toString();
                        try {
                            JSONObject json = new JSONObject(result);
                            parser(json);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
        }
    };

    /**
     * 解析返回数据
     *
     * @param json
     */
    protected void parser(JSONObject json) {
        Infos infos = new Infos();
        List<Infos> list = infos.getReturnInfos();
        try {
            if (json.getInt("status") != 0) {
                Log.e(mTAG, "POST上传错误" + "status=" + json.getInt("status")
                        + "message=" + json.getString("message"));
                Toast.makeText(this, "提交失败", Toast.LENGTH_SHORT).show();
            } else {
                Log.e(mTAG, "status=" + json.getInt("status") + "message="
                        + json.getString("message"));
                Infos info = new Infos();
                info.setReturnid(json.getString("id"));
                list.add(info);
                Toast.makeText(this, "提交成功", Toast.LENGTH_SHORT).show();

                PositionEntity.address = null;
                PositionEntity.latitue = 0;
                PositionEntity.longitude = 0;
                TitleEdit.getMyRightTextView().setText("");
                PositionBtn.setLeftText("请确定当前位置");
            }

        } catch (Exception e) {
            Log.e(mTAG, "parser错误！");
        }
    }

    /**
     * 初始化页面
     */
    private void initData() {
        PositionBtn.setLeftText("请确定当前位置");
        PositionBtn.setRightBitMap(R.drawable.image_more_subitem_arrow);
        TitleEdit.setLeftText("主题:");
        TitleEdit5.setLeftText("简介：");
        TitleEdit1.setLeftText("收费类型：");
        TitleEdit2.setLeftText("具体地点：");
        TitleEdit3.setLeftText("钓点类型：");
        TitleEdit4.setLeftText("适合调法：");
        upload_data_btn.setText("提交");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myupload_data_btn:
                if (PositionEntity.latitue != 0 && PositionEntity.longitude != 0) {
                    if (TitleEdit.getMyRightTextView().getText().length() >= 1 ) {
                        Log.e(mTAG, "主题不为空");
                        storage();
                    } else {
                        Toast.makeText(this, "请输入主题", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "请确定位置", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.myPosition:
                Intent intent = new Intent();
                intent.setClass(UpDataActivity.this, UpDataLocationActivity.class);
                startActivity(intent);
                break;
            case R.id.updata_back:
                Intent intent2 = new Intent(UpDataActivity.this, MainActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                setResult(1, intent2);
                finish();
                break;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        super.onRestart();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(PositionEntity.latitue != 0 || PositionEntity.longitude != 0){
            PositionBtn.getMyLeftTextView().setTextColor(0xFFFFB90F);
            PositionBtn.setLeftText(PositionEntity.address);
        }
    }

    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        PositionEntity.address = null;
        PositionEntity.latitue = 0;
        PositionEntity.longitude = 0;
    }
}

