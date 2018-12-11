package com.ropalinda.ropalindamovil.Controllers.Categorias;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;

import com.etsy.android.grid.StaggeredGridView;
import com.google.gson.Gson;
import com.ropalinda.ropalindamovil.Controllers.ControllerInicio;
import com.ropalinda.ropalindamovil.Controllers.ControllerMain;
import com.ropalinda.ropalindamovil.Controllers.Prendas.ControllerGarmentAdapter;
import com.ropalinda.ropalindamovil.Entities.Garment;
import com.ropalinda.ropalindamovil.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.ArrayList;

public class ControllerHombres extends ControllerMain {

    Gson gson;
    ConnectivityManager cm;
    NetworkInfo activeNetwork;

    StaggeredGridView grid_view_prendas_hombres;
    MaterialBetterSpinner subcategoria_hombres_spinner;
    ControllerGarmentAdapter garmentAdapter;
    ArrayList<Garment> garmentsArray = new ArrayList<>();
    String[] subCategorias;
    ArrayList<String> subCategoriasArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout contentFrame = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.view_hombres, contentFrame);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(2).getSubMenu().getItem(0).setChecked(true);

        this.gson = new Gson();
        this.cm = (ConnectivityManager) this.getSystemService(this.CONNECTIVITY_SERVICE);
        this.activeNetwork = cm.getActiveNetworkInfo();

        grid_view_prendas_hombres = findViewById(R.id.grid_view_prendas_hombres);
        subcategoria_hombres_spinner = findViewById(R.id.subcategoria_hombres_spinner);

        //prendassArray.add(new Garment());
        garmentsArray.add(new Garment(1,1,"Hombres","Subcategoria 1", "Pantalón Jeans Talle 60", 300,"https://www.guantexindustrial.com.ar/809-large_default/pantalon-jeans-talle-60.jpg"));
        garmentsArray.add(new Garment(2,2,"Hombres","Subcategoria 1", "Pantalón largo de caza Steppe 300", 320,"https://www.decathlon.es/media/815/8155549/big_a2537b36c76844a5aaf8be609b9be8d5.jpg"));
        garmentsArray.add(new Garment(3,3,"Hombres","Subcategoria 2", "Pantalón Niño ECKO SHIELD BLOC", 400,"https://www.comun20.com/2008-thickbox_default/pantalon-nino-ecko-shield-block.jpg"));
        //prendassArray.add(new Garment(4,4,"Hombres","Subcategoria 2", "Pantalón de felpa de niño Brotes", 350,"https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/201806/06/00100554800375____1__516x640.jpg"));

        garmentAdapter = new ControllerGarmentAdapter(getApplicationContext(),R.layout.row_prenda,garmentsArray);
        grid_view_prendas_hombres.setAdapter(garmentAdapter);

        subCategorias = new String[garmentsArray.size()];

        for(int i = 0; i<subCategorias.length;i++){
            subCategorias[i]=garmentsArray.get(i).getSubcategoria();
            //subCategorias[i]=prendassArray.get(i).subcategory.name;
        }

        //Quitar subcategorias repetidas
        for (int i = 0; i< subCategorias.length; i++){
            for(int j = 0; j<subCategorias.length; j++){
                if(i!=j){
                    if(subCategorias[i]==subCategorias[j]){
                        subCategorias[i] = "";
                    }
                }
            }
        }

        for(int i=0; i<subCategorias.length; i++){
            if(subCategorias[i]!="")
                subCategoriasArray.add(subCategorias[i]);
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner_item, subCategorias);

        subcategoria_hombres_spinner.setAdapter(arrayAdapter);

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
