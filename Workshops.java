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

public class Workshops extends AppCompatActivity {

    GridLayout mainGrid1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshops);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar_flag);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        }
        getSupportActionBar().setTitle("Workshops and Exhibitions");


        mainGrid1=(GridLayout)findViewById(R.id.mainGrid5);

        setSingleEvent(mainGrid1);
        ImageView flag1=(ImageView)findViewById(R.id.flag1);
        ImageView flag2=(ImageView)findViewById(R.id.flag2);
        ImageView flag3=(ImageView)findViewById(R.id.flag3);
        ImageView flag4=(ImageView)findViewById(R.id.flag4);

        String url1="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/scribbled.png?alt=media&token=9d226387-eacd-4bd5-88fd-feb9add72abc";
        Glide.with(getApplicationContext()).load(url1).placeholder(R.drawable.logo_alt).into(flag1);

        String url2="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/pallete.jpg?alt=media&token=3d17ff97-ec36-451b-93b1-030ac8cd370e";
        Glide.with(getApplicationContext()).load(url2).placeholder(R.drawable.logo_alt).into(flag2);

        String url3="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/candida.jpeg?alt=media&token=c7b6bcb0-3758-4a20-a780-5c3c10350d95";
        Glide.with(getApplicationContext()).load(url3).placeholder(R.drawable.logo_alt).into(flag3);

        String url4="https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/bharadwaj.jpeg?alt=media&token=5fb21806-1359-446a-9ee1-ccc2e105bdbe";
        Glide.with(getApplicationContext()).load(url4).placeholder(R.drawable.logo_alt).into(flag4);
    }

    private void setSingleEvent(GridLayout mainGrid) {


        String[] heading={"The ScribbledStories","Pallete","MS. CANDIDA LOUIS","MR. BHARADWAJ DAYALA"};
        String[] heading1={"3rd Feb","3rd-5th Feb","4th Feb","3rd Feb"};
        String[] imagename={"https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/scribbled.png?alt=media&token=9d226387-eacd-4bd5-88fd-feb9add72abc","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/pallete.jpg?alt=media&token=3d17ff97-ec36-451b-93b1-030ac8cd370e","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/candida.jpeg?alt=media&token=c7b6bcb0-3758-4a20-a780-5c3c10350d95","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/bharadwaj.jpeg?alt=media&token=5fb21806-1359-446a-9ee1-ccc2e105bdbe"};
        String[] description={getString(R.string.TSS_d),getString(R.string.Pallete_d),getString(R.string.candida_d),getString(R.string.bharadwaj_d)};
        String[] rules={getString(R.string.TSS_r),getString(R.string.Pallete_r),"",""};
        String[] judging={getString(R.string.TSS_j),getString(R.string.Pallete_j),"",""};
        String[] venue={getString(R.string.TSS_v),getString(R.string.Pallete_v),getString(R.string.candida_v),getString(R.string.bharadwaj_v)};
        String[] date={getString(R.string.TSS_dt),getString(R.string.Pallete_dt),getString(R.string.candida_dt),getString(R.string.bharadwaj_dt)};
        String[] coordinators={getString(R.string.TSS_co),getString(R.string.Pallete_co),getString(R.string.candida_co),getString(R.string.bharadwaj_co)};
        String[] lat={getString(R.string.MECH),getString(R.string.RMH),getString(R.string.MECH),getString(R.string.MECH)};

        for(int i=0;i<mainGrid.getChildCount();i++)
        {
            CardView cardview=(CardView)mainGrid.getChildAt(i);
            final int p=i;
            final String[] arr={heading[i],imagename[i],description[i],rules[i],judging[i],venue[i],date[i],coordinators[i],lat[i],heading1[i]};
            cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(Workshops.this,Competitions.class).putExtra("arg",arr));
                }
            });
        }


    }
}
