package com.nu2k18.nitrutsav;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;

/**
 * Created by SUBAS on 17-01-2018.
 */

public class WheelImageAdapter extends CursorWheelLayout.CycleWheelAdapter {

    private Context mcontext;
    private List<ImageData> menuItems;
    private LayoutInflater inflater;
    private int gravity;

    public WheelImageAdapter(Context mcontext, List<ImageData> menuItems) {
        this.mcontext = mcontext;
        this.menuItems = menuItems;
        inflater=LayoutInflater.from(mcontext);
    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public View getView(View parent, int position) {
       ImageData data= (ImageData) getItem(position);
        View root=inflater.inflate(R.layout.wheel_image_layout,null,false);
        ImageView imageView=(ImageView)root.findViewById(R.id.wheel_menu_item_iv);
        imageView.setImageResource(data.imageResource);
        return root;
    }

    @Override
    public Object getItem(int position) {
        return menuItems.get(position);
    }
}
