package com.example.aybuke.qrcard;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        CheckBox vip = (CheckBox) findViewById(R.id.checkBox);
        vip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { findViewById(R.id.editText3).setVisibility( View.VISIBLE); }
                else {findViewById(R.id.editText3).setVisibility( View.INVISIBLE );}
            }
        });
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

    public void girisYap(View v){
        EditText name = (EditText) findViewById(R.id.editText);
        EditText pass = (EditText) findViewById(R.id.editText2);
        CheckBox vip = (CheckBox) findViewById(R.id.checkBox);
        EditText vipid = (EditText) findViewById(R.id.editText3);

        CardDB giris = new CardDB(getApplicationContext());
        SQLiteDatabase veritabani = giris.getReadableDatabase();

        String[] sutunlar = {"name", "passwd", "vip"};
        String vipcode = vip.getText().toString();
        if (vipcode.isEmpty()) {
            vipcode = "0";
        }
        String[] veriler = {name.getText().toString(), pass.getText().toString(), vip.getText().toString()};
        Cursor c = veritabani.query("cards", sutunlar, "name=? AND passwd=? AND vip=?", veriler, null, null, null);
        if (c.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "Bilgileriniz hatalı, lütfen tekrar deneyiniz.", Toast.LENGTH_LONG).show();
        }

        else {
            Intent anasayfa = new Intent(this, MainActivity.class);
            startActivity(anasayfa);
        }
    }

    public void kayitOl(View v){
        Intent x = new Intent(this, Registeration.class);
        startActivity(x);

    }

}
