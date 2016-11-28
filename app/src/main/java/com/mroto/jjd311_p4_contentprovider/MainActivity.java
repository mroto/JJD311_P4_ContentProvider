package com.mroto.jjd311_p4_contentprovider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final static String TAG=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Click Listeners:
        findViewById(R.id.btn_query_add).setOnClickListener(this);
        findViewById(R.id.btn_query_consult).setOnClickListener(this);
        findViewById(R.id.btn_query_delete).setOnClickListener(this);
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

    private void dbAdd(){
        //TODO
    }
    private void dbDelete(){
        //TODO
    }
    private void dbConsult(){
        //TODO
    }
}
