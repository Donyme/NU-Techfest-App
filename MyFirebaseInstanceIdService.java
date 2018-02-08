package com.nu2k18.nitrutsav;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by SUBAS on 06-01-2018.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService{
    private static final String REG_TOKEN="REG_TOKEN";
    @Override
    public void onTokenRefresh() {
        String recent_token = FirebaseInstanceId.getInstance().getToken();


    }
}
