package com.nu2k18.nitrutsav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Proshows extends AppCompatActivity {

    GridLayout mainGrid1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proshows);


        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_flag);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        }
        getSupportActionBar().setTitle("Proshows");




    }

}
