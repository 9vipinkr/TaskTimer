package com.vipinkr.tasktimer;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String[] projection={TaskContract.Column.TASKS_NAME,TaskContract.Column.TASKS_DESCRIPTION,TaskContract.Column.TASKS_SORTORDER};
        ContentResolver contentResolver=getContentResolver();

        // insert values
//        ContentValues contentValues=new ContentValues();
//        contentValues.put(TaskContract.Column.TASKS_NAME,"COBOL");
//        contentValues.put(TaskContract.Column.TASKS_DESCRIPTION,"incomplete");
//        contentValues.put(TaskContract.Column.TASKS_SORTORDER,3);
//        contentResolver.insert(TaskContract.CONTENT_URI,contentValues);

        //delete values
//        ContentValues contentValues=new ContentValues();
//        contentValues.put(TaskContract.Column.TASKS_NAME,"C#");
//        contentValues.put(TaskContract.Column.TASKS_DESCRIPTION,"will be completed");
//       String selection=TaskContract.Column.TASKS_SORTORDER+"=?";
//        String[] args={"3"};
//        contentResolver.delete(TaskContract.CONTENT_URI,
//                selection,
//                args);
//
        Cursor cursor=contentResolver.query(TaskContract.CONTENT_URI,
                projection,
                null,
                null,
                TaskContract.Column.TASKS_NAME);

        if(cursor!=null){
            Log.d(TAG, "onCreate: num of columns: "+cursor.getColumnCount());
            while(cursor.moveToNext()){
                for (int i=0;i<cursor.getColumnCount();i++){
                    Log.d(TAG, "onCreate: "+cursor.getColumnName(i)+": "+cursor.getString(i));
                }
            }
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
