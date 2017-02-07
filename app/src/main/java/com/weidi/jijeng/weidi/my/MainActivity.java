package com.weidi.jijeng.weidi.my;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import android.widget.TextView;
import android.widget.Toast;

import com.bmob.BTPFileResponse;
import com.bmob.BmobProFile;
import com.bmob.btp.callback.DownloadListener;
import com.bmob.btp.callback.UploadListener;


import com.smile.filechoose.api.ChooserType;
import com.smile.filechoose.api.ChosenFile;
import com.smile.filechoose.api.FileChooserListener;
import com.smile.filechoose.api.FileChooserManager;

import com.weidi.jijeng.weidi.R;

import com.weidi.jijeng.weidi.fragment.ImagePagerFragment;
import com.weidi.jijeng.weidi.util.Constants;
import com.weidi.jijeng.weidi.util.Person;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.listener.SaveListener;

/**
 * showToast("文件下载地址："+BmobPro.getInstance(this).getCacheDownloadDir());
 * 获取本地下载的文件的 绝对路径
 * BmobPro.getInstance(NewBmobFileActivity.this).clearCache();
 * 清除本地缓存
 */
public class MainActivity extends ActionBarActivity implements FileChooserListener {

    private LinearLayout ll_myin;
    private final static int REQUESTCODE=2;
    private TextView zhu_yonghuming;
    private LinearLayout upload, download;
    private FileChooserManager fm;
    private LinearLayout linearCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll_myin=(LinearLayout)this.findViewById(R.id.ll_myin);
        upload= (LinearLayout) findViewById(R.id.upload);
//        download = (LinearLayout) findViewById(R.id.download);
        linearCheck= (LinearLayout) findViewById(R.id.linearCheck);


        zhu_yonghuming=(TextView)this.findViewById(R.id.zhu_yonghuming);
        ll_myin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,wo_myinformation.class);
                startActivityForResult(intent,REQUESTCODE);
            }
        });

        //处理上传文件的 事务
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"请先选择文件",Toast.LENGTH_SHORT).show();
                pickFile();
            }
        });
        //处理下载文件的 事务
//        download.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                download();
////                startActivity(new Intent(MainActivity.this,check.class));
//
//            }
//        });


       /* //我到我的信息
        findViewById(R.id.rl_myin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),wo_myinformation.class));
            }
        });*/
        //转到我的订单
        findViewById(R.id.rl_myorder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), wo_order.class));
            }
        });
        //转到我的钱包
        findViewById(R.id.rl_mywallet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),wo_mywallet.class));
            }
        });
        //转到设置
        findViewById(R.id.rl_make).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),wo_make.class));
            }
        });

        //链接到我的收藏
        findViewById(R.id.rl_wocollect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),wo_collect.class));

            }
        });
        //链接到我的评价
        findViewById(R.id.rl_woevalude).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),wo_evaluate.class));

            }
        });
        linearCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, SimpleImageActivity.class);
                intent.putExtra(Constants.Extra.FRAGMENT_INDEX, ImagePagerFragment.INDEX);
                startActivity(intent);
            }
        });


    }
    private static String downloadName= "";
//    private void download() {
//
//        if(downloadName.equals("")){
//            Log.e(null,"请指定下载文件名");
//            return;
//        }
//        dialog = new ProgressDialog(MainActivity.this);
//        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        dialog.setTitle("下载中...");
//        dialog.setIndeterminate(false);
//        dialog.setCancelable(true);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.show();
//        BmobProFile.getInstance(getApplicationContext()).download(downloadName, new DownloadListener() {
//
//            @Override
//            public void onSuccess(String fullPath) {
//                // TODO Auto-generated method stub
//                Log.e(null, "MainActivity -download-->onSuccess :" + fullPath);
//                dialog.dismiss();
//                Toast.makeText(getApplicationContext(), "下载成功：" + fullPath, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onProgress(String localPath, int percent) {
//                // TODO Auto-generated method stub
//                Log.e(null, "MainActivity -download-->onProgress :" + percent);
//                dialog.setProgress(percent);
//            }
//
//            @Override
//            public void onError(int statuscode, String errormsg) {
//                // TODO Auto-generated method stub
//                Log.e(null, "MainActivity -download-->onError :" + statuscode + "--" + errormsg);
//                dialog.dismiss();
//                Toast.makeText(getApplicationContext(), "下载出错：" + errormsg, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    private void pickFile() {
        fm = new FileChooserManager(this);
        fm.setFileChooserListener(this);
        try {
            fm.choose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==2){
            if (requestCode==REQUESTCODE){
                String b=data.getStringExtra("b");
                zhu_yonghuming.setText(String.valueOf(b));

            }
        }
        if (requestCode == ChooserType.REQUEST_PICK_FILE && resultCode == RESULT_OK) {
            if (fm == null) {
                fm = new FileChooserManager(this);
                fm.setFileChooserListener(this);
            }
            Log.i(null, "Probable file size: " + fm.queryProbableFileSize(data.getData(), this));
            fm.submit(requestCode, data);

    }
    }

    ChosenFile choosedFile;
    @Override
    public void onFileChosen(ChosenFile chosenFile) {
        // TODO Auto-generated method stub
        this.choosedFile = chosenFile;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                upload();
            }
        });
    }

    public void onError(String arg0) {
        // TODO Auto-generated method stub
        Toast.makeText(getApplicationContext(),arg0,Toast.LENGTH_SHORT).show();
    }




    String downLoadUrl ="";
    ProgressDialog dialog =null;

    private void upload() {
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setTitle("上传中...");
        dialog.setIndeterminate(false);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        BTPFileResponse response = BmobProFile.getInstance(getApplicationContext()).upload(choosedFile.getFilePath(), new UploadListener() {
            @Override
            public void onSuccess(String fileName, String url, BmobFile file) {
                // TODO Auto-generated method stub
                Log.i("smile", "新版文件服务的fileName = "+fileName+",新版文件服务的url ="+url);
                if(file!=null){
                    Log.i("smile", "兼容旧版文件服务的源文件名 = "+file.getFilename()+",文件地址url = "+file.getUrl());
                }
                downloadName = fileName;
                dialog.dismiss();
                //保存BmobFile对象
                Person person = new Person();
                person.setPic(file);
                person.setName("smile");
                person.save(getApplicationContext(),new SaveListener() {

                    @Override
                    public void onSuccess() {
                        // TODO Auto-generated method stub
                        Log.i("smile", "Person对象保存成功");
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        // TODO Auto-generated method stub
                        Log.i("smile", "Person对象保存失败："+code+"-"+msg);
                    }
                });
                Toast.makeText(getApplicationContext(),
                        "文件已上传成功：" + fileName,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProgress(int ratio) {
                Log.i("smile","MainActivity -onProgress :"+ratio);
                dialog.setProgress(ratio);

            }

            @Override
            public void onError(int statuscode, String errormsg) {
//                Log.i("smile", "Person对象保存失败："+i+"-"+s);
                dialog.dismiss();
                Toast.makeText(getApplicationContext(),"上传出错：" + errormsg,Toast.LENGTH_SHORT).show();
            }
        });
        Log.e(null, "upload方法返回的code = " + response.getStatusCode());

    }


}
