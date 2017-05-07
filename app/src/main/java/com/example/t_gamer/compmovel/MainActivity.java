package com.example.t_gamer.compmovel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.login);
    }

    public void onLoginClick(View v){
        ScrollView scLoginForm = (ScrollView) findViewById(R.id.login_form);
        ProgressBar pbLogionProgress = (ProgressBar) findViewById(R.id.login_progress);

        scLoginForm.setVisibility(View.INVISIBLE);
        pbLogionProgress.setVisibility(View.VISIBLE);

        Button btnRegistrar = (Button) findViewById(R.id.btnLoginRegister),
                btnLogin = (Button) findViewById(R.id.btnLogin);

        EditText etEmail = (EditText) findViewById(R.id.etLoginEmail),
                etPassword = (EditText) findViewById(R.id.etLoginPassword);
        boolean bLoginStatus = true; //Mudar para falso e true somente se passar nas validações abaixo
                /* Validações aqui*/

                /* --------------- */

        if(bLoginStatus == true){
            Intent i = new Intent(this, Home.class);
            startActivity(i);
        } else {
            pbLogionProgress.setVisibility(View.INVISIBLE);
            scLoginForm.setVisibility(View.VISIBLE);
        }
    }

    public void onRegisterClick(View v){
        startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
    }
}
