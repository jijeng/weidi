package com.weidi.jijeng.weidi.radar;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.weidi.jijeng.weidi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  radar 界面之后的 订单详情界面
 */
public class Radar extends Activity {
    private final  String http="http://jia.360.cn/pc/view.html?sn=36020204394";

//    private String[] mListTitle = { "红宇家", "小贾家", "诚诚家", "嘉铭家","梦娜家"};
//    private String[] mListStr = { "北京顺义新开垦富硒神奇土壤", "北京密云本地抗旱棕壤",
//            "北京昌平黑山寨村优良土质", "世界上仅有三块黑土平原之一 东北平原",
//            "怀柔种稻历史悠久有机质全氮及碱解氮高排水尚好高产稳产水稻土" };
    private int pic[]=new int[]{R.drawable.radar_order1,
            R.drawable.radar_order2,R.drawable.radar_order3,
           };
    ListView mListView = null;
    ArrayList<Map<String,Object>> mData= new ArrayList<Map<String,Object>>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radar);
        mListView = (ListView) findViewById(R.id.rader_listview);


        for(int i =0; i < 3; i++) {
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("image", pic[i]);
//            item.put("title", mListTitle[i]);
//            item.put("text", mListStr[i]);
            mData.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,mData,R.layout.radar_item,
                new String[]{"image"},new int[]{R.id.image});
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position,
                                    long id) {
                Intent intent;
                Uri uri=Uri.parse(http);

                switch (position) {
                    case 0:

                        intent=new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                        break;
                    case 1:

                        intent=new Intent(Intent.ACTION_VIEW,uri);
                        startActivity(intent);
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(),Radar_detail.class));
                        break;

                    default:
                        break;
                }

            }
        });



    }
}

