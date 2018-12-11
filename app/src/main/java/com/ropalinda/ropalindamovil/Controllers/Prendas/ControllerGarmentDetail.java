package com.ropalinda.ropalindamovil.Controllers.Prendas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ropalinda.ropalindamovil.Entities.CompatibleGarment;
import com.ropalinda.ropalindamovil.R;

import java.util.ArrayList;

public class ControllerGarmentDetail extends AppCompatActivity {

    LinearLayout descripcion_layout;
    ImageView icon_descripcion;
    TextView txt_descripcion_detalle;
    LinearLayout layout_descripcion;
    RecyclerView list_compatibles_garments;
    RecyclerView.Adapter mAdapter;
    ControllerCompatibleGarmentAdapter compatibleGarmentAdapter;
    ArrayList<CompatibleGarment> compatibleGarmentsArray = new ArrayList<>();
    boolean viewDetalle = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_garment_detail);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Detalle");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        descripcion_layout = findViewById(R.id.descripcion_layout);
        icon_descripcion = findViewById(R.id.icon_descripcion);
        txt_descripcion_detalle = findViewById(R.id.txt_descripcion_detalle);
        layout_descripcion = findViewById(R.id.layout_descripcion);
        list_compatibles_garments = findViewById(R.id.list_compatibles_garments);

        descripcion_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewDetalle){
                    icon_descripcion.setImageResource(R.drawable.ic_remove_black_24dp);
                    layout_descripcion.setVisibility(View.VISIBLE);
                }
                else{
                    icon_descripcion.setImageResource(R.drawable.ic_add_black_24dp);
                    layout_descripcion.setVisibility(View.GONE);
                }

                viewDetalle = !viewDetalle;
            }
        });

        compatibleGarmentsArray.add(new CompatibleGarment(240,1,"Uno","https://www.guantexindustrial.com.ar/809-large_default/pantalon-jeans-talle-60.jpg"));
        compatibleGarmentsArray.add(new CompatibleGarment(240,1,"Uno","https://www.guantexindustrial.com.ar/809-large_default/pantalon-jeans-talle-60.jpg"));
        compatibleGarmentsArray.add(new CompatibleGarment(240,1,"Uno","https://www.guantexindustrial.com.ar/809-large_default/pantalon-jeans-talle-60.jpg"));

        compatibleGarmentAdapter = new ControllerCompatibleGarmentAdapter(compatibleGarmentsArray,getApplicationContext());
        list_compatibles_garments.setAdapter(compatibleGarmentAdapter);
        list_compatibles_garments.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
