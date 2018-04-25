package com.example.anthony.clinicplace;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Pattern;


public class SignInActicity extends FragmentActivity {
    private static final String TAG = "MyActivity";
    private EditText email;


    private boolean validarEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_in_acticity);
        Button SignIn= (Button) findViewById(R.id.enviar);
        email = (EditText)(findViewById(R.id.correonuevo));
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validarEmail(email.getText().toString())){
                    email.setError("Email no válido");
                }
                else {
                    Intent signInIntent = new Intent(SignInActicity.this, FormActivity.class);
                    signInIntent.putExtra("correo",email.getText().toString());

                    startActivity(signInIntent);
                }

            }
        });

    }






}
