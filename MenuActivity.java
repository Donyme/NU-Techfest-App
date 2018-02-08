package com.nu2k18.nitrutsav;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import com.nu2k18.nitrutsav.models.Users;
import com.nu2k18.nitrutsav.utils.Constants;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import github.hellocsl.cursorwheel.CursorWheelLayout;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, CursorWheelLayout.OnMenuSelectedListener {

    private int a = 1;
    private Boolean exit = false;
    private CircleImageView displayImageView;
    private TextView mNameTextView;
    private TextView mEmailTextView;
    private LinearLayout lr;
    String TAG = "TAG";

    CursorWheelLayout wheel_text,wheel_image;
    List<MenuItemData> lstText;
    List<ImageData> lstImage;
    public  int viewed=0;
    public int cur_pos=-1;
    FirebaseAuth mAuth;

    FrameLayout screenArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();

        //Toast.makeText(MenuActivity.this,"hey there",Toast.LENGTH_SHORT)

        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("NITRUTSAV");
        LayoutInflater inflater = LayoutInflater.from(this);
        View inflatedLayout= inflater.inflate(R.layout.activity_test, null, false);
        screenArea=findViewById(R.id.screen_area);
        screenArea.addView(inflatedLayout);

        initViews();
        loadData();



        wheel_image.setOnMenuSelectedListener(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View navHeaderView = navigationView.getHeaderView(0);
        displayImageView = (CircleImageView) navHeaderView.findViewById(R.id.profile_image);
        //final CircleImageView displayImageView=(CircleImageView)findViewById(R.id.profile_image);
        mNameTextView = (TextView) navHeaderView.findViewById(R.id.name);
        mEmailTextView = (TextView) navHeaderView.findViewById(R.id.mail);

        FirebaseDatabase.getInstance().getReference(Constants.USER_KEY).child(mAuth.getCurrentUser().getEmail().replace(".", ","))
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.getValue() != null) {
                            Users users = dataSnapshot.getValue(Users.class);
                            Glide.with(MenuActivity.this)
                                    .load(users.getPhotoUrl())
                                    .into(displayImageView);

                            mNameTextView.setText(users.getUser());
                            mEmailTextView.setText(users.getEmail());
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



        Button b11=(Button)findViewById(R.id.register);
        b11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent viewIntent =
                        new Intent("android.intent.action.VIEW",
                                Uri.parse("http://nitrutsav.nitrkl.ac.in/login.php"));
                startActivity(viewIntent);
            }
        });
    }

    private void initViews() {
        wheel_image=(CursorWheelLayout)findViewById(R.id.wheel_image);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(a==1)
            {
                if (exit) {
                 moveTaskToBack(true); // finish activity
                } else {
                    Toast.makeText(this, "Press Back again to Exit.",
                            Toast.LENGTH_SHORT).show();
                    exit = true;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            exit = false;
                        }
                    }, 3 * 1000);
                }

            }
            else
            {
                a=1;
                startActivity(new Intent(this,MenuActivity.class));
            }

        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment=null;
        int id = item.getItemId();

        if (id == R.id.home) {
            a=1;
            startActivity(new Intent(this,MenuActivity.class));

        }

        else{
           screenArea.removeAllViews();

            if (id == R.id.accessibility) {
                //fragment=new Fragment_accessibility();
                a=0;
                fragment = new Fragment_accessibility();

            } else if (id == R.id.hospitality) {
                a=0;
                fragment=new Fragment_hospitality();

            }  else if (id == R.id.faq) {
                a=0;
                fragment=new Fragment_faq();

            } else if (id == R.id.privacy) {
                a=0;
                fragment=new Fragment_privacy();

            }else if (id == R.id.contact) {
                a=0;
                fragment=new Fragment_contact();

            }else if (id == R.id.maps) {
                a=0;
                startActivity(new Intent(this,Maps.class));

            }else if (id == R.id.updates) {
                a=0;
                startActivity(new Intent(this,Updates.class));

            }else if (id == R.id.logout) {
                mAuth=FirebaseAuth.getInstance();
                mAuth.signOut();
                startActivity(new Intent(this,MainActivity.class));
                finish();
            }

        }
        if(fragment!=null && id!=R.id.home && id!=R.id.logout)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction ft= fragmentManager.beginTransaction();
            ft.replace(R.id.screen_area,fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadData() {
        lstImage=new ArrayList<>();


        lstImage.add(new ImageData(R.drawable.workshop,"Workshops and Exhibitions"));
        lstImage.add(new ImageData(R.drawable.proshow,"Proshows"));
        lstImage.add(new ImageData(R.drawable.comp,"Competition"));
        lstImage.add(new ImageData(R.drawable.musical,"Musical Night"));
        lstImage.add(new ImageData(R.drawable.flagship,"Flagships"));
        lstImage.add(new ImageData(R.drawable.fun,"Fun Events"));
        WheelImageAdapter imgAdapter=new WheelImageAdapter(getBaseContext(),lstImage);
        wheel_image.setAdapter(imgAdapter);
    }

    @Override
    public void onItemSelected(CursorWheelLayout parent, View view, final int pos) {

        cur_pos=-1;


       // TextView main_text=(TextView)findViewById(R.id.main_text);
        Button b = (Button) findViewById(R.id.enter);
        if(parent.getId()==R.id.wheel_image) {
           /* if (viewed == 0)//&& pos==0)
            {
                viewed = 1;
                return;
            }*/

            if (pos == 0) {
                b.setText("Enter Workshops and Exhibitions");
                cur_pos = 0;
                //startActivity(new Intent(this,Workshops.class));
            } else if (pos == 1) {
                b.setText("Enter Proshows");
                cur_pos = 1;
                //startActivity(new Intent(this,Proshows.class));
            } else if (pos == 2) {
                b.setText("Enter Competitions");
                cur_pos = 2;
                //startActivity(new Intent(this,Events.class));
            } else if (pos == 3) {
                b.setText("Enter Musical Night");
                cur_pos = 3;
                //startActivity(new Intent(this,Musical_night.class));
            } else if (pos == 4) {
                b.setText("Enter Flagships");
                cur_pos = 4;
                //startActivity(new Intent(this, Flagships.class));
            } else if (pos == 5) {
                b.setText("Enter Fun Events");
                cur_pos = 5;
                //startActivity(new Intent(this,Exhibition.class));
            }


            if (cur_pos == 0) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MenuActivity.this, Workshops.class));
                    }
                });
            }
            if (cur_pos == 1) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MenuActivity.this, Proshows.class));
                    }
                });
            }
            if (cur_pos == 2) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MenuActivity.this, Events.class));
                    }
                });
            }
            if (cur_pos == 3) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MenuActivity.this, Musical_night.class));
                    }
                });
            }
            if (cur_pos == 4) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MenuActivity.this, Flagships.class));
                    }
                });
            }
            if (cur_pos == 5) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MenuActivity.this, Exhibition.class));
                    }
                });
            }
        }

    }


}
