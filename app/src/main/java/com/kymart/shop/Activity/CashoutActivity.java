package com.kymart.shop.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.kymart.shop.Adapter.Adapter_CashoutList;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.CashoutListBean;
import com.kymart.shop.CustomView.MyListView;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
import com.kymart.shop.Utils.CodeUtils;
import com.kymart.shop.Utils.LogUtils;
import com.kymart.shop.Utils.ToastUtils;
import com.kymart.shop.Utils.Volley_Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.kymart.tptp.R;

public class CashoutActivity extends BaseActivityother {
    private TextView textview_name,textview_ID,text_loadmore;
    private ImageView image_seclect_yue,image_sseclect_cashout;
    private EditText editText_money,edit_bank,edit_bannumber,edit_name,edit_QRcode;
    Button mbutton_submit;

    private ImageView mImage_Code;
    MyListView myListView;



    List<CashoutListBean.ResultBean> mListData;
    Adapter_CashoutList mAdapter;

    @Override
    public int setLayoutResID() {
        return R.layout.activity_cashout;
    }

    @Override
    protected void setData() {
        mImage_Code.setImageBitmap(CodeUtils.getInstance().createBitmap());
        LogUtils.LOG("ceshi",CodeUtils.getInstance().getCode());
        request_listview(1);//请求提现记录列表


    }

    @Override
    protected void initData() {
        mListData=new ArrayList<>();
        textview_name.setText(Staticdata.personCenterBean.getResult().getNickname());
        textview_ID.setText(Staticdata.personCenterBean.getResult().getOperator_status()==0? "会员ID:"+(Staticdata.personCenterBean.getResult().getUser_id() ):"会员ID:"+(Staticdata.personCenterBean.getResult().getUser_id())+"(运营商)");
        mAdapter=new Adapter_CashoutList(mListData,this);
        myListView.setAdapter(mAdapter);
    }

    @Override
    protected void initListener() {
        mImage_Code.setOnClickListener(this);
        text_loadmore.setOnClickListener(this);
        image_seclect_yue.setOnClickListener(this);
        image_sseclect_cashout.setOnClickListener(this);
        mbutton_submit.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        textview_name= (TextView) findViewById(R.id.textview_accountname);
        textview_ID= (TextView) findViewById(R.id.textview_id);
        editText_money= (EditText) findViewById(R.id.edit_money);
        edit_bank= (EditText) findViewById(R.id.edit_bank);
        edit_bannumber= (EditText) findViewById(R.id.edit_banknumber);
        edit_name= (EditText) findViewById(R.id.edit_name);
        edit_QRcode= (EditText) findViewById(R.id.edit_QRcode);
        mbutton_submit= (Button) findViewById(R.id.button_submit);

        image_seclect_yue= (ImageView) findViewById(R.id.seclect_yue);
        image_seclect_yue.setSelected(true);//默认余额提现
        image_sseclect_cashout= (ImageView) findViewById(R.id.seclect_cashout);

        mImage_Code= (ImageView) findViewById(R.id.image_code);
        myListView= (MyListView) findViewById(R.id.listview_item);
        text_loadmore= (TextView) findViewById(R.id.textview_loadmore);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.seclect_yue:
                image_seclect_yue.setSelected(true);
                image_sseclect_cashout.setSelected(false);
                break;
            case R.id.seclect_cashout:
                image_seclect_yue.setSelected(false);
                image_sseclect_cashout.setSelected(true);
                break;
            case R.id.button_submit:
                int type=0;
                type=image_seclect_yue.isSelected()? 1:2;
                String money=editText_money.getText()+"";
                if(money.equals("")){
                    ToastUtils.showToast(this,"请填写金额");
                    return;
                }
                String bankname=edit_bank.getText()+"";
                if(bankname.equals("")){
                    ToastUtils.showToast(this,"请填写银行名称");
                    return;
                }
                String banknumber=edit_bannumber.getText()+"";
                if(banknumber.equals("")){
                    ToastUtils.showToast(this,"请填写收款帐号");
                    return;
                }
                String name=edit_name.getText()+"";
                if(name.equals("")){
                    ToastUtils.showToast(this,"请填写开户名");
                    return;
                }
                String  QRcode=edit_QRcode.getText()+"";
                if(!QRcode.equals(CodeUtils.getInstance().getCode())){
                    ToastUtils.showToast(this,"验证码不正确");
                    return;
                }
                Map  map_cashout=new HashMap();
                map_cashout.put("changetype",""+type);
                map_cashout.put("money",money);
                map_cashout.put("bank_name",bankname);
                map_cashout.put("bank_card",banknumber);
                map_cashout.put("realname",name);

                request_cashout(map_cashout);


                break;
            case R.id.image_code:
                mImage_Code.setImageBitmap(CodeUtils.getInstance().createBitmap());
                LogUtils.LOG("ceshi",CodeUtils.getInstance().getCode());
                break;
            case R.id.textview_loadmore:
                page++;
                request_listview(page);
                break;
        }
    }
  int page=1;
    void  request_listview(int p){

        String  URL= BaseUrl.BaseURL+BaseUrl.cashoutlist+Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken()+"&p="+p;
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","提现记录"+respose);
                if(page==1){
                    mListData.clear();

                }
                mListData.addAll(new Gson().fromJson(respose,CashoutListBean.class).getResult());
                mAdapter.notifyDataSetChanged();
                editText_money.setText(mListData.get(0).getMoney());
                edit_bank.setText(mListData.get(0).getBank_name());
                edit_bannumber.setText(mListData.get(0).getBank_card());
                edit_name.setText(mListData.get(0).getRealname());
            }

            @Override
            public void onError(int error) {

            }
        }).Http(URL,this,0);

    }
    void request_cashout(Map map){
        String URL=BaseUrl.BaseURL+BaseUrl.cashout+Staticdata.UUID_static+"&token="+Staticdata.userBean_static.getResult().getToken();
        new  Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","申请提现"+respose);
                try {
                    JSONObject jo=new JSONObject(respose);
                    String message= (String) jo.get("msg");
                    ToastUtils.showToast(CashoutActivity.this,message);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                request_listview(1);


            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(URL,this,1,map);

    }
}
