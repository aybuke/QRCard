package com.example.aybuke.qrcard;
  
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class Registeration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
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
 
	public void KayıtOlDB(View v){
	        EditText adi = (EditText) findViewById(R.id.editText4);
            EditText mail = (EditText) findViewById(R.id.editText5);
	        EditText parola = (EditText) findViewById(R.id.editText6);
	        CheckBox vip = (CheckBox) findViewById(R.id.checkBox2);
	
	        CardDB kayit = new CardDB(getApplicationContext());
	        SQLiteDatabase veritabani = kayit.getWritableDatabase();
	        ContentValues satir = new ContentValues();

		satir.put("name", adi.getText().toString());
		satir.put("mail", mail.getText().toString());
		satir.put("passwd", parola.getText().toString());

		if (vip.isChecked()) {
			Random r = new Random();
			int vipkod = r.nextInt(90000) + 10000;
			satir.put("vip", vipkod);
			Toast.makeText(getApplicationContext(), "VIP kodunuz: " + vipkod, Toast.LENGTH_LONG).show();
		}

	veritabani.insert("cards", null, satir);
	Intent main = new Intent(this, MainActivity.class);
	startActivity(main);
	}
}
