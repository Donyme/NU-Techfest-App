package com.nu2k18.nitrutsav;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;

/**
 * Created by SUBAS on 26-01-2018.
 */

public class LinearLayoutTarget extends  ViewGroupTarget<GlideDrawable> {

   public LinearLayoutTarget(LinearLayout linearLayout) {

        super(linearLayout);
    }


    @Override
    protected void setResource(GlideDrawable resource) {
        view.setBackground(resource);
    }
}
