package com.example.anthony.clinicplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ProgressBar;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.ui.AuthUIConfiguration;
import com.amazonaws.mobile.auth.ui.SignInActivity;


public class FormActivity extends AppCompatActivity {

    private EditText txtcorreo;
    private TextView texto;
    private EditText txtContraseña;
    private ProgressBar pb;
    private EditText txtContraseña2;
    private Button enviar;
    private String contraseña_usuario;
    private String correo_usuario;
    private String contraseña_repetida;

    private boolean Coinciden(String password1, String password2){

        if (password1.equals(password2))
        {
           return true;
        }
        else
            return false;
    }
    //Verificar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        //Toma de datos
        txtcorreo=(EditText)findViewById(R.id.email);
        correo_usuario= txtcorreo.getText().toString();
        txtContraseña = (EditText) (findViewById(R.id.password));
        contraseña_usuario= txtContraseña.getText().toString();
        txtContraseña2 =(EditText)findViewById(R.id.password2);
        contraseña_repetida =txtContraseña2.getText().toString();
        pb= (ProgressBar)(findViewById(R.id.passwordStrength));
        texto= (TextView)(findViewById(R.id.progress));
        txtContraseña.addTextChangedListener(watcher);
        enviar = (Button)(findViewById(R.id.signUp));
         //ENVIAR
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(pb.getProgress()<25)
                    txtContraseña.setError("Contraseña debil");
                else {

                    if (Coinciden(contraseña_usuario,contraseña_repetida) == false) {
                        txtContraseña2.setError("No coiniciden las contraseñas");
                    } else {

                        Intent signInIntent = new Intent(FormActivity.this, WelcomeActivity.class);
                        signInIntent.putExtra("correo",correo_usuario);
                        startActivity(signInIntent);
                    }
                }
            }
        });


        };


     TextWatcher watcher = new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

         }

         @Override
         public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (charSequence.length()>1) {
               //Ultimo caracter
                // texto2.setText(charSequence.subSequence(charSequence.length() - 1, charSequence.length()));

            }
         }

         @Override
         public void afterTextChanged(Editable editable) {
             if(editable.length()==0)
             {
                 texto.setText("Muy corta");
                 pb.setProgress(0);
             }
             else if(editable.length()<6)
             {
                 texto.setText("Muy Debil");
                 pb.setProgress(25);
             }

             else if(editable.length()<10)
             {
                 texto.setText("Debil");
                 pb.setProgress(50);
             }

             else if(editable.length()<15)
             {
                 texto.setText("Buena");
                 pb.setProgress(75);
             }
             else
             {
                 texto.setText("Excelente");
                 pb.setProgress(100);
             }

             if(editable.length()>=20)
             {
                 texto.setText("Muy larga");
                 pb.setProgress(0);
             }

         }
     };
    }




