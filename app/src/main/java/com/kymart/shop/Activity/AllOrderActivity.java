package com.kymart.shop.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.kymart.shop.AppStaticData.Staticdata;
import com.kymart.shop.Bean.AllOrderBean;
import com.kymart.shop.Http.BaseUrl;
import com.kymart.shop.Interface.Interface_volley_respose;
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

public class AllOrderActivity extends BaseActivityother {
    private RelativeLayout mRelativeLayout_allOrder,mRelativelayout_noPay,mRelativelayout_noConsigment,mRelativelayout_noAccepty,mRelativeLayout_noAssess;

    private ExpandableListView mListview;
    private View footview;
    TextView mtextview_footLoadmore;
    int  page=1;
    String type="";
    List<AllOrderBean.ResultBean> mlist_group=new ArrayList<>();
    List<List<AllOrderBean.ResultBean.GoodsListBean>> mlist_children=new ArrayList<>();
    ListAdapter mAdapter;

    @Override
    public int setLayoutResID() {
        return R.layout.activity_all_order;
    }

    @Override
    protected void setData() {

    }

    @Override
    protected void initData() {
        mAdapter=new ListAdapter(mlist_children,mlist_group,this);
        mListview.setAdapter(mAdapter);
        requestOrder(1,type);
    }

    @Override
    protected void initListener() {
        mRelativeLayout_allOrder.setOnClickListener(this);
        mRelativelayout_noPay.setOnClickListener(this);
        mRelativelayout_noConsigment.setOnClickListener(this);
        mRelativelayout_noAccepty.setOnClickListener(this);
        mRelativeLayout_noAssess.setOnClickListener(this);
        mtextview_footLoadmore.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mRelativeLayout_allOrder= (RelativeLayout) findViewById(R.id.RelativeLayout_AllOrder);
        mRelativelayout_noPay= (RelativeLayout) findViewById(R.id.RelativeLayout_NoPay);
        mRelativelayout_noConsigment= (RelativeLayout) findViewById(R.id.RelativeLayout_NoConsignment);
        mRelativelayout_noAccepty= (RelativeLayout) findViewById(R.id.RelativeLayout_NoAccept);
        mRelativeLayout_noAssess= (RelativeLayout) findViewById(R.id.RelativeLayout_NoAssess);
        mRelativeLayout_allOrder.setSelected(true);//初始 全部订单  设为选中
        mListview= (ExpandableListView) findViewById(R.id.listview_allorder);

        footview=getLayoutInflater().inflate(R.layout.item_allorder_footview,null,false);
        mtextview_footLoadmore= (TextView) footview.findViewById(R.id.textview_loadmore);
        mListview.addFooterView(footview);


    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        initButton();
        switch (v.getId()){
            case R.id.RelativeLayout_AllOrder://全部订单
                mRelativeLayout_allOrder.setSelected(true);
                type="";
                page=1;
                requestOrder(1,type);
            break;
            case R.id.RelativeLayout_NoPay://待付款
                mRelativelayout_noPay.setSelected(true);
                type="WAITPAY";
                page=1;
                requestOrder(1,type);

            break;
            case R.id.RelativeLayout_NoConsignment://待发货
                mRelativelayout_noConsigment.setSelected(true);
                type="WAITSEND";
                page=1;
                requestOrder(1,type);
            break;
            case R.id.RelativeLayout_NoAccept://待收货
                mRelativelayout_noAccepty.setSelected(true);
                type="WAITRECEIVE";
                page=1;
                requestOrder(1,type);

            break;
            case R.id.RelativeLayout_NoAssess:
                mRelativeLayout_noAssess.setSelected(true);
                Intent intend_assess=new Intent(this,OrderAssessActivity.class);
                startActivity(intend_assess);

            break;
            case R.id.textview_loadmore:
                page++;
                requestOrder(page,type);
                break;

        }

    }
    void initButton() {
        mRelativeLayout_allOrder.setSelected(false);
        mRelativelayout_noPay.setSelected(false);
        mRelativelayout_noConsigment.setSelected(false);
        mRelativelayout_noAccepty.setSelected(false);
        mRelativeLayout_noAssess.setSelected(false);
    }
    void  requestOrder(int p,String TYPE){//请求订单
        String URL;
        if(type.equals("")){
            URL = BaseUrl.BaseURL+BaseUrl.AllOrder+ Staticdata.userBean_static.getResult().getToken()+"&user_id="+Staticdata.userBean_static.getResult().getUser_id()+"&p="+p;
        }else {
            URL= BaseUrl.BaseURL+BaseUrl.AllOrder+ Staticdata.userBean_static.getResult().getToken()+"&user_id="+Staticdata.userBean_static.getResult().getUser_id()+"&type="+TYPE+"&p="+p;
        }

        LogUtils.LOG("ceshi","全部订单"+URL);
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","全部订单"+respose);
                JSONObject object = null;
                try {
                    object = new JSONObject(respose);
                    int status = (Integer) object.get("status");
                    String  msg = (String) object.get("msg");
                    if(status!=1){
                        ToastUtils.showToast(AllOrderActivity.this,msg);
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if(page==1){
                    mlist_group.clear();
                    mlist_children.clear();
                }
                mlist_group.addAll(new Gson().fromJson(respose,AllOrderBean.class).getResult());
                for(int i=0;i<mlist_group.size();i++){
                    List<AllOrderBean.ResultBean.GoodsListBean> child=new ArrayList();
                    for(int j=0;j<mlist_group.get(i).getGoods_list().size();j++){
                        child.add(mlist_group.get(i).getGoods_list().get(j));
                    }
                    mlist_children.add(child);
                }
                mAdapter.notifyDataSetChanged();
                for(int i = 0; i < mAdapter.getGroupCount(); i++){//默认展开
                    mListview.expandGroup(i);
                }
            }

            @Override
            public void onError(int error) {
                LogUtils.LOG("ceshi","全部订单失败");
            }
        }).Http(URL,this,0);
    }
    void requestOrderNumber(Map map, final String price){//提交订单号码跳转付款界面
        String URL=BaseUrl.BaseURL+BaseUrl.ordernumber+Staticdata.userBean_static.getResult().getToken();
        new  Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","提交订单编号"+respose);
                JSONObject object = null;
                try {
                    object = new JSONObject(respose);
                    int status = (Integer) object.get("status");
                    String  msg = (String) object.get("msg");
                    if(status!=1){
                        ToastUtils.showToast(AllOrderActivity.this,msg);
                        return;
                    }
                    String result=object.get("result")+"";

                    finish();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(URL,this,1,map);

    }
    void cancleOrder(Map map){
        String URL=BaseUrl.BaseURL+BaseUrl.cancleOrder+Staticdata.userBean_static.getResult().getToken();
        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                LogUtils.LOG("ceshi","取消订单"+respose);
                JSONObject object = null;
                try {
                    object = new JSONObject(respose);
                    String  msg = (String) object.get("msg");
                    ToastUtils.showToast(AllOrderActivity.this,msg);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(int error) {

            }
        }).postHttp(URL,this,1,map);
    }


    void isButton(Button button,int i){
        if(i==0){
            button.setVisibility(View.GONE);
        }else {
            button.setVisibility(View.VISIBLE);
        }

    }


    /*适配器*/
    class ListAdapter extends BaseExpandableListAdapter {

        private List<AllOrderBean.ResultBean> group;
        private List<List<AllOrderBean.ResultBean.GoodsListBean>> children;
        private LayoutInflater mLayoutInflater;

        public ListAdapter(List<List<AllOrderBean.ResultBean.GoodsListBean>> children, List<AllOrderBean.ResultBean> group, Context context) {
            this.children = children;
            this.group = group;
            mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override // 获取ListView中组的数量
        public int getGroupCount() {
            return group.size();
        }

        @Override// 获取第groupPosition组中子item的数量
        public int getChildrenCount(int groupPosition) {
            return children.get(groupPosition).size();
        }

        @Override// 获得第groupPosition组中的数据
        public Object getGroup(int groupPosition) {
            return group.get(groupPosition);
        }

        @Override// 获取第groupPosition组中的第childPosition位置的数据
        public Object getChild(int groupPosition, int childPosition) {
            return children.get(groupPosition).get(childPosition);
        }

        @Override// 获取第groupPosition组的id
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override// 获取第groupPosition组中的第childPosition位置item的id
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override// 获取第groupPosition组的视图
        public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            if (convertView == null) {
                holder=new ViewHolder();
                convertView = mLayoutInflater.inflate(R.layout.item_allorder_group, parent, false);
                holder.mtextview_ordernumber= (TextView) convertView.findViewById(R.id.textview_ordernumber);
                holder.mtextview_allprice= (TextView) convertView.findViewById(R.id.textview_allprice);
                holder.mbutton_pay= (Button) convertView.findViewById(R.id.button_pay);
                holder.mbutton_cancle= (Button) convertView.findViewById(R.id.button_cancle);
                holder.button_shouhuo= (Button) convertView.findViewById(R.id.button_shouhuo);
                holder.button_pingjia= (Button) convertView.findViewById(R.id.button_pingjia);
                holder.button_tuihui= (Button) convertView.findViewById(R.id.button_tuihuo);




                convertView.setTag(holder);
            } else {
                holder= (ViewHolder) convertView.getTag();
            }
            isButton(holder.mbutton_pay,group.get(groupPosition).getPay_btn());
            isButton(holder.mbutton_cancle,group.get(groupPosition).getCancel_btn());
            isButton(holder.button_shouhuo,group.get(groupPosition).getReceive_btn());
            isButton(holder.button_pingjia,group.get(groupPosition).getReturn_btn());
            isButton(holder.button_tuihui,group.get(groupPosition).getComment_btn());


            holder.mtextview_ordernumber.setText(group.get(groupPosition).getOrder_sn());
            holder.mtextview_allprice.setText("￥"+group.get(groupPosition).getGoods_price());
            holder.mbutton_cancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LogUtils.LOG("ceshi","取消被电击");
                    Map map_cancleorder=new HashMap();
                    map_cancleorder.put("order_id",group.get(groupPosition).getOrder_id()+"");
                    cancleOrder(map_cancleorder);

                }
            });
            holder.mbutton_pay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LogUtils.LOG("ceshi","pay被电击");
                    Intent intent_pay=new Intent(AllOrderActivity.this,PayActivity.class);
                    intent_pay.putExtra("ordernumber",group.get(groupPosition).getOrder_sn()+"");
                    intent_pay.putExtra("price",""+group.get(groupPosition).getGoods_price());
                    intent_pay.putExtra("type","dingdan");
                    startActivity(intent_pay);
                }
            });
            return convertView;
        }

        @Override
        public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ViewHolder holder=null;
            final AllOrderBean.ResultBean.GoodsListBean childrenBean=children.get(groupPosition).get(childPosition);
            if (convertView == null) {
                holder=new ViewHolder();
                convertView = mLayoutInflater.inflate(R.layout.item_allorder_children, parent, false);
                holder.mlinearlayout_chilren= (LinearLayout) convertView.findViewById(R.id.linrealayout_chgliren);
                holder.mtextview_goodname= (TextView) convertView.findViewById(R.id.textview_goodsname);
                holder.mtextview_goodnum= (TextView) convertView.findViewById(R.id.textview_number);
                holder.mtextview_goodprice= (TextView) convertView.findViewById(R.id.textview_goodsprice);
                holder.mimage_good= (ImageView) convertView.findViewById(R.id.image_goodsPIC);
                convertView.setTag(holder);
            } else {
                holder= (ViewHolder) convertView.getTag();
            }
            Glide.with(AllOrderActivity.this).load(BaseUrl.Baseimage+childrenBean.getGoods_id()).into(holder.mimage_good);
            holder.mtextview_goodname.setText(childrenBean.getGoods_name());
            holder.mtextview_goodprice.setText("￥"+childrenBean.getGoods_price()+"元");
            holder.mtextview_goodnum.setText("×"+childrenBean.getGoods_num());
            holder.mlinearlayout_chilren.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent_order_detail=new Intent(AllOrderActivity.this,OrderDetail.class);
                    intent_order_detail.putExtra("orderid",childrenBean.getOrder_id()+"");
                    startActivity(intent_order_detail);
                }
            });
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }


        private class ViewHolder {
            TextView mtextview_ordernumber;
            TextView mtextview_allprice;
            Button mbutton_cancle;
            Button mbutton_pay,button_shouhuo,button_pingjia,button_tuihui;


            LinearLayout mlinearlayout_chilren;
            TextView mtextview_goodname;
            TextView mtextview_goodnum;
            TextView mtextview_goodprice;
            ImageView mimage_good;

        }
    }
}
