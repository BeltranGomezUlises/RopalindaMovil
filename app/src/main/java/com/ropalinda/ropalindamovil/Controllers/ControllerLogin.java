package com.ropalinda.ropalindamovil.Controllers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.ropalinda.ropalindamovil.R;
import com.ropalinda.ropalindamovil.Utils.Preferencias;

public class ControllerLogin extends AppCompatActivity {

    Button sign_in_button;
    AutoCompleteTextView txt_email;
    EditText txt_password;
    Preferencias pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);

        this.txt_email = findViewById(R.id.txt_email);
        this.txt_password = findViewById(R.id.txt_password);
        this.pref = new Preferencias(this);


        sign_in_button = findViewById(R.id.sign_in_button);
        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pref.setSesion(false);
                startActivity(new Intent(ControllerLogin.this, ControllerInicio.class));
                finish();

                /*if (!txt_correo.getText().toString().equals("")){
                    if (!txt_secret.getText().toString().equals("")){

                        pDialog = new SweetAlertDialog(ControllerLogin.this, SweetAlertDialog.PROGRESS_TYPE);
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
                                        new SweetAlertDialog(ControllerLogin.this, SweetAlertDialog.WARNING_TYPE)
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
                }*/
            }
        });
    }

    private void LoginWebService(String rawJson) {
        /*pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
        pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        pDialog.setTitleText("Iniciando");
        pDialog.setCancelable(false);*/


        /*ServicioAsyncService servicioAsyncService = new ServicioAsyncService(this, WebService.ControllerLogin, rawJson, WebService.POST);
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

                    ChildController childController = new ChildController(ControllerLogin.this);
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

                    Intent i = new Intent(ControllerLogin.this, ControllerMain.class);
                    startActivity(i);
                    finish();
                }
                else{
                    new SweetAlertDialog(ControllerLogin.this, SweetAlertDialog.WARNING_TYPE)
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
        servicioAsyncService.execute();*/
    }

}
