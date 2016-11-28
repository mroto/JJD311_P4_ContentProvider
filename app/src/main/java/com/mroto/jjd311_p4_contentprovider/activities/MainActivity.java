package com.mroto.jjd311_p4_contentprovider.activities;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.mroto.jjd311_p4_contentprovider.R;
import com.mroto.jjd311_p4_contentprovider.data.MyContentProvider;
import com.mroto.jjd311_p4_contentprovider.data.MyDatabaseHelper;
import com.mroto.jjd311_p4_contentprovider.data.ParamsDb;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG=MainActivity.class.getSimpleName();

    private EditText editName;
    private EditText editAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Click Listeners:
        findViewById(R.id.btn_query_add).setOnClickListener(this);
        findViewById(R.id.btn_query_consult).setOnClickListener(this);
        findViewById(R.id.btn_query_delete).setOnClickListener(this);

        this.editAge=(EditText)findViewById(R.id.edit_txt_age);
        this.editName=(EditText)findViewById(R.id.edit_text_name);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btn_query_add) {
            this.dbAdd();
        }else if(view.getId()==R.id.btn_query_delete) {
            this.dbDelete();
        }else if(view.getId()==R.id.btn_query_consult) {
            this.dbConsult();
        }
    }

    private Uri dbAdd(){
        String name=this.editName.getText().toString();
        String age=this.editAge.getText().toString();

        ContentValues insertValues=new ContentValues();
        insertValues.put(ParamsDb.STUDENT_NAME, name);
        insertValues.put(ParamsDb.STUDENT_AGE, age);

        Uri insertUri = getContentResolver().insert(MyContentProvider.CONTENT_URI, insertValues);
        return insertUri;
        /*
        TO CHECK IN TERMINAL:
        cd /data/data/com.mroto.jjd311_p4_contentprovider/databases
        sqlite3 JJD311_Database
        select * from JJD311_Table;
        * */
    }
    private void dbDelete(){
        //TODO
    }
    private void dbConsult(){
        MyDatabaseHelper dbHelper= new MyDatabaseHelper(this);
        dbHelper.getWritableDatabase();
    }
}
