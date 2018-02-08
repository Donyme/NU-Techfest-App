package com.nu2k18.nitrutsav;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import jp.wasabeef.recyclerview.adapters.AnimationAdapter;

/**
 * Created by SUBAS on 15-01-2018.
 *
 *
 *
 */

public class AlphaInAnimationAdapter extends AnimationAdapter {

    private static final float NUM= 0f;
    private final float mFrom;

    public AlphaInAnimationAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter) {
        this(adapter,NUM);}

          public AlphaInAnimationAdapter(RecyclerView.Adapter adapter, float from) {
            super(adapter);
            mFrom = from;
        }


    @Override
    protected Animator[] getAnimators(View view) {
        return new Animator[] { ObjectAnimator.ofFloat(view, "alpha", mFrom, 1f) };
    }
}
