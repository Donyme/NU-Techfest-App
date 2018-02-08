package com.nu2k18.nitrutsav;

/**
 * Created by SUBAS on 18-01-2018.
 */

public class Mapitem {
    private String heading;
    private String lat;


    public Mapitem(String heading, String lat) {
        this.heading = heading;
        this.lat = lat;

    }

    public String getHeading() {
        return heading;
    }

    public String getLat() {
        return lat;
    }


}
