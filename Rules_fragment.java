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

public class Rules_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View RootView=inflater.inflate(R.layout.rules_fragment,container,false);
        TextView rules=(TextView)RootView.findViewById(R.id.rules);


        Competitions competitions=(Competitions)getActivity();
        rules.setText(competitions.getRules());


        return RootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }
}
