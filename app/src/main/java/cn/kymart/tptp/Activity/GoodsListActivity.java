package cn.kymart.tptp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.Adapter.Adapter_Grid_goodsList;
import cn.kymart.tptp.Bean.Goods_ListBean;
import cn.kymart.tptp.CustomView.MyGridView;
import cn.kymart.tptp.Http.BaseUrl;
import cn.kymart.tptp.Interface.Interface_volley_respose;
import cn.kymart.tptp.R;
import cn.kymart.tptp.Utils.Volley_Utils;

public class GoodsListActivity extends BaseActivityother {
    private RelativeLayout mRelativeLayout_Latest, mRelativeLayout_Sales, mRelativeLayout_Price, mRelativeLayout_Comments;
    private MyGridView mGridview;
    private TextView mTextVIew_loadMore;


    private List<Goods_ListBean.ResultBean.GoodsListBean> mDate;
    private Goods_ListBean.ResultBean  resultBean;
    private Adapter_Grid_goodsList mAdapter;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_goods_list;
    }

    @Override
    protected void setData() {
        requestData(page);

    }


    String url="/index.php/api/Goods/goodsList/id/1/sort/is_new/sort_asc/desc/p/";
    int page=1;
    void requestData(final int page ){
        String URL=BaseUrl.BasegoodlistURL+url+page;

        new Volley_Utils(new Interface_volley_respose() {
            @Override
            public void onSuccesses(String respose) {
                resultBean=new Gson().fromJson(respose,Goods_ListBean.class).getResult();
                if(page==1){
                    mDate.clear();
                    mDate.addAll(resultBean.getGoods_list());
                    mAdapter.notifyDataSetChanged();
                }else{
                    mDate.addAll(resultBean.getGoods_list());
                    mAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onError(int error) {

            }
        }).Http(URL,this,0);

    }

    @Override
    protected void initData() {

        mDate=new ArrayList<>();
        mAdapter=new Adapter_Grid_goodsList(mDate,this);
        mGridview.setAdapter(mAdapter);
    }

    @Override
    protected void initListener() {
        mRelativeLayout_Latest.setOnClickListener(this);
        mRelativeLayout_Sales.setOnClickListener(this);
        mRelativeLayout_Price.setOnClickListener(this);
        mRelativeLayout_Comments.setOnClickListener(this);
        mTextVIew_loadMore.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        mRelativeLayout_Latest = (RelativeLayout) findViewById(R.id.RelativeLayout_Latest);
        mRelativeLayout_Sales = (RelativeLayout) findViewById(R.id.RelativeLayout_Sales);
        mRelativeLayout_Price = (RelativeLayout) findViewById(R.id.RelativeLayout_Price);
        mRelativeLayout_Comments = (RelativeLayout) findViewById(R.id.RelativeLayout_Comments);
        mGridview= (MyGridView) findViewById(R.id.GridView_goodslist);
        mTextVIew_loadMore= (TextView) findViewById(R.id.textview_loadmore);
        mRelativeLayout_Latest.setSelected(true);//初始最新  设为选中

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        initButton();
        switch (v.getId()) {
            case R.id.RelativeLayout_Latest:
                mRelativeLayout_Latest.setSelected(true);
                url=resultBean.getOrderby_is_new()+"/p/";
                page=1;
                requestData(1);

                break;
            case R.id.RelativeLayout_Sales:
                mRelativeLayout_Sales.setSelected(true);
                url=resultBean.getOrderby_sales_sum()+"/p/";
                page=1;
                requestData(1);
                break;
            case R.id.RelativeLayout_Price:
                mRelativeLayout_Price.setSelected(true);
                url=resultBean.getOrderby_price()+"/p/";
                page=1;
                requestData(1);
                break;
            case R.id.RelativeLayout_Comments:
                mRelativeLayout_Comments.setSelected(true);
                url=resultBean.getOrderby_comment_count()+"/p/";
                page=1;
                requestData(1);
                break;
            case R.id.textview_loadmore://加载更多
                requestData(++page);
                break;

        }
    }

    void initButton() {
        mRelativeLayout_Latest.setSelected(false);
        mRelativeLayout_Sales.setSelected(false);
        mRelativeLayout_Price.setSelected(false);
        mRelativeLayout_Comments.setSelected(false);

    }
}
