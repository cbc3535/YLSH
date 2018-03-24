package com.zucc.cbc31401324.ylsh.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import com.zucc.cbc31401324.ylsh.Adapter.FishTogetherAdapter;
import com.zucc.cbc31401324.ylsh.Bin.FishTogether;
import com.zucc.cbc31401324.ylsh.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbaichang on 2018/3/8.
 */

public class MyFishTogetherActivity extends Activity implements
        android.view.View.OnClickListener {
    private List<FishTogether> fishtogether=new ArrayList<FishTogether>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.myfishtogether_listview);
        Button btn1=(Button)findViewById(R.id.button3);
        btn1.setOnClickListener(this);
        init();
        FishTogetherAdapter adapter = new FishTogetherAdapter(MyFishTogetherActivity.this,R.layout.myfishtogether,fishtogether);
        ListView listView = (ListView)findViewById(R.id.list_view1);
        listView.setAdapter(adapter);
        //TODO 我的约钓
    }

    private void init() {
        // 我—>我的消息—>我发起的
        FishTogether site = new FishTogether(R.drawable.pic,
                "cya",
                "1分钟前",
                "100m",
                "有没有人一起去钓鱼啊？",
                "2017-11-4 星期六",
                "浙江大学城市学院内河");
        fishtogether.add(site);
        FishTogether site1 = new FishTogether(R.drawable.pic,
                "cbc",
                "10分钟前",
                "1000m",
                "一起去钓鱼啊？",
                "2017-12-14 星期六",
                "浙江大学城市学院");
        fishtogether.add(site1);
        FishTogether site2 = new FishTogether(R.drawable.pic,
                "cbc",
                "10分钟前",
                "1000m",
                "一起去钓鱼啊？",
                "2017-12-14 星期六",
                "浙江大学城市学院");
        fishtogether.add(site2);
        FishTogether site3 = new FishTogether(R.drawable.pic,
                "cbc",
                "10分钟前",
                "1000m",
                "一起去钓鱼啊？",
                "2017-12-14 星期六",
                "浙江大学城市学院");
        fishtogether.add(site3);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button3:
                finish();
                break;
            default:break;

        }
    }
}
