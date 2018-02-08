package com.nu2k18.nitrutsav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Updates extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter1;
    private List<Update_item> updateitems;
    FirebaseDatabase FDB;
    DatabaseReference DBR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates);


        recyclerView= (RecyclerView)findViewById(R.id.recyclerView1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(false);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        }
        getSupportActionBar().setTitle("Updates");

        updateitems=new ArrayList<>();

        adapter1 =new UpdateAdapter(updateitems,this);

        FDB=FirebaseDatabase.getInstance();
        getDataFirebase();



    }

    void getDataFirebase()
    {
        DBR=FDB.getReference("RecyclerView");
        DBR.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Update_item data=new Update_item();
                data=dataSnapshot.getValue(Update_item.class);
                updateitems.add(data);
                recyclerView.setAdapter(new AlphaInAnimationAdapter(adapter1));

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Update_item data=new Update_item();
                data=dataSnapshot.getValue(Update_item.class);
                updateitems.remove(data);
                recyclerView.setAdapter(new AlphaInAnimationAdapter(adapter1));

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void onBackPressed() {
        startActivity(new Intent(Updates.this, MenuActivity.class));
    }
}
