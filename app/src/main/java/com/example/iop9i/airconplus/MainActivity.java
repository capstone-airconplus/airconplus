package com.example.iop9i.airconplus;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView textView_intemp;
    private TextView textView_outtemp;
    private TextView textView_inhum;
    private TextView textView_outhum;
    private TextView textView_wind_strong;
    private TextView textView_wind_light;
    private TextView textView_wind_gentle;
    private ImageView imageView_ice;
    private ImageView imageView_dehum;
    private ImageView imageView_power;
    String strColor = "#546E7A";
    String strColor_2 = "#4fc3f7";
    String strColor_3 = "#aed581";


    DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mDB = mRoot.child("qi698BDarUgd2ERe1zLOr1GMx4D3");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView_intemp = (TextView) findViewById(R.id.textView4);
        textView_outtemp = (TextView) findViewById(R.id.textView7);
        textView_inhum = (TextView) findViewById(R.id.textView5);
        textView_outhum = (TextView) findViewById(R.id.textView8);
        textView_wind_strong = (TextView)findViewById(R.id.wind_strong);
        textView_wind_light = (TextView)findViewById(R.id.wind_light);
        textView_wind_gentle = (TextView)findViewById(R.id.wind_gentle);
        imageView_ice = (ImageView)findViewById(R.id.image_ice);
        imageView_dehum = (ImageView)findViewById(R.id.image_dehum);
        imageView_power = (ImageView)findViewById(R.id.image_power);




        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Snackbar.make (view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction ("Action", null).show ();
            }
        });
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        mDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Integer temp_in = dataSnapshot.child("indoor_temp").getValue(Integer.class);
                Integer temp_out = dataSnapshot.child("outdoor_fan_temp").getValue(Integer.class);
                Integer hum_in = dataSnapshot.child("indoor_hum").getValue(Integer.class);
                Integer hum_out = dataSnapshot.child("outdoor_fan_hum").getValue(Integer.class);
                Integer power = dataSnapshot.child("on").getValue(Integer.class);
                String temp_in2 = String.valueOf(temp_in);
                String temp_out2 = String.valueOf(temp_out);
                String hum_in2 = String.valueOf(hum_in);
                String hum_out2 = String.valueOf(hum_out);
                textView_intemp.setText(temp_in2 + "º");
                textView_outtemp.setText(temp_out2 + "º");
                textView_inhum.setText(hum_in2 + "%");
                textView_outhum.setText(hum_out2 + "%");
                if(temp_in<=28 && temp_in>=24){
                    textView_wind_strong.setTextColor(Color.parseColor(strColor));
                    textView_wind_light.setTextColor(Color.parseColor(strColor));
                    textView_wind_gentle.setTextColor(Color.parseColor(strColor_2));
                }else if(temp_in<=30 && temp_in>=22){
                    textView_wind_strong.setTextColor(Color.parseColor(strColor));
                    textView_wind_light.setTextColor(Color.parseColor(strColor_2));
                    textView_wind_gentle.setTextColor(Color.parseColor(strColor));
                }else{
                    textView_wind_strong.setTextColor(Color.parseColor(strColor_2));
                    textView_wind_light.setTextColor(Color.parseColor(strColor));
                    textView_wind_gentle.setTextColor(Color.parseColor(strColor));
                }
                if(hum_in>60){
                    imageView_dehum.setColorFilter(Color.parseColor(strColor_2));
                    imageView_ice.setColorFilter(Color.parseColor(strColor));

                }else{
                    imageView_dehum.setColorFilter(Color.parseColor(strColor));
                    imageView_ice.setColorFilter(Color.parseColor(strColor_2));
                }
                if(power==1){
                    imageView_power.setColorFilter(Color.parseColor(strColor_3));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById (R.id.drawer_layout);
        if (drawer.isDrawerOpen (GravityCompat.START)) {
            drawer.closeDrawer (GravityCompat.START);
        } else {
            super.onBackPressed ();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ().inflate (R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ();

        /*
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        */
        return super.onOptionsItemSelected (item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId ();

        FragmentManager manager = getSupportFragmentManager ();

        if (id == R.id.nav_fist_layout) {
            manager.beginTransaction ().replace (R.id.content_main, new FirstLayout()) .commit ();

        } else if (id == R.id.nav_second_layout) {
            manager.beginTransaction ().replace (R.id.content_main, new SecondLayout ()) .commit ();
        } else if (id == R.id.nav_third_layout) {
            manager.beginTransaction ().replace (R.id.content_main, new ThirdLayout ()) .commit ();
        } else if (id == R.id.nav_fourth_layout) {
            manager.beginTransaction ().replace (R.id.content_main, new FourthLayout ()) .commit ();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById (R.id.drawer_layout);
        drawer.closeDrawer (GravityCompat.START);
        return true;
    }
}
