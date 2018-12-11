package com.ropalinda.ropalindamovil.Controllers;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.SmsMessage;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;

import com.ropalinda.ropalindamovil.Controllers.Categorias.ControllerHombres;
import com.ropalinda.ropalindamovil.Controllers.Categorias.ControllerMujeres;
import com.ropalinda.ropalindamovil.Entities.Category;
import com.ropalinda.ropalindamovil.Models.ModelMain;
import com.ropalinda.ropalindamovil.R;
import com.ropalinda.ropalindamovil.Utils.Preferencias;

import java.security.acl.Group;

public class ControllerMain extends AppCompatActivity{

    private Preferencias prefs;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;
    ModelMain modelMain = new ModelMain();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_main);
        //NavigationView navigationView = findViewById(R.id.nav_view);

        prefs = new Preferencias(getApplicationContext());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        displayMenu();

        /*navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_inicio:
                        startActivity(new Intent(getApplicationContext(), ControllerInicio.class));
                        finish();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_perfil:
                        startActivity(new Intent(getApplicationContext(), ControllerPerfil.class));
                        finish();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_hombre:
                        startActivity(new Intent(getApplicationContext(), ControllerHombres.class));
                        finish();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_mujer:
                        startActivity(new Intent(getApplicationContext(), ControllerMujeres.class));
                        finish();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_niña:
                        startActivity(new Intent(getApplicationContext(), ControllerOfertas.class));
                        finish();
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.nav_salir:
                        cerrarSesion();
                        drawerLayout.closeDrawers();
                        break;

                }
                return false;
            }
        });*/

    }

    private void displayMenu(){
        NavigationView navigationView = findViewById(R.id.nav_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        Menu menu = navigationView.getMenu();

        menu.add("Inicio").setIcon(R.drawable.iconcasa);
        menu.add("Prendas personalizadas").setIcon(R.drawable.iconbolsa);

        SubMenu categorías = menu.addSubMenu("Categorías");
        for(Category g : modelMain.getCategories()){
            categorías.add(g.getName()).setIcon(BitmapDrawable.createFromPath(g.getImage()));
        }
        /*categorías.add("Hombre").setIcon(R.drawable.iconbolsa);
        categorías.add("Mujer");
        categorías.add("Niña");*/

        //menu.setGroupDividerEnabled(true);
        menu.add("Cerrar Sesión");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);


        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        actionBarDrawerToggle.syncState();
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransitionEnter();
    }

    /**
     * Overrides the pending Activity transition by performing the "Enter" animation.
     */
    protected void overridePendingTransitionEnter() {
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    /**
     * Overrides the pending Activity transition by performing the "Exit" animation.
     */
    protected void overridePendingTransitionExit() {
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransitionExit();
    }

    public void cerrarSesion(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Cerrar sesión")
                .setMessage("¿Desea cerrar sesión?")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        prefs.setSesion(true);
                        startActivity(new Intent(ControllerMain.this, ControllerLogin.class));
                        finish();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.show();
    }
}
