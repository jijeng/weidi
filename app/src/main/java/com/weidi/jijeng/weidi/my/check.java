package com.weidi.jijeng.weidi.my;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.bmob.BmobPro;
import com.weidi.jijeng.weidi.R;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Administrator on 2015/10/1.
 */
public class check extends Activity {
    ImageView imgCheck;
    ListView imgListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        imgCheck = (ImageView) findViewById(R.id.imgCheck1);
        imgListView = (ListView) findViewById(R.id.listview1);
        String FilePath=  BmobPro.getInstance(this).getCacheDownloadDir();
        BmobPro.getInstance(this).getCacheThumbnailDir();

        List<HashMap<String ,Object>> data= new ArrayList<>();
        //读取 filepath路径下的 文件
//        for (int i=0;i<FilePath.length();i++){
//            HashMap<String,Object> map=new HashMap<>();
//            map.put("img1",FilePath[i]);
//            data.add(map);
//        }

        SimpleAdapter adapter= new SimpleAdapter(check.this,data,
                R.layout.imgitem,new String[]{"img1"},new int[]{R.id.img1});
        imgListView.setAdapter(adapter);

        Toast.makeText(check.this,FilePath,Toast.LENGTH_SHORT).show();
        Toast.makeText(check.this,FilePath.length(),Toast.LENGTH_SHORT).show();
//        Bitmap bm = BitmapFactory.decodeFile(FilePath);
//        imgCheck.setImageBitmap(bm);
    }
}
