package cn.kymart.tptp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.kymart.tptp.R;

/**
 * Created by PC on 2017/6/6.
 */

public class Fragment_classification extends Fragment{
    View  rootview;



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.fragment_classification,container,false);






        return rootview;
    }
}
