package com.ropalinda.ropalindamovil.Utils;


import com.ropalinda.ropalindamovil.Entities.Category;
import com.ropalinda.ropalindamovil.Entities.Login;
import com.ropalinda.ropalindamovil.Entities.WSRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by arnoldo on 2/07/18.
 */
public interface RetrofitInterface {


    /**
     * servicio de login de cliente de la aplicación
     *
     * @param req modelo de reques con datos de autentificacion
     * @return modelo de respuesta del login del cliente
     */
    @POST("customers/login")
    Call<WSRes<Login.Response>> login(@Body Login.Request req);

    /**
     * servicio para obtener las categorias del cliente
     *
     * @param token        token de sesion
     * @param selectValues propiedades para seleccionar separadas por coma
     * @param whereValues  condiciones que cumplir separadas por coma
     * @return lista de categorias
     */
    @GET("categories")
    Call<WSRes<List<Category>>> categorias();

}
