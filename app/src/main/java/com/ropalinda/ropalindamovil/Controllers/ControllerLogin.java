package com.ropalinda.ropalindamovil.Controllers;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.ropalinda.ropalindamovil.Entities.Login;
import com.ropalinda.ropalindamovil.Entities.WSRes;
import com.ropalinda.ropalindamovil.R;
import com.ropalinda.ropalindamovil.Utils.Preferencias;
import com.ropalinda.ropalindamovil.Utils.SingletonRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        sign_in_button.setOnClickListener(v -> {

            String mail = txt_email.getText().toString();
            String pass = txt_password.getText().toString();

            System.out.println(mail);
            System.out.println(pass);
            Login.Request req = new Login.Request(mail, pass);
            SingletonRetrofit.WSClient()
                    .login(req)
                    .enqueue(new Callback<WSRes<Login.Response>>() {
                        @Override
                        public void onResponse(Call<WSRes<Login.Response>> call, Response<WSRes<Login.Response>> response) {
                            final WSRes<Login.Response> res = response.body();
                            switch (res.getMeta().getStatus()){
                                case OK:
                                    showOk(res.getMeta().getMessage());
                                    break;
                                case WARNING:
                                case INVALID_PARAM:
                                case ACCESS_DENIED:
                                    showWarning(res.getMeta().getMessage());
                                    break;
                            }
                        }

                        @Override
                        public void onFailure(Call<WSRes<Login.Response>> call, Throwable t) {
                            showERROR(t.getMessage());
                        }
                    });

        });
    }


    void showWarning(String message){
        View v = findViewById(R.id.parentContainer);
        Snackbar sb = Snackbar.make(v, message, Snackbar.LENGTH_LONG);
        sb.getView().setBackgroundResource(R.color.warning);
        sb.show();
    }


    void showOk(String message){
        View v = findViewById(R.id.parentContainer);
        Snackbar sb = Snackbar.make(v, message, Snackbar.LENGTH_LONG);
        sb.getView().setBackgroundColor(Color.GREEN);
        sb.show();
    }

    public void showERROR(String message) {
        View v = findViewById(R.id.parentContainer);
        Snackbar sb = Snackbar.make(v, message, Snackbar.LENGTH_LONG);
        sb.getView().setBackgroundColor(Color.RED);
        sb.show();
    }

}
