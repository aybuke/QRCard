package com.example.aybuke.qrcard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.google.zxing.integration.android.IntentIntegrator;

import org.json.JSONArray;

public class qr_create extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_create);
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

        if (!prefs.getBoolean("vip", false)) {
            findViewById(R.id.editText10).setVisibility(View.INVISIBLE);
            findViewById(R.id.editText11).setVisibility(View.INVISIBLE);
        }
    }

    public void qrcodeolustur(View v){
        EditText adres1 = (EditText) findViewById(R.id.editText7);
        EditText adres2 = (EditText) findViewById(R.id.editText8);
        EditText adres3 = (EditText) findViewById(R.id.editText9);
        EditText adres4 = (EditText) findViewById(R.id.editText10);
        EditText adres5 = (EditText) findViewById(R.id.editText11);

        JSONArray json = new JSONArray();
        json.put(adres1.getText().toString());
        json.put(adres2.getText().toString());
        json.put(adres3.getText().toString());
        json.put(adres4.getText().toString());
        json.put(adres5.getText().toString());

        new IntentIntegrator(this).shareText(json.toString());


    }

    SharedPreferences prefs;

}
