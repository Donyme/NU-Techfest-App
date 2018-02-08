package com.nu2k18.nitrutsav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;

public class Test extends AppCompatActivity implements CursorWheelLayout.OnMenuSelectedListener{

    CursorWheelLayout wheel_text,wheel_image;
    List<MenuItemData> lstText;
    List<ImageData> lstImage;
    public  int viewed=0;
    public int cur_pos=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initViews();
        loadData();

        wheel_image.setOnMenuSelectedListener(this);
    }

    private void loadData() {
        lstImage=new ArrayList<>();


        lstImage.add(new ImageData(R.drawable.ic_launcher,"Workshops"));
        lstImage.add(new ImageData(R.drawable.ic_launcher,"Proshows"));
        lstImage.add(new ImageData(R.drawable.ic_launcher,"Competition"));
        lstImage.add(new ImageData(R.drawable.ic_launcher,"Musical Night"));
        lstImage.add(new ImageData(R.drawable.ic_launcher,"Flagships"));
        lstImage.add(new ImageData(R.drawable.ic_launcher,"Exhibitions"));
        WheelImageAdapter imgAdapter=new WheelImageAdapter(getBaseContext(),lstImage);
        wheel_image.setAdapter(imgAdapter);
    }

    private void initViews() {
        //wheel_image= (CursorWheelLayout)findViewById(R.id.wheel_image);
        wheel_image=(CursorWheelLayout)findViewById(R.id.wheel_image);
        

    }


    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, final int pos) {

        cur_pos=-1;


       /* TextView main_text=(TextView)findViewById(R.id.main_text);
        if(parent.getId()==R.id.wheel_image) {
           /* if (viewed == 0)//&& pos==0)
            {
                viewed = 1;
                return;
            }*/
/*
            if (pos == 0) {
                main_text.setText("Workshops");
                cur_pos = 0;
                //startActivity(new Intent(this,Workshops.class));
            } else if (pos == 1) {
                main_text.setText("Proshows");
                cur_pos = 1;
                //startActivity(new Intent(this,Proshows.class));
            } else if (pos == 2) {
                main_text.setText("Competitions");
                cur_pos = 2;
                //startActivity(new Intent(this,Events.class));
            } else if (pos == 3) {
                main_text.setText("Musical Night");
                cur_pos = 3;
                //startActivity(new Intent(this,Musical_night.class));
            } else if (pos == 4) {
                main_text.setText("Flagships");
                cur_pos = 4;
                //startActivity(new Intent(this, Flagships.class));
            } else if (pos == 5) {
                main_text.setText("Exhibitions");
                cur_pos = 5;
                //startActivity(new Intent(this,Exhibition.class));
            }
            */
            Button b = (Button) findViewById(R.id.enter);
            if (cur_pos == 0) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Test.this, Workshops.class));
                    }
                });
            }
            if (cur_pos == 1) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Test.this, Proshows.class));
                    }
                });
            }
            if (cur_pos == 2) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Test.this, Events.class));
                    }
                });
            }
            if (cur_pos == 3) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Test.this, Musical_night.class));
                    }
                });
            }
            if (cur_pos == 4) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Test.this, Flagships.class));
                    }
                });
            }
            if (cur_pos == 5) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(Test.this, Exhibition.class));
                    }
                });
            }
        }
       /* view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pos==cur_pos)
                {
                    Toast.makeText(Test.this, cur_pos+"", Toast.LENGTH_SHORT).show();

                }
            }
        });*/
    }


