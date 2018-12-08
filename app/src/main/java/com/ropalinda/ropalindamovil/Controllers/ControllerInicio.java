package com.ropalinda.ropalindamovil.Controllers;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.FrameLayout;
import android.widget.SearchView;

import com.ropalinda.ropalindamovil.R;
import com.ropalinda.ropalindamovil.Utils.Preferencias;

public class ControllerInicio extends ControllerMain {

    Preferencias prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefs = new Preferencias(getApplicationContext());

        if(prefs.getSesion()){
            startActivity(new Intent(ControllerInicio.this, ControllerLogin.class));
            finish();
        }

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.view_inicio, contentFrameLayout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
