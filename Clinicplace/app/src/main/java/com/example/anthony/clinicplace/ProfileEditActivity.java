package com.example.anthony.clinicplace;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileEditActivity extends AppCompatActivity {
    private TextView correo;
    private TextView usuario;
    private Button guardar;
    private CircleImageView profile_picture;
    private  Uri imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        correo= (TextView)(findViewById(R.id.email));
        usuario=(TextView)(findViewById(R.id.username));
        profile_picture=(CircleImageView)(findViewById(R.id.profile_picture));
        imagen = getIntent().getData();
        profile_picture.setImageURI(imagen);
        correo.setText(getIntent().getExtras().getString("correo"));
        usuario.setText(getIntent().getExtras().getString("username"));

       guardar = (Button) findViewById(R.id.save);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent profileIntent = new Intent(ProfileEditActivity.this, ProfileActivity.class);
                profileIntent.putExtra("username",usuario.getText().toString());
                profileIntent.setData(imagen);
                startActivity(profileIntent);
            }
        });

    }
}
