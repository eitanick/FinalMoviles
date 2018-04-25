package com.example.anthony.clinicplace;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferObserver;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferUtility;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import java.io.File;
import java.net.URI;

import static com.example.anthony.clinicplace.R.id.saltar;

public class MainActivity extends Activity {
    private Button ingresar;
    private TextView username;
    private File imagen;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the Amazon Cognito credentials provider

        //TransferUtility transferUtility = new TransferUtility(s3, getApplicationContext());
        //TransferObserver observer = transferUtility.download(
          //      "clinicplace",     /* The bucket to download from */
            //    "logo.png",    /* The key for the object to download */
              //  imagen     /* The file to download the object to */
        //);
        logo= (ImageView)findViewById(R.id.logo);
        //logo.setImageURI(Uri.fromFile(imagen));
       TextView SignIn= (TextView) findViewById(R.id.registrar);
        ingresar=(Button)(findViewById(R.id.ingresar));
        username=(TextView)findViewById(R.id.username);
        SignIn.setOnClickListener(new View.OnClickListener() {
             @Override
            public void onClick(View view) {

                Intent logInIntent = new Intent(MainActivity.this, SignInActicity.class);


                startActivity(logInIntent);
            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent editIntent = new Intent(MainActivity.this, ProfileActivity.class);
                editIntent.putExtra("username",username.getText().toString());
                startActivity(editIntent);
            }});
    }
}
