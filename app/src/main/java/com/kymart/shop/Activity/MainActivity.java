package com.kymart.shop.Activity;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.gson.Gson;
import com.jaeger.library.StatusBarUtil;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.UserBean;
import com.kymart.shop.Fragment.Fragment_classification;
import com.kymart.shop.Fragment.Fragment_main;

import cn.jpush.android.api.JPushInterface;
import cn.kymart.tptp.R;

import com.kymart.shop.Fragment.Fragment_personalCenter;
import com.kymart.shop.Fragment.Fragment_shopCar;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.InstalltionId;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.SharedPreferencesUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static com.kymart.shop.AppStaticData.Staticdata.UUID_static;
import static com.kymart.shop.AppStaticData.Staticdata.isLogin;
import static com.kymart.shop.AppStaticData.Staticdata.userBean_static;
import static com.kymart.shop.Fragment.Fragment_classification.fragment_classification;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
  public static  MainActivity mMainactivity;
    /**
     * 记录的帐号密码
     */
    private String account ="";
    private String  password="";
    /**
     * 下面按钮
     */
    private RelativeLayout mRelativeLayout_main;
    private RelativeLayout mRelativeLayout_classification;
    private RelativeLayout mRelativeLayout_ShoppingCar;
    private RelativeLayout mRelativeLayout_mine;

    /**
     * 四个Fragment
     */
    Fragment_main mFragment_main;
    Fragment_classification mFragment_classification;
    Fragment_shopCar mFragment_shopCar;
    Fragment_personalCenter mFragment_personalCenter;

    FragmentManager fragmetnmanager;
    FragmentTransaction transaction;

    String JpushpushID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setColor(this, getResources().getColor(R.color.red), 0);//状态栏颜色
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
       JpushpushID=JPushInterface.getRegistrationID(MainActivity.this);
        LogUtils.LOG("ceshi","JPUSH......................................"+JpushpushID);
        initView();
        initData();
        initListenner();
        setView();
        setData();


    }

    private void initListenner() {
        mRelativeLayout_main.setOnClickListener(this);
        mRelativeLayout_classification.setOnClickListener(this);
        mRelativeLayout_ShoppingCar.setOnClickListener(this);
        mRelativeLayout_mine.setOnClickListener(this);

    }

    private void setData() {
        requestVersionData();//查询是否更新
    }

    private void setView() {
        ChangeBottomButton(mRelativeLayout_main);
        fragmetnmanager = getSupportFragmentManager();
        transaction = fragmetnmanager.beginTransaction();
        transaction.add(R.id.fl_main, mFragment_main).commit();

    }

    private void initData() {
        quanxian();//请求存储权限

        mMainactivity=this;
        mFragment_main = new Fragment_main();
        /**
         * 自动登录网络请求
         */
        autoLogin();
    }

    private void initView() {
        //主页下面按钮
        mRelativeLayout_main = (RelativeLayout) findViewById(R.id.rl_1);
        mRelativeLayout_classification = (RelativeLayout) findViewById(R.id.rl_2);
        mRelativeLayout_ShoppingCar = (RelativeLayout) findViewById(R.id.rl_3);
        mRelativeLayout_mine = (RelativeLayout) findViewById(R.id.rl_4);

    }

    @Override
    public void onClick(View view) {
        transaction = fragmetnmanager.beginTransaction();
        hideFragments(transaction);//隐藏所有Fragment,需要哪个显示哪一个
        switch (view.getId()) {
            case R.id.rl_1:
                ChangeBottomButton(mRelativeLayout_main);
                if (mFragment_main == null) {
                    mFragment_main = new Fragment_main();
                    transaction.add(R.id.fl_main, mFragment_main).commit();
                } else {
                    transaction.show(mFragment_main).commit();
                }
                break;
            case R.id.rl_2:
                ChangeBottomButton(mRelativeLayout_classification);
                if(mFragment_classification==null){
                    mFragment_classification=new Fragment_classification();
                    transaction.add(R.id.fl_main, mFragment_classification).commit();
                }else{

                    transaction.show(mFragment_classification).commit();
                }
                break;
            case R.id.rl_3:
                ChangeBottomButton(mRelativeLayout_ShoppingCar);
                if(mFragment_shopCar==null){
                    mFragment_shopCar=new Fragment_shopCar();
                    transaction.add(R.id.fl_main,mFragment_shopCar).commit();
                }else{
                    transaction.show(mFragment_shopCar).commit();
                }

                break;
            case R.id.rl_4:
                if(isLogin==1){//登录状态
                    ChangeBottomButton(mRelativeLayout_mine);
                    if(mFragment_personalCenter==null){
                        mFragment_personalCenter=new Fragment_personalCenter();
                        transaction.add(R.id.fl_main,mFragment_personalCenter).commit();
                    }else{
                        transaction.show(mFragment_personalCenter).commit();
                    }
                }else{//未登录状态
                    Intent intent=new Intent(this,LoginActivity.class);
                    startActivityForResult(intent,0);
                }

                break;

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULT_OK://登录成功打开我的界面的 Fragment
                ChangeBottomButton(mRelativeLayout_mine);
                transaction = fragmetnmanager.beginTransaction();
                hideFragments(transaction);
                if(mFragment_personalCenter==null){
                    mFragment_personalCenter=new Fragment_personalCenter();
                    transaction.add(R.id.fl_main,mFragment_personalCenter).commit();
                }else{
                    transaction.show(mFragment_personalCenter).commit();
                }
                break;
            default:
                break;
        }
    }

    private void hideFragments(FragmentTransaction transaction) {//隐藏Fragment,以便点击时展映相应的Fragment
        if (mFragment_main != null) {
            transaction.hide(mFragment_main);
        }
        if (mFragment_classification != null) {
            transaction.hide(mFragment_classification);
        }
        if (mFragment_shopCar != null) {
            transaction.hide(mFragment_shopCar);
        }
        if (mFragment_personalCenter != null) {
            transaction.hide(mFragment_personalCenter);
        }
    }

    private void ChangeBottomButton(RelativeLayout rl) {//控制底部按钮颜色的变化
        LogUtils.LOG("ceshi", "底部按钮颜色改变");
        mRelativeLayout_main.getChildAt(0).setSelected(false);
        mRelativeLayout_main.getChildAt(1).setSelected(false);
        mRelativeLayout_classification.getChildAt(0).setSelected(false);
        mRelativeLayout_classification.getChildAt(1).setSelected(false);
        mRelativeLayout_ShoppingCar.getChildAt(0).setSelected(false);
        mRelativeLayout_ShoppingCar.getChildAt(1).setSelected(false);
        mRelativeLayout_mine.getChildAt(0).setSelected(false);
        mRelativeLayout_mine.getChildAt(1).setSelected(false);
        rl.getChildAt(0).setSelected(true);
        rl.getChildAt(1).setSelected(true);
    }


    Map<String, String> map;
    String UUID="";
   void  autoLogin(){//自动登录网络请求
       account= SharedPreferencesUtils.getString(this,"kymt","account");
       password =SharedPreferencesUtils.getString(this,"kymt","password");
       if(!password.equals("")){
           map = new HashMap<String, String>();
           map.put("username", account);
           map.put("password", password);
           UUID = InstalltionId.id(this);
           UUID_static=UUID;//将UUID添加全局变量
           request_imageCode(UUID);
       }else{
           return;
       }
   }

    void request_imageCode(String uuid){
        new  Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi1","图形验证码"+respose);
                try {

                    JSONObject jsonObject = new JSONObject(respose);
                    String result=  jsonObject.getString("result");
                    map.put("unique_id", UUID);
                    map.put("capache", result);
                    map.put("push_id", JpushpushID);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                requestlogin(map);

            }

            @Override
            public void onError(int error) {

            }
        }).Http(BaseUrl.BaseURL+BaseUrl.image_code+uuid,this,0);
    }
    void requestlogin(Map map) {//登录请求\
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                int status = 0;
                String msg = "";
                try {
                    JSONObject object = new JSONObject(respose);
                    status = (Integer) object.get("status");//登录状态
                    msg = (String) object.get("msg");//登录返回信息
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (status == 1) {
                    LogUtils.LOG("ceshi", "登录成功" + respose);
                    userBean_static = new Gson().fromJson(respose, UserBean.class);//将用户信息写入全局变量
                    SharedPreferencesUtils.putString(MainActivity.this,"kymt","token",userBean_static.getResult().getToken());
                    Staticdata.isLogin = 1;
                    setResult(RESULT_OK);
                } else {

                }
            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(BaseUrl.BaseURL + BaseUrl.login, this, 1, map);
    }

    String newdownurl = "";//下载apk网址

    /**
     * 联网查询版本
     */
    private void requestVersionData() {
        //// TODO: 2017/6/12  

        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {

                String json = respose;
                try {
                    //解析json
                    JSONObject jo = new JSONObject(json);
                    newdownurl = (String) jo.get("url");//下载新版本的网址
                    int newVersion = (Integer) jo.get("version");//新的版本号

                    LogUtils.LOG("ceshi","联网查询的版本号是"+newVersion+"地址"+newdownurl);
                    int curVersionCode = getVersionInfo();
                    if (curVersionCode == Integer.MAX_VALUE) {

                        LogUtils.LOG("ceshi", "获得当前版本号出错");
                        return;
                    } else {

                        if (curVersionCode < newVersion) {//有新版本

                            showUpdateDialog(newVersion, newdownurl);

                        } else {//没有新版本
                            return;
                        }
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                    LogUtils.LOG("ceshi", "更新版本出错");
                }

            }

            @Override
            public void onError(int error) {

            }
        }).Http(BaseUrl.checkUpdate, this, 0);


    }

    private ProgressDialog mProgress;
    private int progress; //apk下载的进度
    void quanxian(){
        /**
         * 判断是否有存储权限
         */
        int checkWriteStoragePermission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);//获取系统是否被授予该种权限
        if (checkWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {//如果没有被授予
            mProgress.dismiss();
            ToastUtils.showToast(MainActivity.this,"请打开应用的存储权限");
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0x123);
            //请求获取该种权限
        }
    }

    private void showUpdateDialog(final int code, final String apkurl) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("升级提示");
                builder.setMessage("有新版本，请更新!");
                builder.setCancelable(true);

                builder.setPositiveButton("立即更新", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        mProgress = new ProgressDialog(MainActivity.this);
                        mProgress.setMax(100);
                        mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        mProgress.setMessage("正在下载...");
                        // 对话框显示出来
                        mProgress.setCancelable(true);
                        mProgress.show();

                        /**
                         * 判断是否有存储权限
                         */
                        int checkWriteStoragePermission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);//获取系统是否被授予该种权限
                        if (checkWriteStoragePermission != PackageManager.PERMISSION_GRANTED) {//如果没有被授予
                            mProgress.dismiss();
                            ToastUtils.showToast(MainActivity.this,"请打开应用的存储权限");
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0x123);
                           //请求获取该种权限
                        }else{
                            // 直接下载
                            new downloadApkThread().start();
                        }

//                        // 直接下载
//                     new downloadApkThread().start();

                    }

                });

                builder.show();

            }
        });

    }

    /**
     * 下载的apk地址
     */
    private final int DOWNLOAD = 1;
    private final int DOWNLOAD_FINISH = 2;
    private String mSavePath;
    private Handler downHandler = new Handler() {

        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case DOWNLOAD:
                    mProgress.setProgress(progress);
                    break;
                case DOWNLOAD_FINISH:
                    installApk();
                    break;
            }

        }

    };

    /**
     * 安装APK
     */
    private void installApk() {

        File newFile = new File(mSavePath, "version.apk");


        Intent intent = new Intent(Intent.ACTION_VIEW);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            Uri contentUri = FileProvider.getUriForFile(this, "com.kymart.shop.fileprovider", newFile);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
        } else {
            intent.setDataAndType(Uri.fromFile(newFile), "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        this.startActivity(intent);

    }

    /**
     * 下载apk
     */
    private boolean cancelUpdate = false;

    private class downloadApkThread extends Thread {
        @Override
        public void run() {
            try {
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                    String sdpath = Environment.getExternalStorageDirectory() + "/";
                    mSavePath = sdpath + "download";
                    URL url = new URL(newdownurl);

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.connect();
                    int length = conn.getContentLength();
                    InputStream is = conn.getInputStream();

                    File file = new File(mSavePath);
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    File apkFile = new File(mSavePath, "version.apk");
                    FileOutputStream fos = new FileOutputStream(apkFile);
                    int count = 0;
                    byte buf[] = new byte[1024];

                    do {
                        int numread = is.read(buf);
                        count += numread;

                        progress = (int) (((float) count / length) * 100);
                        downHandler.sendEmptyMessage(DOWNLOAD);
                        if (numread <= 0) {
                            downHandler.sendEmptyMessage(DOWNLOAD_FINISH);
                            cancelUpdate = true;
                            mProgress.dismiss();
                            break;
                        }
                        fos.write(buf, 0, numread);
                    } while (!cancelUpdate);
                    fos.close();
                    is.close();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 得到当前版本号
     *
     * @return
     */
    private int getVersionInfo() {

        PackageManager pm = getPackageManager();
        // flag写一个0就是全部拿到封装在PackageInfo对象中
        try {
            PackageInfo info = pm.getPackageInfo(getPackageName(), 0);

            return info.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return Integer.MAX_VALUE;
        }
    }

    /**
     * 再点一次退出
     */
    private long mLastTime = 0;
    @Override
    public void onBackPressed() {
        if(mFragment_classification!=null){
            if(!mFragment_classification.isHidden()){
                mMainactivity.onClick(this.findViewById(R.id.rl_1));
            }else{
                if (System.currentTimeMillis() - mLastTime > 2000) {
                    // 两次返回时间超出两秒
                    Toast.makeText(this, "再点一次退出程序", Toast.LENGTH_SHORT).show();
                    mLastTime = System.currentTimeMillis();
                } else {
//                    if(fragment_classification!=null){
//                        fragment_classification=null;
//                    }
                    // 两次返回时间小于两秒，可以退出
                    finish();
                }
            }
        }else{
            if (System.currentTimeMillis() - mLastTime > 2000) {
                // 两次返回时间超出两秒
                Toast.makeText(this, "再点一次退出程序", Toast.LENGTH_SHORT).show();
                mLastTime = System.currentTimeMillis();
            } else {
                // 两次返回时间小于两秒，可以退出
//                if(fragment_classification!=null){
//                    fragment_classification=null;
//                }
                finish();
            }
        }

    }




}
