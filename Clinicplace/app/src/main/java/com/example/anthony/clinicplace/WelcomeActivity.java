package com.example.anthony.clinicplace;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;



import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.anthony.clinicplace.R.id.correo;

/**
 * Created by Anthony on 20/10/2017.
 */

public class WelcomeActivity extends AppCompatActivity{
    private static final int PHOTO_SELECTED = 1;
    private TextView elegir;
    private TextView editar;
    private TextView mensajeBienvendio;
    private TextView saltar;
    private CircleImageView foto;
    private Uri imageUri;
    private String Susuario ;
    private String Scorreo;
    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PHOTO_SELECTED);
    }
    @Override
    protected void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        editar=(TextView)(findViewById(R.id.editar_parfil));
        saltar = (TextView)findViewById(R.id.saltar);
        mensajeBienvendio=(TextView)(findViewById(R.id.bienvenido));
        Susuario= getIntent().getExtras().getString("username");
        Scorreo= getIntent().getExtras().getString("correo");
        //Poner nombre usuario en mensaje
        mensajeBienvendio.setText("Bienvendio " + Susuario);
        //Cambiar foto
        elegir= (TextView)(findViewById(R.id.elegirFoto));
        elegir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openGallery();
            };

        });
        foto =(CircleImageView)(findViewById(R.id.fotoPerfil));
        foto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openGallery();
            }});
        //Cambiar Acitivty
        editar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent editIntent = new Intent(WelcomeActivity.this, ProfileEditActivity.class);
                editIntent.putExtra("correo",Scorreo);
                editIntent.putExtra("usuario",Susuario);
                editIntent.setData(imageUri);
                startActivity(editIntent);
            }});

        //Cambiar Acitivty
        saltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent editIntent = new Intent(WelcomeActivity.this, ProfileActivity.class);
                editIntent.putExtra("correo",Scorreo);
                editIntent.putExtra("username",Susuario);
                editIntent.setData(imageUri);
                startActivity(editIntent);
            }});
}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == PHOTO_SELECTED){
            imageUri = data.getData();
            foto.setImageURI(imageUri);
        }
    }
}