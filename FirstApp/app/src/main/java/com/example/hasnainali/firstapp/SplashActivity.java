package com.example.hasnainali.firstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {
    Button btLogin,btCamera,btCall,btMap,btMenu,btExit,btMusic,btRateUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        btLogin=(Button) findViewById(R.id.btnLogin);
        btCamera=(Button) findViewById(R.id.btnCamera);
        btCall=(Button) findViewById(R.id.btnCall);
        btMenu=(Button) findViewById(R.id.btnMenu);
        btExit=(Button) findViewById(R.id.btnExit);
        btMusic=(Button) findViewById(R.id.btnMusic);
        btMap = (Button) findViewById(R.id.btnMap);
        btRateUs=(Button)findViewById(R.id.btnRateUs);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SplashActivity.this ,"Login",Toast.LENGTH_SHORT).show();
                Intent loginIntent = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(loginIntent);
            }

        });

        btCamera .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SplashActivity.this ,"Take Picture",Toast.LENGTH_SHORT).show();
                Intent CameraIntent = new Intent(SplashActivity.this,CameraActivity.class);
                startActivity(CameraIntent);
            }
        });

        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SplashActivity.this ,"Call",Toast.LENGTH_SHORT).show();
                Intent CallIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:1020"));
                startActivity(CallIntent);
            }

        });

        btMenu .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SplashActivity.this ,"Menu",Toast.LENGTH_SHORT).show();
                Intent MenuIntent = new Intent(SplashActivity.this,CheckedBoxActivity.class);
                startActivity(MenuIntent);
            }
        });

        btMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SplashActivity.this ,"Play Music",Toast.LENGTH_SHORT).show();
                Intent MusicIntent = new Intent(SplashActivity.this,PlayMusicActivity.class);
                startActivity(MusicIntent);
            }
        });
        btMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SplashActivity.this ,"Google Map",Toast.LENGTH_SHORT).show();
                Intent MapIntent = new Intent(Intent.ACTION_VIEW);
                MapIntent.setData(Uri.parse("geo:24.8799064,67.05886950000001"));
                Intent Chooser = Intent.createChooser(MapIntent,"Launch Map");
                startActivity(Chooser);
            }
        });
        btRateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SplashActivity.this ,"Rate Us",Toast.LENGTH_SHORT).show();
                Intent RateIntent = new Intent(SplashActivity.this,RateActivity.class);
                startActivity(RateIntent);
            }
        });
        btExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this);
                builder.setMessage("Do you want to close this application ?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                builder.setTitle("Exit");
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}
