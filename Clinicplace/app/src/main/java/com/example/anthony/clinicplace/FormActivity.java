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


public class FormActivity extends AppCompatActivity {
    private float contraseña_segura;
    private TextView texto;
    private EditText Password;
    private ProgressBar pb;
    private TextView ncorreo;
    private EditText rPassword;
    private Button enviar;
    private EditText username;

    private boolean Coinciden(String password1, String password2){

        if (password1.equals(password2))
        {
           return true;
        }
        else
            return false;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        Password = (EditText) (findViewById(R.id.contraseña));
        pb= (ProgressBar)(findViewById(R.id.robustez));
        texto= (TextView)(findViewById(R.id.progress));
        Password.addTextChangedListener(watcher);
        ncorreo= (TextView)(findViewById(R.id.correo));
        enviar = (Button)(findViewById(R.id.enviar));
        rPassword= (EditText)(findViewById(R.id.contraseña2));
        username=(EditText)(findViewById(R.id.usuario));
        //Tomo el correo del activity anterior
        ncorreo.setText(getIntent().getExtras().getString("correo"));
        //ENVIAR
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(pb.getProgress()<25)
                    Password.setError("Contraseña debil");
                else {

                    if (Coinciden(Password.getText().toString(), rPassword.getText().toString()) == false) {
                        rPassword.setError("No coiniciden las contraseñas");
                    } else {
                        Intent signInIntent = new Intent(FormActivity.this, WelcomeActivity.class);
                        signInIntent.putExtra("correo",ncorreo.getText().toString());
                        signInIntent.putExtra("username",username.getText().toString());
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




