package com.ropalinda.ropalindamovil.Controllers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ropalinda.ropalindamovil.R;

public class ControllerDetallePrenda extends AppCompatActivity {

    LinearLayout descripcion_layout;
    ImageView icon_descripcion;
    TextView txt_descripcion_detalle;
    boolean viewDetalle = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_detalle_prenda);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Detalle");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        descripcion_layout = findViewById(R.id.descripcion_layout);
        icon_descripcion = findViewById(R.id.icon_descripcion);
        txt_descripcion_detalle = findViewById(R.id.txt_descripcion_detalle);

        descripcion_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewDetalle){
                    icon_descripcion.setImageResource(R.drawable.ic_remove_black_24dp);
                    txt_descripcion_detalle.setVisibility(View.VISIBLE);
                }
                else{
                    icon_descripcion.setImageResource(R.drawable.ic_add_black_24dp);
                    txt_descripcion_detalle.setVisibility(View.GONE);
                }

                viewDetalle = !viewDetalle;
            }
        });
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
