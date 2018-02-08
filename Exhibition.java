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

public class Exhibition extends AppCompatActivity {

    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exhibition);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_flag);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        }
        getSupportActionBar().setTitle("Fun Events");

        mainGrid=(GridLayout)findViewById(R.id.mainGrid3);

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
        ImageView flag10=(ImageView)findViewById(R.id.flag10);
        ImageView flag11=(ImageView)findViewById(R.id.flag11);
        ImageView flag12=(ImageView)findViewById(R.id.flag12);

        String url1="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Futsal.jpg?alt=media&token=da901f3b-54b2-47c3-841e-0facf6306511";
        Glide.with(getApplicationContext()).load(url1).placeholder(R.drawable.logo_alt).into(flag1);

        String url2="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Blind.jpg?alt=media&token=b461d026-325c-4231-a8e7-edad1d931801";
        Glide.with(getApplicationContext()).load(url2).placeholder(R.drawable.logo_alt).into(flag2);

        String url3="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Karaoke.jpg?alt=media&token=4024acf9-15f3-4840-b8ad-2e7f16a89246";
        Glide.with(getApplicationContext()).load(url3).placeholder(R.drawable.logo_alt).into(flag3);

        String url4="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Paintball.jpg?alt=media&token=1a08384d-8030-4f9b-b7d2-f0d9f55dc287";
        Glide.with(getApplicationContext()).load(url4).placeholder(R.drawable.logo_alt).into(flag4);

        String url5="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Paper.jpg?alt=media&token=fa3e48b4-df08-4ed5-823d-98411f25a9a7";
        Glide.with(getApplicationContext()).load(url5).placeholder(R.drawable.logo_alt).into(flag5);

        String url6="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Face%20painting1.jpg?alt=media&token=e264beb6-4125-4ada-9c80-581c1069b410";
        Glide.with(getApplicationContext()).load(url6).placeholder(R.drawable.logo_alt).into(flag6);

        String url7="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Splitsvilla.jpg?alt=media&token=68c2945e-4636-4b4c-9565-7a5539f59792";
        Glide.with(getApplicationContext()).load(url7).placeholder(R.drawable.logo_alt).into(flag7);

        String url8="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Tug.jpg?alt=media&token=0e5fec75-12a0-4d38-886b-269104ff538f";
        Glide.with(getApplicationContext()).load(url8).placeholder(R.drawable.logo_alt).into(flag8);

        String url9="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Miss1.jpg?alt=media&token=44e40bd5-980f-41f0-9881-99fa4d9b403d";
        Glide.with(getApplicationContext()).load(url9).placeholder(R.drawable.logo_alt).into(flag9);

        String url0="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Waterpolo.jpg?alt=media&token=90ac44eb-c1f7-416b-b280-1952dfaa2437";
        Glide.with(getApplicationContext()).load(url0).placeholder(R.drawable.logo_alt).into(flag10);

        String url11="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Meltdown.jpg?alt=media&token=6235d28f-8182-46cc-8c9a-199cc92442f9";
        Glide.with(getApplicationContext()).load(url11).placeholder(R.drawable.logo_alt).into(flag11);

        String url12="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Prom.jpg?alt=media&token=118e9116-0422-4612-9400-6d722c671f0a";
        Glide.with(getApplicationContext()).load(url2).placeholder(R.drawable.logo_alt).into(flag12);

    }

    private void setSingleEvent(GridLayout mainGrid) {


        String[] heading={"Futsal","Blind-date","Karaoke","Paintball","Paper Dance","Face Painting","Splitsvilla","Tug-of-war","Mr and Miss NU","Water Polo","Ultra Mega MeltDown","Prom Night"};
        String[] heading1={"3rd-4th Feb","3rd Feb","3rd - 4th Feb","3rd - 4th Feb","3rd Feb","4th Feb","4th Feb","3rd Feb","3rd Feb","3rd - 4th Feb","3rd - 4th Feb","3rd Feb"};
        String[] imagename={"https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Futsal.jpg?alt=media&token=da901f3b-54b2-47c3-841e-0facf6306511","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Blind.jpg?alt=media&token=b461d026-325c-4231-a8e7-edad1d931801","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Karaoke.jpg?alt=media&token=4024acf9-15f3-4840-b8ad-2e7f16a89246","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Paintball.jpg?alt=media&token=1a08384d-8030-4f9b-b7d2-f0d9f55dc287","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Paper.jpg?alt=media&token=fa3e48b4-df08-4ed5-823d-98411f25a9a7","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Face%20painting1.jpg?alt=media&token=e264beb6-4125-4ada-9c80-581c1069b410","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Splitsvilla.jpg?alt=media&token=68c2945e-4636-4b4c-9565-7a5539f59792","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Tug.jpg?alt=media&token=0e5fec75-12a0-4d38-886b-269104ff538f","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Miss1.jpg?alt=media&token=44e40bd5-980f-41f0-9881-99fa4d9b403d","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Waterpolo.jpg?alt=media&token=90ac44eb-c1f7-416b-b280-1952dfaa2437","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Meltdown.jpg?alt=media&token=6235d28f-8182-46cc-8c9a-199cc92442f9","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Prom.jpg?alt=media&token=118e9116-0422-4612-9400-6d722c671f0a"};
        String[] description={getString(R.string.Futsal_d),getString(R.string.Blind_d),getString(R.string.Karaoke_d),getString(R.string.Paint_ball_d),getString(R.string.paper_dance_d),getString(R.string.face_painting_d),getString(R.string.Splitsvilla_d),getString(R.string.tug_war_d),"","","",""};
        String[] rules={getString(R.string.Futsal_r),getString(R.string.Blind_r),getString(R.string.Karaoke_r),getString(R.string.Painting_ball_r),getString(R.string.paper_dance_r),getString(R.string.face_painting_r),getString(R.string.Splitsvilla_r),getString(R.string.tug_war_r),"","","",""};
        String[] judging={getString(R.string.Futsal_j),getString(R.string.Blind_j),getString(R.string.Karaoke_j),getString(R.string.Painting_ball_j),getString(R.string.paper_dance_j),getString(R.string.face_painting_j),getString(R.string.Splitsvilla_j),getString(R.string.tug_war_j),"","","",""};
        String[] venue={getString(R.string.Futsal_v),getString(R.string.Blind_v),getString(R.string.Karaoke_v),getString(R.string.Painting_ball_v),getString(R.string.paper_dance_v),getString(R.string.face_painting_v),getString(R.string.Splitsvilla_v),getString(R.string.tug_war_v),"MAIN BUILDING","SWIMMING POOL","NCC GROUND","SAC"};
        String[] date={getString(R.string.Futsal_dt),getString(R.string.Blind_dt),getString(R.string.Karaoke_dt),getString(R.string.Painting_ball_dt),getString(R.string.paper_dance_dt),getString(R.string.face_painting_dt),getString(R.string.Splitsvilla_dt),getString(R.string.tug_war_dt),"10:a.m.","9:00AM","9:00AM","5:30PM"};
        String[] coordinators={getString(R.string.Futsal_co),getString(R.string.Blind_co),getString(R.string.Karaoke_co),getString(R.string.Painting_ball_co),getString(R.string.paper_dance_co),getString(R.string.face_painting_co),getString(R.string.Splitsvilla_co),getString(R.string.tug_war_co),getString(R.string.msnu_co),getString(R.string.water_co),getString(R.string.umd_co),getString(R.string.prom_co)};
        String[] lat={getString(R.string.NCCG),getString(R.string.SAC),getString(R.string.SAC),getString(R.string.NCCG),getString(R.string.SAC),getString(R.string.SAC),getString(R.string.NCCG),getString(R.string.NCCG),getString(R.string.MAIN),getString(R.string.Swimming_pool),getString(R.string.NCCG),getString(R.string.SAC)};
        for(int i=0;i<mainGrid.getChildCount();i++)
        {
            CardView cardview=(CardView)mainGrid.getChildAt(i);
            final int p=i;
            final String[] arr={heading[i],imagename[i],description[i],rules[i],judging[i],venue[i],date[i],coordinators[i],lat[i],heading1[i]};
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Exhibition.this,Competitions.class).putExtra("arg",arr));
                }
            });
        }


    }
}
