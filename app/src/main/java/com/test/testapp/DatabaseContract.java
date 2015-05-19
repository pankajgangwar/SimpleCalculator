package com.test.testapp;

import android.provider.BaseColumns;

/**
 * Created by iriemo on 7/5/15.
 */
public class DatabaseContract {

    public static final class HistoryEntry implements BaseColumns {
        public static final String TABLE_NAME = "history";
        public static final String COLUMN_HISTORY_COMPLETE = "historycomplete";
        public static final String COLUMN_HISTORY_RESULT = "result";
    }

}
