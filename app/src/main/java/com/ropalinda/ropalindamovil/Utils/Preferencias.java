package com.ropalinda.ropalindamovil.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by danixsanc on 27/09/2015.
 */
public class Preferencias {

    private final String SHARED_PREFS_FILE = "HMPrefs";
    private final String SESION = "sesion";
    private final String NOMBRE = "nombre";
    private final String CORREO = "correo";

    private Context mContext;

    public Preferencias(Context context){
        mContext = context;
    }

    private SharedPreferences getSettings(){
        return mContext.getSharedPreferences(SHARED_PREFS_FILE, 0);
    }

    public void setSesion(boolean prSave2){
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putBoolean(SESION, prSave2);
        editor.commit();
    }

    public boolean getSesion(){
        return getSettings().getBoolean(SESION, true);
    }

    public void setNOMBRE(String prSave2){
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putString(NOMBRE, prSave2);
        editor.commit();
    }

    public String getNOMBRE(){
        return getSettings().getString(NOMBRE,"");
    }

    public void setCORREO(String prSave2){
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putString(CORREO, prSave2);
        editor.commit();
    }

    public String getCORREO(){
        return getSettings().getString(CORREO,"");
    }







}
