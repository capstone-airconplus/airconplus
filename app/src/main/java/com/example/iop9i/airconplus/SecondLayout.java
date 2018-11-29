package com.example.iop9i.airconplus;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SecondLayout extends Fragment {
    View v;


    private BarChart barChart;
    private Button next_Btn;
    private Button previous_Btn;
    private LinearLayout notice_second;
    FirebaseDatabase mDB = FirebaseDatabase.getInstance();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    DatabaseReference mRef = mDB.getReference().getRoot();
    LoginDTO loginDTO = new LoginDTO();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("@@@@@@@@@@@@@@@oncreate 잘되지?@@@@@@@@");
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        System.out.println(mAuth.getUid());
        System.out.println("세컨드 레이아웃 잘찍히지?@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        // get db test
        mRef.child(mAuth.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                loginDTO = dataSnapshot.getValue(LoginDTO.class);
                System.out.println("@@@@@DB 잘 들어갔나요??@@@@@@@@@@@@@@");
                System.out.println(loginDTO.aircon_name);
                System.out.println(loginDTO.indoor_temp);

                for(DataSnapshot DBchange : dataSnapshot.getChildren()){
                    System.out.println(DBchange.getValue());
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println( " 여기 에러 나왔엉 @@@@@@@@@@@@@@@@@@@@@@@@@@@");
            }
        });


        // loginDTO.indoor_temp
        v = inflater.inflate (R.layout.second_layout, container, false);

        previous_Btn = (Button) v.findViewById(R.id.previous_nov_Button);
        next_Btn = (Button) v.findViewById(R.id.next_nov_Button);
        notice_second = (LinearLayout)v.findViewById (R.id.notice_2);

        previous_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice_second.setVisibility(View.GONE);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_2, new OctoberFragment());
                fragmentTransaction.commit();
            }
        });

        next_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice_second.setVisibility (View.GONE);
                FragmentManager fragmentManager = getFragmentManager ();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
                fragmentTransaction.replace (R.id.fragment_2, new DecemberFragment());
                fragmentTransaction.commit ();

            }
        });


        barChart = (BarChart)v.findViewById(R.id.novemberchart);

        ArrayList<BarEntry> entries = new ArrayList<> (); //전력량 그래프
        entries.add(new BarEntry(1, 3));
        entries.add(new BarEntry(2, 4));
        entries.add(new BarEntry(3, 3));
        entries.add(new BarEntry(4, 4));
        entries.add(new BarEntry(5, 5));
        entries.add(new BarEntry(6, 6));
        entries.add(new BarEntry(7, 7));
        entries.add(new BarEntry(8, 8));
        entries.add(new BarEntry(7, 9));
        entries.add(new BarEntry(8, 10));
        entries.add(new BarEntry(9, 1));
        entries.add(new BarEntry(10, 2));
        entries.add(new BarEntry(11, 0));
        entries.add(new BarEntry(12, 4));
        entries.add(new BarEntry(13, 3));
        entries.add(new BarEntry(14, 0));
        entries.add(new BarEntry(15, 4));
        entries.add(new BarEntry(16, 3));
        entries.add(new BarEntry(17, 1));
        entries.add(new BarEntry(18, 2));
        entries.add(new BarEntry(19, 0));
        entries.add(new BarEntry(20, 4));
        entries.add(new BarEntry(21, 3));
        entries.add(new BarEntry(22, 0));
        entries.add(new BarEntry(23, 4));
        entries.add(new BarEntry(24, 3));
        entries.add(new BarEntry(25, 1));
        entries.add(new BarEntry(26, 2));
        entries.add(new BarEntry(27, 0));
        entries.add(new BarEntry(28, 4));
        entries.add(new BarEntry(29, 3));
        entries.add(new BarEntry(30, 0));
        entries.add(new BarEntry(31, 4));

        BarDataSet barDataSet = new BarDataSet(entries, "전력량");//속성 이름
        //lineDataSet.setLineWidth(2);
        //lineDataSet.setCircleRadius(4); // 그래프에서 꼭지점 원 크기
        //barDataSet.setCircleColor(Color.parseColor("#FFA1B4DC"));
        //barDataSet.setCircleColorHole(Color.BLUE);
        barDataSet.setColor(Color.parseColor("#2196f3"));
        //barDataSet.setDrawCircleHole(true);
        //barDataSet.setDrawCircles(true);
        //barDataSet.setDrawHorizontalHighlightIndicator(false);
        //barDataSet.setDrawHighlightIndicators(false);
        barDataSet.setDrawValues(false);


        ArrayList<BarEntry> entries_2 = new ArrayList<> (); //전력량 그래프
        entries_2.add(new BarEntry(1, 0));
        entries_2.add(new BarEntry(2, 1/2));
        entries_2.add(new BarEntry(3, 5));
        entries_2.add(new BarEntry(4, 1));
        entries_2.add(new BarEntry(5, 2));
        entries_2.add(new BarEntry(6, 1));
        entries_2.add(new BarEntry(7, 2));
        entries_2.add(new BarEntry(8, 0));
        entries_2.add(new BarEntry(9, 1));
        entries_2.add(new BarEntry(10, 1));
        entries_2.add(new BarEntry(11, 1));
        entries_2.add(new BarEntry(12, 1));
        entries_2.add(new BarEntry(13, 1));
        entries_2.add(new BarEntry(14, 1));
        entries_2.add(new BarEntry(15, 1));
        entries_2.add(new BarEntry(16, 1));
        entries_2.add(new BarEntry(17, 1));
        entries_2.add(new BarEntry(18, 1));
        entries_2.add(new BarEntry(19, 1));
        entries_2.add(new BarEntry(20, 1));
        entries_2.add(new BarEntry(21, 1));
        entries_2.add(new BarEntry(22, 1));
        entries_2.add(new BarEntry(23, 1));
        entries_2.add(new BarEntry(24, 1));
        entries_2.add(new BarEntry(25, 1));
        entries_2.add(new BarEntry(26, 1));
        entries_2.add(new BarEntry(27, 1));
        entries_2.add(new BarEntry(28, 1));
        entries_2.add(new BarEntry(29, 1));
        entries_2.add(new BarEntry(30, 1));
        entries_2.add(new BarEntry(31, 1));

        BarDataSet barDataSet_2 = new BarDataSet(entries_2, "전기세");//속성 이름

        //barDataSet_2.setLineWidth(2);
        //barDataSet_2.setCircleRadius(4); // 그래프에서 꼭지점 원 크기
        //barDataSet_2.setCircleColor(Color.parseColor("#ffee58"));
        //barDataSet_2.setCircleColorHole(Color.YELLOW);
        barDataSet_2.setColor(Color.parseColor("#ffee58"));
        //barDataSet_2.setDrawCircleHole(true);
        //barDataSet_2.setDrawCircles(true);
        //barDataSet_2.setDrawHorizontalHighlightIndicator(false);
        //barDataSet_2.setDrawHighlightIndicators(false);
        barDataSet_2.setDrawValues(false);

        BarData barData = new BarData(barDataSet, barDataSet_2);
        barChart.setData (barData);


        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(Color.BLACK);
        xAxis.enableGridDashedLine(8, 24, 0);


        YAxis yLAxis = barChart.getAxisLeft();
        yLAxis.setTextColor(Color.BLACK);


        YAxis yRAxis = barChart.getAxisRight();
        yRAxis.setDrawLabels(false);
        yRAxis.setDrawAxisLine(false);
        yRAxis.setDrawGridLines(false);

        Description description = new Description();
        description.setText("");

        barChart.setDoubleTapToZoomEnabled(false);
        barChart.setDrawGridBackground(false);
        barChart.setDescription(description);
        barChart.animateY(2000, Easing.EasingOption.EaseInCubic);
        barChart.invalidate();

        return v;
    }
}
