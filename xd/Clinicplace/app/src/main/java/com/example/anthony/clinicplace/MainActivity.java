package com.example.anthony.clinicplace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends Activity {


    private Button btnIngresar;
    private EditText txtUsuario;
    private TextView txtRegistro;
    private EditText txtContraseña;
    private String usuario;
    private String contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tomar datos del layout
        txtUsuario = (EditText)findViewById(R.id.user);
        usuario=txtUsuario.getText().toString();
        txtContraseña = (EditText) findViewById(R.id.password);
        contraseña=txtContraseña.getText().toString();
        txtRegistro = (TextView)findViewById(R.id.signUp);
        btnIngresar=(Button)findViewById(R.id.logIn);

        txtRegistro.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View view) {

                Intent logInIntent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(logInIntent);
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent editIntent = new Intent(MainActivity.this, ProfileActivity.class);
                        startActivity(editIntent);
            }});
    }
}
