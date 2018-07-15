package com.example.hasnainali.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btLog;
    EditText EUN,EP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btLog=(Button)findViewById(R.id.btnLog);
        EUN=(EditText)findViewById(R.id.ETUN);
        EP=(EditText)findViewById(R.id.ETP);

        btLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UN = ("Hasnain");
                String Pass = ("1234");
                StringBuilder Check=new StringBuilder();

                if(EUN.getText().toString().equals(UN) && EP.getText().toString().equals(Pass))
                {
                    Check.append("Login Granted");
                    Toast.makeText(getApplicationContext(), Check.toString(), Toast.LENGTH_LONG).show();
                }
                else
                {
                    Check.append("Invalid UserName Or Password!");
                    Toast.makeText(getApplicationContext(), Check.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
