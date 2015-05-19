package com.test.testapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by iriemo on 7/5/15.
 */
public class SecondTestAppActivity extends AppCompatActivity {

    MyDatabaseHelper myDatabaseHelper;
    ListView mHistoryListview;
    ArrayAdapter<String> arrayAdapter;
    private static final String TAG = SecondTestAppActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.history_activity);

        myDatabaseHelper = new MyDatabaseHelper(this);

        mHistoryListview = (ListView) findViewById(R.id.mHistoryListview);
        mHistoryListview.setOnItemClickListener(onItemClickListener);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        Cursor cursor = myDatabaseHelper.getHistory();
        if (cursor.getCount() > 0) {

            int noOfScorer = 0;
            cursor.moveToFirst();

            while (!cursor.isAfterLast() && noOfScorer < cursor.getCount()) {
                noOfScorer++;
                String adapterRow = cursor.getString(1) + " =  " + cursor.getString(2);
                arrayAdapter.add(adapterRow);
                mHistoryListview.setAdapter(arrayAdapter);
                cursor.moveToNext();
            }
        }
    }


    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent(SecondTestAppActivity.this, MainActivity.class);
            intent.putExtra(Intent.EXTRA_TEXT, arrayAdapter.getItem(position));
            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.history_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.clearHistory) {

            int rows = myDatabaseHelper.clearHistory();

            Log.i(TAG, "Rows Deleted: " + rows);

            if (rows > 0) {
                arrayAdapter.clear();
                mHistoryListview.setAdapter(arrayAdapter);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
