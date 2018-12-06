package com.ropalinda.ropalindamovil.Fragments;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.valle.ropalinda.Controlador.Main;
import com.example.valle.ropalinda.R;
import com.example.valle.ropalinda.utilerias.Preferencias;


public class DrawerMenu extends Fragment {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;
    private View mContainer;
    public boolean menuOpen;
    private Context context;
    Preferencias prefs;
    private TextView txt_correo, txt_nombre;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    public void setUp(int fragmentId, DrawerLayout drawerLayout, final Toolbar toolbar, final ActionBar actionBar, Context prContext) {
        mContainer = getActivity().findViewById(fragmentId);
        mDrawerLayout = drawerLayout;
        context = prContext;
        mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Log.d("VIVZ", "onDrawerOpened");
                getActivity().supportInvalidateOptionsMenu();
                menuOpen = true;
            }


            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.d("VIVZ", "onDrawerClosed");
                setHasOptionsMenu(true);
                getActivity().supportInvalidateOptionsMenu();
                menuOpen = false;
            }


            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                //toolbar_wizzard.setAlpha(1 - slideOffset / 2);
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawerToggle.syncState();
            }
        });

    }

    public void cerrarDrawer(){
        mDrawerLayout.closeDrawers();
    }

    public DrawerMenu() {
        // Required empty public constructor
    }

    public void invalidarMenu(android.view.Menu menu, int idMenu){
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mContainer);
        menu.findItem(idMenu).setVisible(!drawerOpen);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.drawer_menu, container, false);

        prefs = new Preferencias(getContext());

        txt_nombre = view.findViewById(R.id.txtNombre);
        txt_nombre.setText(prefs.getNOMBRE());

        LinearLayout inicio;
        inicio = view.findViewById(R.id.nav_inicio);
        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawers();
            }
        });

        LinearLayout perfil;
        perfil = view.findViewById(R.id.nav_perfil);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cerrarDrawer();
                //startActivity(new Intent(getActivity(), Mensajes.class));
            }
        });

        LinearLayout hombre;
        hombre = view.findViewById(R.id.nav_hombre);
        hombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cerrarDrawer();
                //startActivity(new Intent(getActivity(), Configuraciones .class));
            }
        });

        LinearLayout mujer;
        mujer = view.findViewById(R.id.nav_mujer);
        mujer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cerrarDrawer();
                //startActivity(new Intent(getActivity(), Tareas.class));
            }
        });

        LinearLayout ofertas;
        ofertas = view.findViewById(R.id.nav_ofertas);
        ofertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cerrarDrawer();
                //startActivity(new Intent(getActivity(), Asistencias.class));
            }
        });

        LinearLayout cerrar_sesion;
        cerrar_sesion = view.findViewById(R.id.nav_cerrar_sesion);
        cerrar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(view.getContext()).create();
                alertDialog.setTitle("Cerrar Sesión");
                alertDialog.setMessage("¿Desea cerrar sesión?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Aceptar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getActivity(), Main.class);
                                prefs.setSesion(true);
                                startActivity(intent);
                                getActivity().finish();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });
        return view;
    }
}
