package com.example.iop9i.airconplus;

import android.os.Bundle;
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

import com.google.firebase.auth.FirebaseAuth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseAuth mAuth = FirebaseAuth.getInstance ();
    private String myUID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        /*
        myUID = mAuth.getCurrentUser ().getUid ();
        try{
            ServerSocket serverSocket = new ServerSocket (8765);
            System.out.println("클라이언트 접속 대기 중...");
            Socket socket = serverSocket.accept();
            System.out.println("클라이언트 접속");

            BufferedReader in = new BufferedReader (new InputStreamReader (socket.getInputStream ()));
            PrintWriter out = new PrintWriter (socket.getOutputStream (), true);
            myUID = in.readLine ();
            System.out.println ("Received : " + myUID);
            out.println ("Echo : " + myUID);
            System.out.println("Send : " + myUID);
            socket.close ();
            serverSocket.close ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
*/

        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Snackbar.make (view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction ("Action", null).show ();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById (R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle (
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener (toggle);
        toggle.syncState ();

        NavigationView navigationView = (NavigationView) findViewById (R.id.nav_view);
        navigationView.setNavigationItemSelectedListener (this);

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

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected (item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId ();

        FragmentManager manager = getSupportFragmentManager ();

        if (id == R.id.nav_fist_layout) {
            manager.beginTransaction ().replace (R.id.content_main, new FirstLayout ()) .commit ();
        } else if (id == R.id.nav_second_layout) {
            manager.beginTransaction ().replace (R.id.content_main, new SecondLayout ()) .commit ();
        } else if (id == R.id.nav_third_layout) {
            manager.beginTransaction ().replace (R.id.content_main, new ThirdLayout ()) .commit ();
        } else if (id == R.id.nav_fourth_layout) {
            manager.beginTransaction ().replace (R.id.content_main, new FourthLayout ()) .commit ();
        } /*else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById (R.id.drawer_layout);
        drawer.closeDrawer (GravityCompat.START);
        return true;
    }
}
