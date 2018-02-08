package com.nu2k18.nitrutsav;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SUBAS on 01-02-2018.
 */

public class UpdateAdapter extends RecyclerView.Adapter<UpdateAdapter.ViewHolder>{
    private List<Update_item> updateitems;
    private Context context;


    public UpdateAdapter(List<Update_item> updateitems, Context context) {
        this.updateitems = updateitems;
        this.context = context;
    }


    @Override
    public UpdateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.update_item,parent,false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(UpdateAdapter.ViewHolder holder, int position) {

        Update_item data=updateitems.get(position);
        holder.heading.setText(data.getHello());

    }

    @Override
    public int getItemCount() {
        return updateitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView heading;
        public ConstraintLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            heading=(TextView)itemView.findViewById(R.id.update_head);
            linearLayout=(ConstraintLayout) itemView.findViewById(R.id.LR2);
        }
    }
}

