package com.ropalinda.ropalindamovil.Models;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.google.gson.Gson;
import com.ropalinda.ropalindamovil.Utils.AsyncTaskListener;
import com.ropalinda.ropalindamovil.Utils.ServicioAsyncService;
import com.ropalinda.ropalindamovil.Utils.WebService;

import java.util.HashMap;

public class ModelLogin {

    Context context;

    ModelLogin(Context context){
        this.context=context;
    }

    Gson gson;
    ConnectivityManager cm;
    NetworkInfo activeNetwork;

    private void LoginWebService(String rawJson) {
        /*pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Iniciando");
        pDialog.setCancelable(false);*/

        ServicioAsyncService servicioAsyncService = new ServicioAsyncService(context, WebService.Login, rawJson, WebService.POST);
        servicioAsyncService.setOnCompleteListener(new AsyncTaskListener() {


            @Override
            public void onTaskStart() {
                //pDialog.show();
            }

            @Override
            public void onTaskDownloadedFinished(HashMap<String, Object> result) {
                try {
                    int statusCode = Integer.parseInt(result.get("StatusCode").toString());
                    if (statusCode == 0) {
                        //rawJson = gson.fromJson(result.get("Resultado").toString(), DTO_Login.class);
                    }
                } catch (Exception error) {
                    //pDialog.dismissWithAnimation();
                    Log.d("Error ModelLogin", error.toString());
                }
            }

            @Override
            public void onTaskUpdate(String result) {
                //pDialog.dismissWithAnimation();
            }

            @Override
            public void onTaskComplete(HashMap<String, Object> result) {
                //pDialog.dismissWithAnimation();

                /*if (!dto_login.isError){
                    pref.setNOMBRE(dto_login.data.name);
                    pref.setCORREO(dto_login.data.email);
                    pref.setSesion(false);

                    ChildController childController = new ChildController(Login.this);
                    Child child;

                    childController.eliminarTodo();

                    for (Child childs : dto_login.data.childs ){

                        childController.guardarChild(childs);
                        child  = new Child();
                        child.setId_child(childs.id_child);
                        child.setName(childs.name);
                        child.setMessage_color(childs.message_color);
                        child.setTag(childs.tag);
                        childController.guardarChild(child);
                    }

                    Intent i = new Intent(Login.this, Main.class);
                    startActivity(i);
                    finish();
                }
                else{
                    new SweetAlertDialog(Login.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("Atencion")
                            .setContentText(dto_login.message)
                            .setConfirmText("Entendido")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismissWithAnimation();
                                }
                            })
                            .show();
                }*/
            }

            @Override
            public void onTaskCancelled(HashMap<String, Object> result) {
                //pDialog.dismissWithAnimation();
            }
        });
        servicioAsyncService.execute();
    }
}
