package com.ropalinda.ropalindamovil.Models;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.ropalinda.ropalindamovil.Entities.Category;
import com.ropalinda.ropalindamovil.Entities.WSRes;
import com.ropalinda.ropalindamovil.Utils.Preferencias;
import com.ropalinda.ropalindamovil.Utils.SingletonRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ModelMain{

    List<Category> categories;
    Gson gson;
    Preferencias pref;
    Context context;

    public ModelMain(Context context) {
        this.context = context;
    }


    public List<Category> getCategories(){
        this.gson = new Gson();
        this.pref = new Preferencias(context);
        //this.categories = new List<>();

        SingletonRetrofit.WSClient()
                .categorias()
                .enqueue(new Callback<WSRes<List<Category>>>() {
                    @Override
                    public void onResponse(Call<WSRes<List<Category>>> call, Response<WSRes<List<Category>>> response) {
                        final WSRes<List<Category>> res = response.body();

                        switch (res.getMeta().getStatus()){
                            case OK:
                                //showOk(res.getMeta().getMessage());
                                Log.d("OK", "ok");
                                categories = res.getData();
                                break;
                            case WARNING:
                                Log.d("WARNING", res.getMeta().getMessage());
                                //showWarning(res.getMeta().getMessage());
                            case INVALID_PARAM:
                                Log.d("INVALID_PARAM", res.getMeta().getMessage());
                                break;
                            case ACCESS_DENIED:
                                Log.d("ACCES_DENIED", res.getMeta().getMessage());
                                //showWarning(res.getMeta().getMessage());
                                break;
                            case ERROR:
                                Log.d("ERROR", res.getMeta().getMessage());
                                //showERROR(res.getMeta().getMessage());
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<WSRes<List<Category>>> call, Throwable t) {
                        //showERROR(t.getMessage());
                        Log.d("FAIL", t.getMessage());
                    }
                });

        return categories;
    }
}
