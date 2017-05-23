package com.example.t_gamer.compmovel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.register);
    }

    public void onRegisterClick(View v) {
        EditText mName = (EditText) findViewById(R.id.etRegisterName);
        EditText mEmail = (EditText) findViewById(R.id.etRegisterEmail);
        EditText mPassword = (EditText) findViewById(R.id.etRegisterPassword);

        TextView mErrContainer = (TextView) findViewById(R.id.tvRegisterErrorContainer);

        String sErrorMessage = "";

        ProgressBar pbLoading = (ProgressBar) findViewById(R.id.pbRegister);

        ScrollView svContainer = (ScrollView) findViewById(R.id.registerContainer);

        svContainer.setVisibility(View.GONE);
        pbLoading.setVisibility(View.VISIBLE);

        if(mName.getText().toString().compareTo("") != 0){
            if(mEmail.getText().toString().compareTo("") != 0){
                if(mPassword.getText().toString().compareTo("") != 0){
                            /* Registrar no Banco */

                            /* Se registrado com sucesso navega para a Home */
                    Intent i = new Intent(getApplicationContext(), Home.class);
                    startActivity(i);
                    finish();
                } else {
                    sErrorMessage = "O campo Senha é obrigatório!";
                }
            } else {
                sErrorMessage = "O campo Email é obrigatório!";
            }
        } else {
            sErrorMessage = "O campo Nome é obrigatório!";
        }

        mErrContainer.setText(sErrorMessage);

        pbLoading.setVisibility(View.GONE);
        svContainer.setVisibility(View.VISIBLE);

    }
}
