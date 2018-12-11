package com.ropalinda.ropalindamovil.Controllers.Categorias;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.etsy.android.grid.StaggeredGridView;
import com.ropalinda.ropalindamovil.Controllers.ControllerInicio;
import com.ropalinda.ropalindamovil.Controllers.ControllerMain;
import com.ropalinda.ropalindamovil.Controllers.Prendas.ControllerGarmentAdapter;
import com.ropalinda.ropalindamovil.Entities.Garment;
import com.ropalinda.ropalindamovil.R;

import java.util.ArrayList;

public class ControllerMujeres extends ControllerMain {

    StaggeredGridView grid_view_prendas_mujeres;
    ArrayList<Garment> garmentsArray = new ArrayList<>();
    ControllerGarmentAdapter garmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout contentFrame = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.view_mujeres, contentFrame);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(2).getSubMenu().getItem(1).setChecked(true);

        grid_view_prendas_mujeres = findViewById(R.id.grid_view_prendas_mujeres);
        garmentsArray.add(new Garment(1,1,"Hombres","Subcategoria 1", "Pantalón Jeans Talle 60", 300,"https://www.guantexindustrial.com.ar/809-large_default/pantalon-jeans-talle-60.jpg"));
        garmentsArray.add(new Garment(2,2,"Hombres","Subcategoria 1", "Pantalón largo de caza Steppe 300", 320,"https://www.decathlon.es/media/815/8155549/big_a2537b36c76844a5aaf8be609b9be8d5.jpg"));
        garmentsArray.add(new Garment(3,3,"Hombres","Subcategoria 2", "Pantalón Niño ECKO SHIELD BLOC", 400,"https://www.comun20.com/2008-thickbox_default/pantalon-nino-ecko-shield-block.jpg"));
        //prendassArray.add(new Garment(4,4,"Hombres","Subcategoria 2", "Pantalón de felpa de niño Brotes", 350,"https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/201806/06/00100554800375____1__516x640.jpg"));

        garmentAdapter = new ControllerGarmentAdapter(getApplicationContext(),R.layout.row_prenda,garmentsArray);
        grid_view_prendas_mujeres.setAdapter(garmentAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            startActivity(new Intent(this, ControllerInicio.class));
        }
    }
}
