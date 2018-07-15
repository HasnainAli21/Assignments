package com.example.hasnainali.firstapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ProgressBar prg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prg=(ProgressBar)findViewById(R.id.progressBar);
        prg.setMax(100);
        prg.setProgress(0);
        Thread thread = new Thread()
        {
            @Override
            public void run() {
                try
                {
                    for(int i=0 ; i<100 ; i++)
                    {
                        prg.setProgress(i);
                        sleep(20);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent LoadIntent = new Intent(getApplicationContext(),SplashActivity.class);
                    startActivity(LoadIntent);
                    finish();
                }
            }
        };
        thread.start();
    }
}
