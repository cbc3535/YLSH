package com.zucc.cbc31401324.ylsh.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;

import com.zucc.cbc31401324.ylsh.Adapter.FishSiteAdapter;
import com.zucc.cbc31401324.ylsh.Bin.FishSite;
import com.zucc.cbc31401324.ylsh.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbaichang on 2018/3/7.
 */

public class MyFishSiteActivity extends Activity implements
        android.view.View.OnClickListener {

    private List<FishSite> fishsite = new ArrayList<FishSite>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.myfishsite_listview);
        Button btn1=(Button)findViewById(R.id.button3);
        btn1.setOnClickListener(this);
        init();
        FishSiteAdapter adapter = new FishSiteAdapter(MyFishSiteActivity.this,R.layout.myfishsite,fishsite);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        //TODO 我的钓点
    }

    private void init() {
        //TODO 我的钓点 2.2.8
        FishSite site = new FishSite("浙江大学城市学院","浙江大学城市学院内河","100m");
        FishSite site1 = new FishSite("浙江大学城市学院","浙江大学城市学院内河","100m");
        fishsite.add(site);
        fishsite.add(site1);
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
