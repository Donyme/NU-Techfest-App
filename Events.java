package com.nu2k18.nitrutsav;

import android.app.LauncherActivity;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Events extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Listitem> listitems;
    String TAG;
    //private DocumentReference mDocRef = FirebaseFirestore.getInstance().document("Competition_details/match_the_stash");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);



        recyclerView= (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(false);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        }
        getSupportActionBar().setTitle("Competitions");
        String[] heading={"Dil se dubsmash","Vintage Bowl","Jounce 1.0","Set to rise","Match the stash","Pictionary","Game of cards","Stranger tales","Home and hope stall","NU Journalist","Rapnesia","Ad Mad Show","Social tour for Kids","Cherir Jager","Boston Legal","Alohomora","Lit-A-Lympics","Graff-e-Spruzzi","Troupe hunt","Pic-a-thon","Open Mic"};
        String[] heading1={"Pre NU Event","3rd Feb","3rd Feb","3rd Feb","3rd Feb","3rd Feb","3rd Feb","3rd Feb","3rd-4th Feb","3rd Feb","4th Feb","4th Feb","4th Feb","4th Feb","4th Feb","4th Feb","4th Feb","4th Feb","4th Feb","Pre NU online event","3rd Feb"};
        String[] imagename={"https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Dil%20Se%20Dubsmash.jpg?alt=media&token=5ceb9bb7-d673-414a-b07c-652d4a92e264","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Vintage%20Bowl.png?alt=media&token=6b2f34be-2cbe-4784-9b33-50c66be78625","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Jounce1.jpg?alt=media&token=637668ab-37a7-4679-bc49-b8a74b7fb219","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Set%20to%20Rise.jpg?alt=media&token=072b97ef-4ae3-4a11-9d3a-f149127ae051","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Match%20The%20Stash.jpg?alt=media&token=0593277d-6b53-47af-a9ed-b4383df52b19","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Pictionary.jpg?alt=media&token=a9a32a72-9514-46b3-8ee1-15f97b59a75b","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Game%20of%20Cards.jpg?alt=media&token=e6282647-353b-4e26-a6c8-b988d553b133","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Stranger%20Tales.jpg?alt=media&token=494cba81-2506-4f70-812d-bb88ad8210e0","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Home%20and%20hope%20stall.jpg?alt=media&token=deac4593-a121-4192-ba10-4d3a9f401caf","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/NUJ.jpg?alt=media&token=06a8d5aa-0aaa-4c59-84e6-6e37bd637db2","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Rapnesia.jpg?alt=media&token=ce6a547d-570a-463e-8614-075e50016a68","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Ad%20Mad%20Show.jpg?alt=media&token=732aa028-978d-493f-afbc-fcfb67f0df22","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Social.jpg?alt=media&token=c5130431-9594-49e1-bd90-8bb15d18a0e6","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Cherir%20Jager.jpg?alt=media&token=affa2613-0182-47b9-b108-c811893bef29","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Boston%20Legal.jpg?alt=media&token=c1f9b47f-d9b5-41c8-bf9d-9bc9d55f9287","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Alohomora.jpeg?alt=media&token=154c1ba7-0626-4575-8994-937326bf032a","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/lit-a-lympics.jpg?alt=media&token=088dfbe3-530b-48bb-a708-96fae5429ef5","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Graff-e-spruzzi.jpg?alt=media&token=0994a0ed-76f4-49e0-9781-fc31768abe3e","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Troupe%20Hunt.jpg?alt=media&token=c2b7c65c-a896-46dd-a096-643ee72e81d4","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/pic.jpg?alt=media&token=56718411-25ee-4078-b8fd-3205f1554bf7","https://firebasestorage.googleapis.com/v0/b/nitrutsav-190509.appspot.com/o/Open%20Mic.jpg?alt=media&token=1a2c873a-f159-46c2-a670-ff458fc38682"};
        String[] description={getString(R.string.dil_se_dubsmash_d),getString(R.string.vintage_bowl_d),getString(R.string.jounce_d),getString(R.string.set_to_rise_d),getString(R.string.match_the_stash_d),getString(R.string.pictionary_d),getString(R.string.game_of_cards_d),getString(R.string.stranger_tales_d),getString(R.string.home_and_hope_stall_d),getString(R.string.nuj_d),getString(R.string.rapensia_d),getString(R.string.ad_mad_show_d),getString(R.string.Stk_d),getString(R.string.cherir_jager_d),getString(R.string.boston_legal_d),getString(R.string.alohomora_d),getString(R.string.Clarion2_d),getString(R.string.graff_e_spruzzi_d),getString(R.string.troupe_hunt_d),getString(R.string.pic_d),getString(R.string.Openmic_d)};
        String[] rules={getString(R.string.dil_se_dubsmash_r),getString(R.string.vintage_bowl_r),getString(R.string.jounce_r),getString(R.string.set_to_rise_r),getString(R.string.match_the_stash_r),getString(R.string.pictionary_r),getString(R.string.game_of_cards_r),getString(R.string.stranger_tales_r),getString(R.string.home_and_hope_stall_r),getString(R.string.nuj_r),getString(R.string.rapensia_r),getString(R.string.ad_mad_show_r),getString(R.string.Stk_r),getString(R.string.cherir_jager_r),getString(R.string.boston_legal_r),getString(R.string.alohomora_r),getString(R.string.Clarion2_r),getString(R.string.graff_e_spruzzi_r),getString(R.string.troupe_hunt_r),getString(R.string.pic_r),getString(R.string.Openmic_r)};
        String[] judging={getString(R.string.dil_se_dubsmash_j),getString(R.string.vintage_bowl_j),getString(R.string.jounce_j),getString(R.string.set_to_rise_j),getString(R.string.match_the_stash_j),getString(R.string.pictionary_j),getString(R.string.game_of_cards_j),getString(R.string.stranger_tales_j),getString(R.string.home_and_hope_stall_j),getString(R.string.nuj_j),getString(R.string.rapensia_j),getString(R.string.ad_mad_show_j),getString(R.string.Stk_j),getString(R.string.cherir_jager_j),getString(R.string.boston_legal_j),getString(R.string.alohomora_j),getString(R.string.Clarion2_j),getString(R.string.graff_e_spruzzi_j),getString(R.string.troupe_hunt_j),getString(R.string.pic_j),getString(R.string.Openmic_j)};
        String[] venue={getString(R.string.dil_se_dubsmash_v),getString(R.string.vintage_bowl_v),getString(R.string.jounce_v),getString(R.string.set_to_rise_v),getString(R.string.match_the_stash_v),getString(R.string.pictionary_v),getString(R.string.game_of_cards_v),getString(R.string.stranger_tales_v),getString(R.string.home_and_hope_stall_v),getString(R.string.nuj_v),getString(R.string.rapensia_v),getString(R.string.ad_mad_show_v),getString(R.string.Stk_v),getString(R.string.cherir_jager_v),getString(R.string.boston_legal_v),getString(R.string.alohomora_v),getString(R.string.Clarion2_v),getString(R.string.graff_e_spruzzi_v),getString(R.string.troupe_hunt_v),getString(R.string.pic_v),getString(R.string.Openmic_v)};
        String[] date={getString(R.string.dil_se_dubsmash_dt),getString(R.string.vintage_bowl_dt),getString(R.string.jounce_dt),getString(R.string.set_to_rise_dt),getString(R.string.match_the_stash_dt),getString(R.string.pictionary_dt),getString(R.string.game_of_cards_dt),getString(R.string.stranger_tales_dt),getString(R.string.home_and_hope_stall_dt),getString(R.string.nuj_dt),getString(R.string.rapensia_dt),getString(R.string.ad_mad_show_dt),getString(R.string.Stk_dt),getString(R.string.cherir_jager_dt),getString(R.string.boston_legal_dt),getString(R.string.alohomora_dt),getString(R.string.Clarion2_dt),getString(R.string.graff_e_spruzzi_dt),getString(R.string.troupe_hunt_dt),getString(R.string.pic_dt),getString(R.string.Openmic_dt)};
        String[] coordinators={getString(R.string.dil_se_dubsmash_co),getString(R.string.vintage_bowl_co),getString(R.string.jounce_co),getString(R.string.set_to_rise_co),getString(R.string.match_the_stash_co),getString(R.string.pictionary_co),getString(R.string.game_of_cards_co),getString(R.string.stranger_tales_co),getString(R.string.home_and_hope_stall_co),getString(R.string.nuj_co),getString(R.string.rapensia_co),getString(R.string.ad_mad_show_co),getString(R.string.Stk_co),getString(R.string.cherir_jager_co),getString(R.string.boston_legal_co),getString(R.string.alohomora_co),getString(R.string.Clarion2_co),getString(R.string.graff_e_spruzzi_co),getString(R.string.troupe_hunt_co),getString(R.string.pic_co),getString(R.string.Openmic_co)};
        String[] lat={getString(R.string.SAC),getString(R.string.SAC),getString(R.string.BBA),getString(R.string.MAIN),getString(R.string.BPCL),getString(R.string.BPCL),getString(R.string.BPCL),getString(R.string.BPCL),getString(R.string.SAC),getString(R.string.BBA),getString(R.string.SAC),getString(R.string.CS),getString(R.string.SAC),getString(R.string.MAIN),getString(R.string.BPCL),getString(R.string.MAIN),getString(R.string.BBA_SIDE_LAWNS),getString(R.string.SAC),getString(R.string.CHEM),getString(R.string.SAC),getString(R.string.New_choice)};

        String lat1=getString(R.string.BBA);

        //String long1="84.9100206";
        listitems=new ArrayList<>();
        int n=heading.length,i;

        for(i=0;i<n;i++)
        {
            Listitem listitem=new Listitem(heading[i],heading1[i],imagename[i],description[i],rules[i],judging[i],venue[i],date[i],coordinators[i],lat[i]);
            listitems.add(listitem);
        }

        adapter =new MyAdapter(listitems,this);
        recyclerView.setAdapter(adapter);          //new AlphaInAnimationAdapter(adapter)
    }


}