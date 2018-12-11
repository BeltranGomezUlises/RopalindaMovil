package com.ropalinda.ropalindamovil.Models;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.ropalinda.ropalindamovil.Controllers.ControllerInicio;
import com.ropalinda.ropalindamovil.Entities.Login;
import com.ropalinda.ropalindamovil.Entities.WSRes;
import com.ropalinda.ropalindamovil.Utils.Preferencias;
import com.ropalinda.ropalindamovil.Utils.SingletonRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelLogin{

    Preferencias pref;
    Context context;

    public ModelLogin(Context context) {
        this.context = context;
    }


    public void login(Login.Request req){
        this.pref = new Preferencias(context);

        SingletonRetrofit.WSClient()
                .login(req)
                .enqueue(new Callback<WSRes<Login.Response>>() {
                    @Override
                    public void onResponse(Call<WSRes<Login.Response>> call, Response<WSRes<Login.Response>> response) {
                        final WSRes<Login.Response> res = response.body();
                        switch (res.getMeta().getStatus()){
                            case OK:
                                Intent intent = new Intent(context, ControllerInicio.class);
                                pref.setSesion(false);
                                pref.setTOKEN(res.getData().getToken());
                                context.startActivity(intent);
                                break;
                            case WARNING:
                            case INVALID_PARAM:
                            case ACCESS_DENIED:
                                //showWarning(res.getMeta().getMessage());
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<WSRes<Login.Response>> call, Throwable t) {
                        //showERROR(t.getMessage());
                    }
                });
    }
}
