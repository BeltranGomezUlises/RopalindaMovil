package com.ropalinda.ropalindamovil.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ropalinda.ropalindamovil.Utils.Preferencias;

/**
 * A login screen that offers login via emai
 * l/password.
 */
import android.app.Activity;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;

public class Login extends Activity {

    Button btn_login;
    EditText txt_correo, txt_secret;
    Preferencias pref;
    ConnectivityManager cm;
    boolean isConnected;
    NetworkInfo activeNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        this.txt_correo = findViewById(R.id.txt_correo);
        this.txt_secret = findViewById(R.id.txt_secret);
        this.pref = new Preferencias(this);

        this.cm = (ConnectivityManager) this.getSystemService(this.CONNECTIVITY_SERVICE);

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!txt_correo.getText().toString().equals("")){
                    if (!txt_secret.getText().toString().equals("")){

                        pDialog = new SweetAlertDialog(Login.this, SweetAlertDialog.PROGRESS_TYPE);
                        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                        pDialog.setTitleText("Iniciando");
                        pDialog.setCancelable(false);
                        pDialog.show();

                        Thread timerThread = new Thread(){
                            public void run(){
                                try{
                                    sleep(1000);

                                }catch(InterruptedException e){
                                    e.printStackTrace();
                                }finally{

                                    if(isConecctedToInternet()){
                                        //pDialog.dismissWithAnimation();
                                        req_login.setEmail(txt_correo.getText().toString());
                                        req_login.setSecret(txt_secret.getText().toString());
                                        req_login.setDevice("movil");
                                        req_login.setUserType("user");
                                        LoginWebService(gson.toJson(req_login));
                                    }
                                    else{
                                        //pDialog.dismissWithAnimation();
                                        new SweetAlertDialog(Login.this, SweetAlertDialog.WARNING_TYPE)
                                                .setTitleText("Atencion")
                                                .setContentText("No tienes conexión a Internet")
                                                .setConfirmText("Entendido")
                                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                                    @Override
                                                    public void onClick(SweetAlertDialog sDialog) {
                                                        sDialog.dismissWithAnimation();
                                                    }
                                                })
                                                .show();
                                    }

                                }
                            }
                        };
                        timerThread.start();


                    }
                    else{
                        txt_secret.setError("Este campo es obligatorio.");
                    }
                }
                else {
                    txt_correo.setError("Este campo es obligatorio.");
                }
            }
        });
    }



    public boolean isConecctedToInternet() {

        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }
        return false;
    }

    private void LoginWebService(String rawJson) {
        /*pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Iniciando");
        pDialog.setCancelable(false);*/


        ServicioAsyncService servicioAsyncService = new ServicioAsyncService(this, WebService.Login, rawJson, WebService.POST);
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
                        dto_login = gson.fromJson(result.get("Resultado").toString(), DTO_Login.class);
                    }
                } catch (Exception error) {
                    pDialog.dismissWithAnimation();
                    Log.d("Error ModelLogin", error.toString());
                }
            }

            @Override
            public void onTaskUpdate(String result) {
                pDialog.dismissWithAnimation();
            }

            @Override
            public void onTaskComplete(HashMap<String, Object> result) {
                pDialog.dismissWithAnimation();

                if (!dto_login.isError){
                    pref.setNOMBRE(dto_login.data.name);
                    pref.setCORREO(dto_login.data.email);
                    pref.setSesion(false);

                    ChildController childController = new ChildController(Login.this);
                    Child child;

                    childController.eliminarTodo();

                    for (Child childs : dto_login.data.childs ){

                        childController.guardarChild(childs);
                        /*child  = new Child();
                        child.setId_child(childs.id_child);
                        child.setName(childs.name);
                        child.setMessage_color(childs.message_color);
                        child.setTag(childs.tag);
                        childController.guardarChild(child);*/
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
                }
            }

            @Override
            public void onTaskCancelled(HashMap<String, Object> result) {
                pDialog.dismissWithAnimation();
            }
        });
        servicioAsyncService.execute();
    }

}
