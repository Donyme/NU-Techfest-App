package com.nu2k18.nitrutsav;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.content.res.Resources;
import android.test.mock.MockResources;

import com.andexert.library.RippleView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;


import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by SUBAS on 09-01-2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Listitem> listitems;
    private Context context;
    private List<String> attr;


    public MyAdapter(List<Listitem> listitems, Context context) {
        this.listitems = listitems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item,parent,false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Listitem listitem=listitems.get(position);
        holder.heading.setText(listitem.getHeading());
        //holder.heading1.setText(listitem.getHeading1());

        String uri="@drawable/";
        uri=uri+listitem.getImgname().toString();
        int imageid=context.getResources().getIdentifier(uri, null, context.getPackageName());
        //Drawable res= context.getResources().getDrawable(imageid);
        //holder.imgv.setImageDrawable(res);
        String url=listitem.getImgname().toString();
        Glide.with(this.context).load(url).diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(R.drawable.logo_alt).into(holder.imgv);

        final String [] arr={listitem.getHeading().toString(),listitem.getImgname().toString(),listitem.getDescription().toString(),listitem.getRules().toString(),listitem.getJudging().toString(),listitem.getVenue().toString(),listitem.getDate().toString(),listitem.getCoordinators().toString(),listitem.getLatitude().toString(),listitem.getHeading1()};
        /*attr.add(listitem.getHeading()); attr.add(listitem.getImgname());attr.add(listitem.getDescription());
        attr.add(listitem.getRules()); attr.add(listitem.getJudging()); attr.add(listitem.getVenue()); attr.add(listitem.getDate());
        attr.add(listitem.getCoordinators());*/

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context,Competitions.class).putExtra("arg",arr));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView heading;
        public TextView heading1;
        public ImageView imgv;
        public ConstraintLayout linearLayout;
        public RippleView rippleView;

        public ViewHolder(View itemView) {
            super(itemView);

            heading=(TextView)itemView.findViewById(R.id.heading);
           // heading1=(TextView)itemView.findViewById(R.id.heading1);
            imgv=(ImageView)itemView.findViewById(R.id.imgv);
            linearLayout= (ConstraintLayout) itemView.findViewById(R.id.linear_layout);

        }
    }
}

