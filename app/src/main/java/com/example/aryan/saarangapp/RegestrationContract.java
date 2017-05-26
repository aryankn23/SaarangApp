package com.example.aryan.saarangapp;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by aryan on 26/5/17.
 */

public final class RegestrationContract {

    private RegestrationContract() {
    }

    public static final String CONTENT_AUTHORITY = "com.example.aryan.saarangapp";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_REGESTRAION = "regestration";

    public static class RegestrationEntry implements BaseColumns {
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_REGESTRAION);


        public static final String TABLE_NAME = "regestration";
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_REGESTRATION_NAME = "name";
        public static final String COLUMN_REGESTRATION_EMAIL_ID = "email";
        public static final String COLUMN_REGESTRATION_CONTACT = "contact";
        public static final String COLUMN_REGESTRATION_CATAGORY = "catagory";
        public static final String COLUMN_REGESTRATION_EVENT = "event";
        public static final int CATAGORY_ONE = 0;
        public static final int CATAGORY_TWO = 1;
        public static final int CATAGORY_THREE = 2;
        public static final int CATAGORY_FOUR = 3;
        public static final int CATAGORY_FIVE = 4;
        public static final int CATAGORY_SIX = 5;
        public static final int EVENT_ONE = 0;
        public static final int EVENT_TWO = 1;
    }
}