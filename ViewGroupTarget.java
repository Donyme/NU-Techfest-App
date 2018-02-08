package com.nu2k18.nitrutsav;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ViewTarget;

/**
 * Created by SUBAS on 26-01-2018.
 */

public abstract class ViewGroupTarget<Z> extends ViewTarget<ViewGroup,Z>  implements GlideAnimation.ViewAdapter {

    public ViewGroupTarget(ViewGroup view) {
        super(view);
    }

    @Override
    public Drawable getCurrentDrawable() {
        return view.getBackground();
    }
    @Override
    public void setDrawable(Drawable drawable) {
        view.setBackground(drawable);
    }

    @Override
    public void onLoadStarted(Drawable placeholder) {
        view.setBackground(placeholder);
    }

    @Override
    public void onLoadFailed(Exception e, Drawable errorDrawable) {
        view.setBackground(errorDrawable);
    }

    @Override
    public void onLoadCleared(Drawable placeholder) {
        view.setBackground(placeholder);
    }

    public void onResourceReady(Z resource, GlideAnimation<? super Z> glideAnimation) {

        this.setResource(resource);
    }
    protected abstract void setResource(Z resource);
}