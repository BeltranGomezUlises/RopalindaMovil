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
import com.ropalinda.ropalindamovil.Models.ModelLogin;
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
    View view;
    ModelLogin modelLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_login);
        modelLogin = new ModelLogin(this);

        this.txt_email = findViewById(R.id.txt_email);
        this.txt_password = findViewById(R.id.txt_password);
        this.view = findViewById(R.id.parentContainer);

        sign_in_button = findViewById(R.id.sign_in_button);
        sign_in_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mail = txt_email.getText().toString();
                String pass = txt_password.getText().toString();

                Login.Request req = new Login.Request(mail, pass);
                modelLogin.login(req);


            }
        });
    }

    void showWarning(String message){
        Snackbar sb = Snackbar.make(view , message, Snackbar.LENGTH_LONG);
        sb.getView().setBackgroundResource(R.color.warning);
        sb.show();
    }


    void showOk(String message){
        Snackbar sb = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        sb.getView().setBackgroundColor(Color.GREEN);
        sb.show();
    }

    public void showERROR(String message) {
        Snackbar sb = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        sb.getView().setBackgroundColor(Color.RED);
        sb.show();
    }

}
