package cn.kymart.tptp.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import cn.kymart.tptp.Adapter.Adapter_Grid_goodsList;
import cn.kymart.tptp.R;

public class GoodsListActivity extends BaseActivityother {
    private RelativeLayout mRelativeLayout_Latest, mRelativeLayout_Sales, mRelativeLayout_Price, mRelativeLayout_Comments;
    private GridView mGridview;
    private List<String> mDate;
    private Adapter_Grid_goodsList mAdapter;


    @Override
    public int setLayoutResID() {
        return R.layout.activity_goods_list;
    }

    @Override
    protected void setData() {


    }

    @Override
    protected void initData() {

        mDate=new ArrayList<>();
        mDate.add("sadfsdf");
        mDate.add("sadfsdf");
        mDate.add("sadfsdf");
        mDate.add("sadfsdf");
        mDate.add("sadfsdf");
        mDate.add("sadfsdf");
        mAdapter=new Adapter_Grid_goodsList(mDate,this);
        mGridview.setAdapter(mAdapter);
    }

    @Override
    protected void initListener() {
        mRelativeLayout_Latest.setOnClickListener(this);
        mRelativeLayout_Sales.setOnClickListener(this);
        mRelativeLayout_Price.setOnClickListener(this);
        mRelativeLayout_Comments.setOnClickListener(this);

    }

    @Override
    protected void initView() {
        mRelativeLayout_Latest = (RelativeLayout) findViewById(R.id.RelativeLayout_Latest);
        mRelativeLayout_Sales = (RelativeLayout) findViewById(R.id.RelativeLayout_Sales);
        mRelativeLayout_Price = (RelativeLayout) findViewById(R.id.RelativeLayout_Price);
        mRelativeLayout_Comments = (RelativeLayout) findViewById(R.id.RelativeLayout_Comments);
        mGridview= (GridView) findViewById(R.id.GridView_goodslist);

        mRelativeLayout_Latest.setSelected(true);//初始最新  设为选中

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        initButton();
        switch (v.getId()) {
            case R.id.RelativeLayout_Latest:
                mRelativeLayout_Latest.setSelected(true);
                break;
            case R.id.RelativeLayout_Sales:
                mRelativeLayout_Sales.setSelected(true);

                break;
            case R.id.RelativeLayout_Price:
                mRelativeLayout_Price.setSelected(true);
                break;
            case R.id.RelativeLayout_Comments:
                mRelativeLayout_Comments.setSelected(true);
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
