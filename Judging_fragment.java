package com.nu2k18.nitrutsav;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SUBAS on 10-01-2018.
 */

public class Judging_fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View RootView=inflater.inflate(R.layout.judging_fragment,container,false);
        TextView judging=(TextView)RootView.findViewById(R.id.judging);
        Competitions competitions=(Competitions)getActivity();

        judging.setText(competitions.getJudging());


        return RootView;
    }


}
