package com.ropalinda.ropalindamovil.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.valle.ropalinda.R;
import com.example.valle.ropalinda.fragmentos.DrawerMenu;
import com.example.valle.ropalinda.utilerias.Preferencias;

public class Main extends AppCompatActivity {

    private DrawerMenu mDrawerMenu;
    Toolbar toolbar;
    Preferencias prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = new Preferencias(getApplicationContext());

        if(prefs.getSesion()){
            startActivity(new Intent(Main.this, Login.class));
            finish();
        }

        this.toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerMenu = (DrawerMenu) getSupportFragmentManager().findFragmentById(R.id.left_drawer);
        mDrawerMenu.setUp(R.id.left_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar, getSupportActionBar(), this);


    }
}
