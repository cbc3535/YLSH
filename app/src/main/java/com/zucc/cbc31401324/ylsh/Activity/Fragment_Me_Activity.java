package com.zucc.cbc31401324.ylsh.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zucc.cbc31401324.ylsh.R;

/**
 * Created by chenbaichang on 2018/2/8.
 */

public class Fragment_Me_Activity extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_me, container, false);
        TextView tv1 = (TextView)view.findViewById(R.id.personal);
        TextView tv2 = (TextView)view.findViewById(R.id.myfishsite);
        TextView tv5 = (TextView)view.findViewById(R.id.mynotice);
        TextView tv6=(TextView)view.findViewById(R.id.setting);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv5.setOnClickListener(this);
        tv6.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.personal:
                Intent intent = new Intent(getActivity(), PersonalprofileActivity.class);
                Fragment_Me_Activity.this.startActivity(intent);
                break;
            case R.id.myfishsite:
                Intent intent2 = new Intent(getActivity(), MyFishSiteActivity.class);
                Fragment_Me_Activity.this.startActivity(intent2);
                break;
            case R.id.mynotice:
                Intent intent3 = new Intent(getActivity(), MyMessageActivity.class);
                Fragment_Me_Activity.this.startActivity(intent3);
                break;
            case R.id.setting:
                Intent intent1 = new Intent(getActivity(), Exit.class);
                Fragment_Me_Activity.this.startActivity(intent1);
                break;
            default:break;

        }

    }
}
