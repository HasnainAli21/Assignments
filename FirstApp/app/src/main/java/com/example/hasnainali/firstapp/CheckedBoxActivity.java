package com.example.hasnainali.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckedBoxActivity extends AppCompatActivity {

    CheckBox cbP,cbC,cbB;
    Button btShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checked_box);
        cbP=(CheckBox)findViewById(R.id.cbPizza);
        cbC=(CheckBox)findViewById(R.id.cbCoffee);
        cbB=(CheckBox)findViewById(R.id.cbBurger);
        btShow=(Button)findViewById(R.id.btnShow);

        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalamount=0;
                StringBuilder Bill=new StringBuilder();
                Bill.append("Selected Items:");
                if(cbP.isChecked())
                {
                    Bill.append("\nPizza: 1100Rs");
                    totalamount = totalamount + 1100;
                }
                if(cbC.isChecked())
                {
                    Bill.append("\nCoffe:  100Rs");
                    totalamount = totalamount + 100;
                }
                if(cbB.isChecked())
                {
                    Bill.append("\nBurger: 200Rs");
                    totalamount = totalamount + 200;
                }
                Bill.append("\n\nTotal:  "+totalamount+"Rs");
                Toast.makeText(getApplicationContext(), Bill.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
