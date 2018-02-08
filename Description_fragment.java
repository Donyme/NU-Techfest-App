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

public class Description_fragment extends Fragment {



    @Nullable


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View RootView= inflater.inflate(R.layout.descriptions_fragment,container,false);
        TextView description1=(TextView)RootView.findViewById(R.id.desc);
        //Bundle bundle=getArguments();

       // description1.setText("Hey there ppl");
        //if(getArguments()!=null) {
        Competitions competitions=(Competitions)getActivity();
            description1.setText(competitions.getDesc());//getArguments().getString("description")
        //}

        return RootView;
    }


}
