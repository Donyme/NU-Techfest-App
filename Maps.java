package com.nu2k18.nitrutsav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

public class Maps extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter1;
    private List<Mapitem> mapitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


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
        getSupportActionBar().setTitle("Maps");

        String[] heading={"B.B.A","Dilip Tirkey Stadium","LA-lawn","TNP","EC Seminar Hall","SAC","LA","Main Building","NCC Ground","BPCL","Swimming Pool","Library lawns","BBA Side Lawns","CS Lawns","NIT Health Centre","Department of Chemical Engineering","Department of Computer Science & Engineering","Department Of Electrical Engineering","Ceramic Engineering Department","Department of Mechanical Engineering","Department of Planning And Architecture","Mokshaa Xpress Restaurant","SLR Restaurant","Dosa Plaza Restaurant","Hexagon Restaurant","Jo'z Kitchen Restaurant","M.V. Hall of Residence"," G.D.B Hall of Residence","Dhirubhai Ambani Hall of Residence","M. S. Swaminathan Hall of Residence","Homi Bhaba Hall of Residence"," HB Hall Night Canteen","Satish Dhawan Hall Of Residence","SD Hall Night canteen","Vikram Sarabhai Hall of Residence","VS Hall Night Canteen","C.V.Raman Hall Of Residence","Kiran Majumdar Shaw Hall Of Residence","Community Welfare Society Hospital","New Choice Snacks","Axis Bank ATM","State Bank of India ATM","Rajendra Mishra Exhibition Hall","Golden Jubilee Building"};
        String[] lat={getString(R.string.BBA),getString(R.string.DTS),getString(R.string.LA_lawns),getString(R.string.TNP),getString(R.string.ELEC),getString(R.string.SAC),getString(R.string.LA),getString(R.string.MAIN),getString(R.string.NCCG),getString(R.string.BPCL),getString(R.string.Swimming_pool),getString(R.string.BPCL),getString(R.string.BBA_SIDE_LAWNS),getString(R.string.CS),getString(R.string.Health_centre),getString(R.string.CHEM),getString(R.string.CS),getString(R.string.ELEC),getString(R.string.CERAMIC),getString(R.string.MECH),getString(R.string.ARCH),getString(R.string.Mokshaa),getString(R.string.SLR),getString(R.string.DOSA),getString(R.string.HEX),getString(R.string.JOZ),getString(R.string.MV),getString(R.string.GDB),getString(R.string.DBA),getString(R.string.MSS),getString(R.string.HBA),getString(R.string.HB_NIGHT_CANTEEN),getString(R.string.SD),getString(R.string.SD_NIGHT_CANTEEN),getString(R.string.VS),getString(R.string.VS_NIGHT_CANTEEN),getString(R.string.CVR),getString(R.string.KMS),getString(R.string.CWS),getString(R.string.New_choice),getString(R.string.Axis),getString(R.string.SBI),getString(R.string.RMH),getString(R.string.GOLD)};
        //String lat1=getString(R.string.BBA);
        mapitems=new ArrayList<>();
        int n=heading.length,i;
        for(i=0;i<n;i++)
        {
            Mapitem mapitem=new Mapitem(heading[i],lat[i]);
            mapitems.add(mapitem);
        }

        adapter1 =new MapAdapter(mapitems,this);
        recyclerView.setAdapter(new AlphaInAnimationAdapter(adapter1));

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Maps.this, MenuActivity.class));
    }
}
