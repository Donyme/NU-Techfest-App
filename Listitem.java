package com.nu2k18.nitrutsav;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by SUBAS on 09-01-2018.
 */

public class Listitem {

    private String heading;
    private String heading1;
    private String imgname;
    private String description;
    private String rules;
    private String judging;
    private String venue;
    private String date;
    private String coordinators;
    private String latitude;
    //private String longitude;

    public Listitem(String heading,String heading1, String imgname,String description,String rules,String judging,String venue,String date,String coordinators,String latitude) {
        this.heading = heading;
        this.heading1 = heading1;
        this.imgname = imgname;
        this.description=description;
        this.rules=rules;
        this.judging=judging;
        this.venue=venue;
        this.date=date;
        this.coordinators=coordinators;
        this.latitude=latitude;
       // this.longitude=longitude;
    }

    public String getHeading() {
        return heading;
    }

    public String getHeading1() {
        return heading1;
    }

    public String getImgname() {

      return imgname;
    }

    public String getDescription() {
        return description;
    }

    public String getRules() {
        return rules;
    }

    public String getJudging() {
        return judging;
    }

    public String getVenue() {
        return venue;
    }

    public String getDate() {
        return date;
    }

    public String getCoordinators() {
        return coordinators;
    }

    public String getLatitude(){ return latitude;}

    //public String getLongitude(){return longitude;}
}
