package com.example.iop9i.airconplus;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


public class FourthLayout extends Fragment {


    public FourthLayout(){

    }


    private Button samsung_Btn;
    private Button lg_Btn;
    private Button winia_Btn;
    private LinearLayout notice;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate (savedInstanceState);
    }

    View v;
    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate (R.layout.fourth_layout, container, false);

        samsung_Btn = (Button) v.findViewById(R.id.samsungButton);
        lg_Btn = (Button) v.findViewById(R.id.lgButton);
        winia_Btn = (Button) v.findViewById(R.id.winiaButton);
        notice = (LinearLayout)v.findViewById (R.id.notice);
        samsung_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility (View.GONE);
                samsung_Btn.setBackgroundColor (getResources ().getColor (R.color.colorPrimaryDark));
                lg_Btn.setBackgroundColor (getResources ().getColor (R.color.colorButton_background));
                winia_Btn.setBackgroundColor (getResources ().getColor (R.color.colorButton_background));
                FragmentManager fragmentManager = getFragmentManager ();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
                fragmentTransaction.replace (R.id.fragment, new SamsungFragment());
                fragmentTransaction.commit ();

            }
        });

        lg_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility (View.GONE);
                samsung_Btn.setBackgroundColor (getResources ().getColor (R.color.colorButton_background));
                lg_Btn.setBackgroundColor (getResources ().getColor (R.color.colorPrimaryDark));
                winia_Btn.setBackgroundColor (getResources ().getColor (R.color.colorButton_background));
                FragmentManager fragmentManager = getFragmentManager ();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
                fragmentTransaction.replace (R.id.fragment, new LgFragment());
                fragmentTransaction.commit ();

            }
        });

        winia_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice.setVisibility (View.GONE);
                samsung_Btn.setBackgroundColor (getResources ().getColor (R.color.colorButton_background));
                lg_Btn.setBackgroundColor (getResources ().getColor (R.color.colorButton_background));
                winia_Btn.setBackgroundColor (getResources ().getColor (R.color.colorPrimaryDark));
                FragmentManager fragmentManager = getFragmentManager ();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
                fragmentTransaction.replace (R.id.fragment, new WiniaFragment());
                fragmentTransaction.commit ();

            }
        });

        return v;
    }


}
