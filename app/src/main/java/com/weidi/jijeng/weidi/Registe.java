package com.weidi.jijeng.weidi;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import android.text.Html;

import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.weidi.jijeng.weidi.util.MyUser;

import cn.bmob.v3.listener.SaveListener;


public class Registe extends Activity {
    private EditText et_usernick;
    private EditText et_usertel;
    private EditText et_password;
    private Button btn_register;
    private TextView tv_xieyi;

    private ImageView iv_photo;
    ProgressDialog dialog;

    private String imageName;
    private static final int PHOTO_REQUEST_TAKEPHOTO = 1;// 拍照
    private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
    private static final int PHOTO_REQUEST_CUT = 3;// 结果

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registe);
        dialog = new ProgressDialog(Registe.this);
        et_usernick = (EditText) findViewById(R.id.et_usernick);
        et_usertel = (EditText) findViewById(R.id.et_usertel);
        et_password = (EditText) findViewById(R.id.et_password);


        btn_register = (Button) findViewById(R.id.btn_register);
        tv_xieyi = (TextView) findViewById(R.id.tv_xieyi);

        iv_photo = (ImageView) findViewById(R.id.iv_photo);
        String xieyi = "<font color=" + "\"" + "#AAAAAA" + "\">" + "点击上面的"
                + "\"" + "注册" + "\"" + "按钮,即表示你同意" + "</font>" + "<u>"
                + "<font color=" + "\"" + "#576B95" + "\">" + "《微地软件许可及服务协议》"
                + "</font>" + "</u>";

        tv_xieyi.setText(Html.fromHtml(xieyi));

        iv_photo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                showCamera();
            }

        });

        btn_register.setOnClickListener(new OnClickListener() {


            public void onClick(View v) {

                dialog.setMessage("正在注册...");
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.show();

                String usernick = et_usernick.getText().toString().trim();
                final String password = et_password.getText().toString().trim();
                String usertel = et_usertel.getText().toString().trim();
//自定义
                final MyUser myUser= new MyUser();
                myUser.setUsername(usernick);
                myUser.setPassword(password);
                myUser.setMobilePhoneNumber(usertel);

                myUser.signUp(getApplicationContext(), new SaveListener() {
                    @Override
                    public void onSuccess() {
                        Toast.makeText(getApplicationContext(), "注册成功:" + myUser.getUsername() + "-"
                                + myUser.getObjectId() + "-" + myUser.getCreatedAt()
                                + "-" + myUser.getSessionToken() + ",是否验证：" + myUser.getEmailVerified(), Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), FrameActivity.class));
                        dialog.dismiss();
                        finish();
                    }

                    @Override
                    public void onFailure(int i, String s) {
                        Toast.makeText(getApplicationContext(), "注册失败！" + s, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });

            }

        });

    }



    // 拍照部分
    private void showCamera() {

        final AlertDialog dlg = new AlertDialog.Builder(this).create();
        dlg.show();
        Window window = dlg.getWindow();
        // *** 主要就是在这里实现这种效果的.
        // 设置窗口的内容页面,shrew_exit_dialog.xml文件中定义view内容
        window.setContentView(R.layout.alertdialog);
        // 为确认按钮添加事件,执行退出应用操作
        TextView tv_paizhao = (TextView) window.findViewById(R.id.tv_content1);
        tv_paizhao.setText("拍照");
        tv_paizhao.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SdCardPath")
            public void onClick(View v) {

                imageName = getNowTime() + ".png";
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // 指定调用相机拍照后照片的储存路径
                intent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(new File("/sdcard/weidi/", imageName)));
                startActivityForResult(intent, PHOTO_REQUEST_TAKEPHOTO);
                dlg.cancel();
            }
        });
        TextView tv_xiangce = (TextView) window.findViewById(R.id.tv_content2);
        tv_xiangce.setText("相册");
        tv_xiangce.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                getNowTime();
                imageName = getNowTime() + ".png";
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, PHOTO_REQUEST_GALLERY);

                dlg.cancel();
            }
        });

    }

    @SuppressLint("SdCardPath")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PHOTO_REQUEST_TAKEPHOTO:

                    startPhotoZoom(
                            Uri.fromFile(new File("/sdcard/weidi/", imageName)),
                            480);
                    break;

                case PHOTO_REQUEST_GALLERY:
                    if (data != null)
                        startPhotoZoom(data.getData(), 480);
                    break;

                case PHOTO_REQUEST_CUT:
                    Bitmap bitmap = BitmapFactory.decodeFile("/sdcard/weidi/"
                            +imageName);
                    iv_photo.setImageBitmap(bitmap);

                    break;

            }
            super.onActivityResult(requestCode, resultCode, data);

        }
    }

    @SuppressLint("SdCardPath")
    private void startPhotoZoom(Uri uri1, int size) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri1, "image/*");
        // crop为true是设置在开启的intent中设置显示的view可以剪裁
        intent.putExtra("crop", "true");

        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        // outputX,outputY 是剪裁图片的宽高
        intent.putExtra("outputX", size);
        intent.putExtra("outputY", size);
        intent.putExtra("return-data", false);

        intent.putExtra(MediaStore.EXTRA_OUTPUT,
                Uri.fromFile(new File("/sdcard/weidi/", imageName)));
        intent.putExtra("outputFormat", Bitmap.CompressFormat.PNG.toString());
        intent.putExtra("noFaceDetection", true); // no face detection
        startActivityForResult(intent, PHOTO_REQUEST_CUT);
    }

    @SuppressLint("SimpleDateFormat")
    private String getNowTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmssSS");
        return dateFormat.format(date);
    }



}




