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
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Flagships extends AppCompatActivity {

    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flagships);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_flag);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        }
        getSupportActionBar().setTitle("Flagships");

        mainGrid=(GridLayout)findViewById(R.id.mainGrid);

        setSingleEvent(mainGrid);
        ImageView flag1=(ImageView)findViewById(R.id.flag1);
        ImageView flag2=(ImageView)findViewById(R.id.flag2);
        ImageView flag3=(ImageView)findViewById(R.id.flag3);
        ImageView flag4=(ImageView)findViewById(R.id.flag4);
        ImageView flag5=(ImageView)findViewById(R.id.flag5);
        ImageView flag6=(ImageView)findViewById(R.id.flag6);
        ImageView flag7=(ImageView)findViewById(R.id.flag7);
        ImageView flag8=(ImageView)findViewById(R.id.flag8);
        ImageView flag9=(ImageView)findViewById(R.id.flag9);

        String url1="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Qurios%20v2.jpg?alt=media&token=ae1db6ff-bf26-40d6-8b0f-83bdb81e219f";
        Glide.with(getApplicationContext()).load(url1).placeholder(R.drawable.logo_alt).into(flag1);

        String url2="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Maktub.jpg?alt=media&token=c1635360-9ed4-4e67-97a1-bd216353689f";
        Glide.with(getApplicationContext()).load(url2).placeholder(R.drawable.logo_alt).into(flag2);

        String url3="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Spic.jpeg?alt=media&token=7b786db0-ab3d-4be7-9a19-962b49912435";
        Glide.with(getApplicationContext()).load(url3).placeholder(R.drawable.logo_alt).into(flag3);

        String url4="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/nukkad1.jpg?alt=media&token=d912eaf2-1bd7-4000-8d9b-8fc8469d15ca";
        Glide.with(getApplicationContext()).load(url4).placeholder(R.drawable.logo_alt).into(flag4);

        String url5="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Fashionista.jpg?alt=media&token=aa2c3b35-15b7-410e-9df5-10cc989ef19b";
        Glide.with(getApplicationContext()).load(url5).placeholder(R.drawable.logo_alt).into(flag5);

        String url6="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/UYC.jpg?alt=media&token=d8c97826-e901-498f-bab5-f08634bd1864";
        Glide.with(getApplicationContext()).load(url6).placeholder(R.drawable.logo_alt).into(flag6);

        String url7="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Voice.jpg?alt=media&token=e898134d-2411-495c-bb05-086a73e5b591";
        Glide.with(getApplicationContext()).load(url7).placeholder(R.drawable.logo_alt).into(flag7);

        String url8="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Footloose.jpg?alt=media&token=6e00e990-6e16-4306-a540-8e79bbf0c0d6";
        Glide.with(getApplicationContext()).load(url8).placeholder(R.drawable.logo_alt).into(flag8);

        String url9="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Roadies.jpg?alt=media&token=4addeb9c-f150-4b60-a610-20fcbdb6f30d";
        Glide.with(getApplicationContext()).load(url9).placeholder(R.drawable.logo_alt).into(flag9);
    }

    private void setSingleEvent(GridLayout mainGrid) {


        String[] heading={"Qurios","Maktub","Spic Macay","Nukkad","Fashionista","UYC","Voice of NU","FootLoose","NITR Roadies9.0"};
        String[] heading1={"4th Feb","2nd Feb","2nd Feb","3rd Feb","2nd Feb","3rd Feb","4th Feb","3rd Feb","3rd Feb",};
        String[] imagename={"https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Qurios%20v2.jpg?alt=media&token=ae1db6ff-bf26-40d6-8b0f-83bdb81e219f","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Maktub.jpg?alt=media&token=c1635360-9ed4-4e67-97a1-bd216353689f","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Spic.jpeg?alt=media&token=7b786db0-ab3d-4be7-9a19-962b49912435","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/nukkad1.jpg?alt=media&token=d912eaf2-1bd7-4000-8d9b-8fc8469d15ca","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Fashionista.jpg?alt=media&token=5dd3bb7b-faff-4054-8732-e0dfef149e2e","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/UYC.jpg?alt=media&token=d8c97826-e901-498f-bab5-f08634bd1864","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Voice.jpg?alt=media&token=6de1cf8f-9463-4914-b371-bea13bf21bc6","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Footloose.jpg?alt=media&token=1eef1000-099f-4e48-bbd9-38dc814afaa8","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Roadies.jpg?alt=media&token=4addeb9c-f150-4b60-a610-20fcbdb6f30d",};
        String[] description={getString(R.string.Qurios_d),getString(R.string.Maktub_d),getString(R.string.spic_macay_d),getString(R.string.Nukkad_d),getString(R.string.Fashionista_d),getString(R.string.UYC_d),getString(R.string.Voice_d),getString(R.string.footloose_d),getString(R.string.Roadies_d)};
        String[] rules={getString(R.string.Qurios_r),"","",getString(R.string.Nukkad_r),getString(R.string.Fashionista_r),getString(R.string.UYC_r),getString(R.string.Voice_r),getString(R.string.footloose_r),getString(R.string.Roadies_r)};
        String[] judging={getString(R.string.Qurios_j),"","",getString(R.string.Nukkad_j),getString(R.string.Fashionista_j),getString(R.string.UYC_j),getString(R.string.Voice_j),getString(R.string.footloose_j),getString(R.string.Roadies_j)};
        String[] venue={getString(R.string.Qurios_v),getString(R.string.Maktub_v),getString(R.string.spic_macay_v),getString(R.string.Nukkad_v),getString(R.string.Fashionista_v),getString(R.string.UYC_v),getString(R.string.Voice_v),getString(R.string.footloose_v),getString(R.string.Roadies_v)};
        String[] date={getString(R.string.Qurios_dt),getString(R.string.Maktub_dt),getString(R.string.spic_macay_dt),getString(R.string.Nukkad_dt),getString(R.string.Fashionista_dt),getString(R.string.UYC_dt),getString(R.string.Voice_dt),getString(R.string.footloose_dt),getString(R.string.Roadies_dt)};
        String[] coordinators={getString(R.string.Qurios_co),getString(R.string.Maktub_co),getString(R.string.spic_macay_co),getString(R.string.Nukkad_co),getString(R.string.Fashionista_co),getString(R.string.UYC_co),getString(R.string.Voice_co),getString(R.string.footloose_co),getString(R.string.Roadies_co)};
        String[] lat={getString(R.string.BBA),getString(R.string.LA_lawns),getString(R.string.BBA),getString(R.string.SAC),getString(R.string.DTS),getString(R.string.TNP),getString(R.string.BBA),getString(R.string.BBA),getString(R.string.MAIN)};
        for(int i=0;i<mainGrid.getChildCount();i++)
        {
            CardView cardview=(CardView)mainGrid.getChildAt(i);
            final int p=i;
            final String[] arr={heading[i],imagename[i],description[i],rules[i],judging[i],venue[i],date[i],coordinators[i],lat[i],heading1[i]};
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Flagships.this,Competitions.class).putExtra("arg",arr));
                }
            });
        }


    }
}
