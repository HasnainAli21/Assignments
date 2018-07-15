package com.example.hasnainali.firstapp_fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        displaySelectedScreen(R.id.nav_Home);
        navigationView.setCheckedItem(R.id.nav_Home);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
private void displaySelectedScreen(int id)
{
    Fragment fragment = null;
    switch (id)
    {
        case R.id.nav_Home:
            fragment = new HomeFragment();
            break;
        case R.id.nav_Login:
            fragment = new Login();
            break;
        case R.id.nav_ResturantMenu:
            fragment = new HomeFragment();
            break;
        case R.id.nav_TakePic:
            fragment = new HomeFragment();
            break;
        case R.id.nav_EmergencyCall:
            Toast.makeText(MainActivity.this ,"Call",Toast.LENGTH_SHORT).show();
            Intent CallIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:1020"));
            startActivity(CallIntent);
            break;
        case R.id.nav_10BestSOngs:
            fragment = new HomeFragment();
            break;
        case R.id.nav_GoogleMap:
            Toast.makeText(MainActivity.this ,"Google Map",Toast.LENGTH_SHORT).show();
            Intent MapIntent = new Intent(Intent.ACTION_VIEW);
            MapIntent.setData(Uri.parse("geo:24.8799064,67.05886950000001"));
            Intent Chooser = Intent.createChooser(MapIntent,"Launch Map");
            startActivity(Chooser);
            break;
        case R.id.nav_RateUS:
            fragment = new HomeFragment();
            break;
        case R.id.nav_Exit:
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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
            break;
    }
    if(fragment != null)
    {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.rlMain,fragment);
        ft.commit();
    }
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
}
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
/*
        if (id == R.id.nav_Home) {

        } else if (id == R.id.nav_Login) {

        } else if (id == R.id.nav_ResturantMenu) {

        } else if (id == R.id.nav_TakePic) {

        } else if (id == R.id.nav_EmergencyCall) {

        } else if (id == R.id.nav_10BestSOngs) {

        }else if (id == R.id.nav_GoogleMap) {

        }else if (id == R.id.nav_RateUS) {

        }else if (id == R.id.nav_Exit) {

        }*/
        displaySelectedScreen(id);
        return true;
    }
}
