package com.tutorials.hp.androidmdmysqlsave;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.tutorials.hp.androidmdmysqlsave.mMySQL.Sender;

public class MainActivity extends AppCompatActivity {

    String urlAddress="http://10.0.2.2/android/spacecraft.php";
    EditText nameTxt,propellantTxt,descTxt;
    Button saveBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        nameTxt= (EditText) findViewById(R.id.nameEditTxt);
        propellantTxt= (EditText) findViewById(R.id.propellantEditTxt);
        descTxt= (EditText) findViewById(R.id.descEditTxt);
        saveBtn= (Button) findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sender s=new Sender(MainActivity.this,urlAddress,nameTxt,propellantTxt,descTxt);
                s.execute();
            }
        });

    }

}
