package com.nu2k18.nitrutsav;

import android.content.ClipData;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;

/**
 * Created by SUBAS on 17-01-2018.
 */

public class WheelTextAdapter extends CursorWheelLayout.CycleWheelAdapter {

    private Context mcontext;
    private List<MenuItemData> menuItems;
    private LayoutInflater inflater;
    private int gravity;

    public WheelTextAdapter(Context mcontext, List<MenuItemData> menuItems) {
        this.mcontext = mcontext;
        this.menuItems = menuItems;
        gravity= Gravity.CENTER;
        inflater=LayoutInflater.from(mcontext);
    }

    @Override
    public int getCount() {
        return menuItems.size();
    }

    @Override
    public View getView(View parent, int position) {
        MenuItemData itemData= (MenuItemData) getItem(position);
        View root=inflater.inflate(R.layout.wheel_text_layout,null,false);
        TextView textView=(TextView)root.findViewById(R.id.wheel_menu_item_tv);
        textView.setVisibility(View.VISIBLE);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        textView.setText(itemData.mTitle);
        if(textView.getLayoutParams() instanceof FrameLayout.LayoutParams)
            ((FrameLayout.LayoutParams)textView.getLayoutParams()).gravity=gravity;
        if(position==5)
            textView.setTextColor(ActivityCompat.getColor(mcontext,R.color.red));
        return root;

    }

    @Override
    public Object getItem(int position) {
        return menuItems.get(position);
    }
}
