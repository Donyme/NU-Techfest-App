package com.nu2k18.nitrutsav;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.tag;

public class Competitions extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    private String[] received;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competitions);
        received = getIntent().getStringArrayExtra("arg");


        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new Description_fragment(), "Description");
        adapter.addFrag(new Rules_fragment(), "Rules");
        adapter.addFrag(new Judging_fragment(), "Judging Criteria");

        viewPager.setAdapter(adapter);

        TabLayout mTabLayout = (TabLayout) findViewById(R.id.pager_header);
        mTabLayout.setupWithViewPager(viewPager);

        //coordinates received: received[8],received[9]
        FloatingActionButton floatingActionButton=(FloatingActionButton)findViewById(R.id.floatingActionButton);
        final String x=received[8];
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q="+x+"&mode=w");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
       });


        TextView heading=(TextView)findViewById(R.id.comp_heading);
        TextView date=(TextView)findViewById(R.id.comp_date);
        TextView time=(TextView)findViewById(R.id.comp_time);
        TextView coordinators=(TextView)findViewById(R.id.comp_coordinators);
        TextView venue=(TextView)findViewById(R.id.comp_venue);

        heading.setText(received[0]);
        date.setText("Time: "+received[6]);
        coordinators.setText("Coordinators: "+received[7]);
        venue.setText("Venue: "+received[5]);
        time.setText("Date: "+received[9]);

        ImageView imgv=(ImageView)findViewById(R.id.comp_image);
        String uri="@drawable/";
       // uri=uri+received[1];
        /*int imageid=getResources().getIdentifier(uri, null, getPackageName());
        Drawable res= getResources().getDrawable(imageid);
        imgv.setImageDrawable(res);
        */
        String url=received[1];
        Glide.with(getApplicationContext()).load(url).placeholder(R.drawable.logo_alt).into(imgv);
    }

    public String getDesc()
    {
        return received[2];
    }

    public String getRules()
    {
        return received[3];
    }

    public String getJudging()
    {
        return received[4];
    }
    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Description_fragment();
                case 1:
                    return new Rules_fragment();
                case 2:
                    return new Judging_fragment();
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
