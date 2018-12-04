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
    private BarChart barChart_2;
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

        previous_Btn = (Button) v.findViewById(R.id.previous_dec_Button);
        next_Btn = (Button) v.findViewById(R.id.next_dec_Button);
        notice_second = (LinearLayout)v.findViewById (R.id.notice_2);

        previous_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice_second.setVisibility(View.GONE);
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_2, new NovemberFragment());
                fragmentTransaction.commit();
            }
        });

        next_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notice_second.setVisibility (View.GONE);
                FragmentManager fragmentManager = getFragmentManager ();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
                fragmentTransaction.replace (R.id.fragment_2, new OctoberFragment());
                fragmentTransaction.commit ();

            }
        });


        barChart = (BarChart)v.findViewById(R.id.decemberchart_money);

        barChart_2 = (BarChart)v.findViewById(R.id.decemberchart_time);

        ArrayList<BarEntry> entries = new ArrayList<> (); //총 전기세
        entries.add(new BarEntry(1, 7*1000));
        entries.add(new BarEntry(2, (float)3.1*1000));
        entries.add(new BarEntry(3, (float)2.4*1000));
        entries.add(new BarEntry(4, 0));
        entries.add(new BarEntry(5, 0));
        entries.add(new BarEntry(6, 0));
        entries.add(new BarEntry(7, 0));
        entries.add(new BarEntry(8, 0));
        entries.add(new BarEntry(7, 0));
        entries.add(new BarEntry(8, 0));
        entries.add(new BarEntry(9, 0));
        entries.add(new BarEntry(10, 0));
        entries.add(new BarEntry(11, 0));
        entries.add(new BarEntry(12, 0));
        entries.add(new BarEntry(13, 0));
        entries.add(new BarEntry(14, 0));
        entries.add(new BarEntry(15, 0));
        entries.add(new BarEntry(16, 0));
        entries.add(new BarEntry(17, 0));
        entries.add(new BarEntry(18, 0));
        entries.add(new BarEntry(19, 0));
        entries.add(new BarEntry(20, 0));
        entries.add(new BarEntry(21, 0));
        entries.add(new BarEntry(22, 0));
        entries.add(new BarEntry(23, 7*1000));
        entries.add(new BarEntry(24, 0));
        entries.add(new BarEntry(25, 0));
        entries.add(new BarEntry(26, 0));
        entries.add(new BarEntry(27, 0));
        entries.add(new BarEntry(28, 0));
        entries.add(new BarEntry(29, 0));
        entries.add(new BarEntry(30, 0));
        entries.add(new BarEntry(31, 0));

        BarDataSet barDataSet = new BarDataSet(entries, "전기세");//속성 이름
        //lineDataSet.setLineWidth(2);
        //lineDataSet.setCircleRadius(4); // 그래프에서 꼭지점 원 크기
        //barDataSet.setCircleColor(Color.parseColor("#FFA1B4DC"));
        //barDataSet.setCircleColorHole(Color.BLUE);
        barDataSet.setColor(Color.parseColor("#2196f3"));
        //barDataSet.setDrawCircleHole(true);
        //barDataSet.setDrawCircles(true);
        //barDataSet.setDrawHorizontalHighlightIndicator(false);
        //barDataSet.setDrawHighlightIndicators(false);
        //barDataSet.setDrawValues(false);


        ArrayList<BarEntry> entries_2 = new ArrayList<> (); //감면된 전기세 그래프
        entries_2.add(new BarEntry(1, 623));
        entries_2.add(new BarEntry(2, 237));
        entries_2.add(new BarEntry(3, 144));
        entries_2.add(new BarEntry(4, 0));
        entries_2.add(new BarEntry(5, 0));
        entries_2.add(new BarEntry(6, 0));
        entries_2.add(new BarEntry(7, 0));
        entries_2.add(new BarEntry(8, 0));
        entries_2.add(new BarEntry(9, 0));
        entries_2.add(new BarEntry(10, 0));
        entries_2.add(new BarEntry(11, 0));
        entries_2.add(new BarEntry(12, 0));
        entries_2.add(new BarEntry(13, 0));
        entries_2.add(new BarEntry(14, 0));
        entries_2.add(new BarEntry(15, 0));
        entries_2.add(new BarEntry(16, 0));
        entries_2.add(new BarEntry(17, 0));
        entries_2.add(new BarEntry(18, 0));
        entries_2.add(new BarEntry(19, 0));
        entries_2.add(new BarEntry(20, 0));
        entries_2.add(new BarEntry(21, 0));
        entries_2.add(new BarEntry(22, 0));
        entries_2.add(new BarEntry(23, 623));
        entries_2.add(new BarEntry(24, 0));
        entries_2.add(new BarEntry(25, 0));
        entries_2.add(new BarEntry(26, 0));
        entries_2.add(new BarEntry(27, 0));
        entries_2.add(new BarEntry(28, 0));
        entries_2.add(new BarEntry(29, 0));
        entries_2.add(new BarEntry(30, 0));
        entries_2.add(new BarEntry(31, 0));

        BarDataSet barDataSet_2 = new BarDataSet(entries_2, "감면된 전기세");//속성 이름

        //barDataSet_2.setLineWidth(2);
        //barDataSet_2.setCircleRadius(4); // 그래프에서 꼭지점 원 크기
        //barDataSet_2.setCircleColor(Color.parseColor("#ffee58"));
        //barDataSet_2.setCircleColorHole(Color.YELLOW);
        barDataSet_2.setColor(Color.parseColor("#ffee58"));
        //barDataSet_2.setDrawCircleHole(true);
        //barDataSet_2.setDrawCircles(true);
        //barDataSet_2.setDrawHorizontalHighlightIndicator(false);
        //barDataSet_2.setDrawHighlightIndicators(false);
        //barDataSet_2.setDrawValues(false);

        ArrayList<BarEntry> entries_3 = new ArrayList<> (); //사용시간
        entries_3.add(new BarEntry(1, 7));
        entries_3.add(new BarEntry(2, (float)3.1));
        entries_3.add(new BarEntry(3, (float)2.4));
        entries_3.add(new BarEntry(4, 0));
        entries_3.add(new BarEntry(5, 0));
        entries_3.add(new BarEntry(6, 0));
        entries_3.add(new BarEntry(7, 0));
        entries_3.add(new BarEntry(8, 0));
        entries_3.add(new BarEntry(9, 0));
        entries_3.add(new BarEntry(10, 0));
        entries_3.add(new BarEntry(11, 0));
        entries_3.add(new BarEntry(12, 0));
        entries_3.add(new BarEntry(13, 0));
        entries_3.add(new BarEntry(14, 0));
        entries_3.add(new BarEntry(15, 0));
        entries_3.add(new BarEntry(16, 0));
        entries_3.add(new BarEntry(17, 0));
        entries_3.add(new BarEntry(18, 0));
        entries_3.add(new BarEntry(19, 0));
        entries_3.add(new BarEntry(20, 0));
        entries_3.add(new BarEntry(21, 0));
        entries_3.add(new BarEntry(22, 0));
        entries_3.add(new BarEntry(23, 7));
        entries_3.add(new BarEntry(24, 0));
        entries_3.add(new BarEntry(25, 0));
        entries_3.add(new BarEntry(26, 0));
        entries_3.add(new BarEntry(27, 0));
        entries_3.add(new BarEntry(28, 0));
        entries_3.add(new BarEntry(29, 0));
        entries_3.add(new BarEntry(30, 0));
        entries_3.add(new BarEntry(31, 0));

        BarDataSet barDataSet_3 = new BarDataSet(entries_3, "사용시간");//속성 이름

        //barDataSet_2.setLineWidth(2);
        //barDataSet_2.setCircleRadius(4); // 그래프에서 꼭지점 원 크기
        //barDataSet_2.setCircleColor(Color.parseColor("#ffee58"));
        //barDataSet_2.setCircleColorHole(Color.YELLOW);
        barDataSet_3.setColor(Color.parseColor("#ffee58"));
        //barDataSet_2.setDrawCircleHole(true);
        //barDataSet_2.setDrawCircles(true);
        //barDataSet_2.setDrawHorizontalHighlightIndicator(false);
        //barDataSet_2.setDrawHighlightIndicators(false);
       // barDataSet_3.setDrawValues(false);

        BarData barData = new BarData(barDataSet, barDataSet_2);
        BarData barData_2 = new BarData(barDataSet_3);

        barChart.setData (barData);
        barChart_2.setData (barData_2);

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

        XAxis xAxis_2 = barChart_2.getXAxis();
        xAxis_2.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis_2.setTextColor(Color.BLACK);
        xAxis_2.enableGridDashedLine(8, 24, 0);


        YAxis yLAxis_2 = barChart_2.getAxisLeft();
        yLAxis_2.setTextColor(Color.BLACK);


        YAxis yRAxis_2 = barChart_2.getAxisRight();
        yRAxis_2.setDrawLabels(false);
        yRAxis_2.setDrawAxisLine(false);
        yRAxis_2.setDrawGridLines(false);

        Description description_2 = new Description();
        description_2.setText("");

        barChart_2.setDoubleTapToZoomEnabled(false);
        barChart_2.setDrawGridBackground(false);
        barChart_2.setDescription(description_2);
        barChart_2.animateY(2000, Easing.EasingOption.EaseInCubic);
        barChart_2.invalidate();

        return v;
    }
}
