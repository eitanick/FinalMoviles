package com.example.anthony.clinicplace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    private CircleImageView profile_picture;
    private TextView username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profile_picture=(CircleImageView)findViewById(R.id.profile_picture);
        username =(TextView)findViewById(R.id.username);

        if (getIntent().getData()!=null)
        profile_picture.setImageURI(getIntent().getData());
        username.setText(getIntent().getExtras().getString("username"));
    }
}
