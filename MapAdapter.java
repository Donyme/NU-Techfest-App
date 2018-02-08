package com.nu2k18.nitrutsav;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SUBAS on 18-01-2018.
 */

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.ViewHolder> {

    private List<Mapitem> mapitems;
    private Context context;


    public MapAdapter(List<Mapitem> mapitems, Context context) {
        this.mapitems = mapitems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.map_item,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Mapitem mapitem=mapitems.get(position);
        holder.heading.setText(mapitem.getHeading());
        final String[] arr={mapitem.getHeading().toString(),mapitem.getLat().toString()};

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code for googlemaps
                Uri gmmIntentUri = Uri.parse("google.navigation:q="+arr[1]+"&mode=w");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mapitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView heading;
        public ConstraintLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            heading=(TextView)itemView.findViewById(R.id.map_head);
            linearLayout=(ConstraintLayout) itemView.findViewById(R.id.linear_layout1);
        }
    }
}
