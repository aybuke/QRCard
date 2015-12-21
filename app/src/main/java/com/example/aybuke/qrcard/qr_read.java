package com.example.aybuke.qrcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

public class qr_read extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_read);
        Intent read = getIntent();
        String kod =  read.getStringExtra("okunan");
        JSONArray json = null;
        try {
            json = new JSONArray(kod);
            TextView adres1 = (TextView) findViewById(R.id.textView2);
            adres1.setText(json.getString(0));
            TextView adres2 = (TextView) findViewById(R.id.textView3);
            adres2.setText(json.getString(1));
            TextView adres3 = (TextView) findViewById(R.id.textView4);
            adres3.setText(json.getString(2));
            TextView adres4 = (TextView) findViewById(R.id.textView5);
            adres4.setText(json.getString(3));
            TextView adres5 = (TextView) findViewById(R.id.textView6);
            adres5.setText(json.getString(4));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



}
