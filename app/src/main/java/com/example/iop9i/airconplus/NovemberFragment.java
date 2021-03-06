package com.example.iop9i.airconplus;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NovemberFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NovemberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

//11월
public class NovemberFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View v;
    private BarChart barChart;
    private BarChart barChart_2;
    private Button next_Btn;
    private Button previous_Btn;
    DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mDB = mRoot.child("qi698BDarUgd2ERe1zLOr1GMx4D3").child("use_power").child("2018-11");

    private OnFragmentInteractionListener mListener;

    // DB에서 값을 받아오기 위해서 파이어베이스 선언
    LoginDTO loginDTO = new LoginDTO();

    eachFunction each = new eachFunction();
    // 선언 완료

    // 사용할 변수들 선언
//    double day1;double day2;double day3;double day4;double day5;double day6;double day7;double day8;double day9;double day10;
//    double day11;double day12;double day13;double day14;double day15;double day16;double day17;double day18;double day19;double day20;
//    double day21;double day22;double day23;double day24;double day25;double day26;double day27;double day28;double day29;double day30;
//    double day31;
    //float[] fl_day = new float[32];  // DB에서 day의 use를 넣는 float형 list
    //float[] fl_reduction = new float[32];  // DB에서 day의 reduction를 넣느 float형 list

    Integer str_day;
    Integer str_red;

    String getday;
    // 변수 선언 완료
    public NovemberFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NovemberFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NovemberFragment newInstance(String param1, String param2) {

        // 이곳이 1순위일거 같음
        System.out.println("###########이곳이 1순위가 맞지요?#####################");

        NovemberFragment fragment = new NovemberFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_november, container, false);

        previous_Btn = (Button) v.findViewById(R.id.previous_nov_Button);
        next_Btn = (Button) v.findViewById(R.id.next_nov_Button);
        barChart = (BarChart)v.findViewById(R.id.novemberchart_money);
        barChart_2 = (BarChart)v.findViewById(R.id.novemberchart_time);


        previous_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_2, new OctoberFragment());
                fragmentTransaction.commit();
            }
        });

        next_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager ();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
                fragmentTransaction.replace (R.id.fragment_2, new DecemberFragment());
                fragmentTransaction.commit ();

            }
        });

        // 전력량 그래프 사용시간 * 표준전력량
        final ArrayList<BarEntry> entries = new ArrayList<> (); //전력량 그래프
/*
        mDB.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(int p=1; p<31; p++){
                    if(dataSnapshot.child(String.valueOf(p)).child("use").getValue(Integer.class) == null){
                        // 사용안한 날은 defalt 값을 0으로 초기화
                        str_day = 0;
                        str_red = 0;
                    }else{
                        str_day = dataSnapshot.child(String.valueOf(p)).child("use").getValue(Integer.class);
                        str_red = dataSnapshot.child(String.valueOf(p)).child("reduction").getValue(Integer.class);
                    }
                    entries.add(new BarEntry(p, str_day));
                }
                //Integer reduction = dataSnapshot.child("1").child("reduction").getValue(Integer.class);
                //System.out.println(reduction+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@weqe");


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        */



        entries.add(new BarEntry(1, 3*1000));
        System.out.println("###엔트리 확인하는 부분##########################");
        System.out.println(entries);
        System.out.println("###엔트리 확인 완료###############################");
        try {
            System.out.println(each.get_fl_day(1));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        entries.add(new BarEntry(2, 2*1000));
        entries.add(new BarEntry(3, 0));
        entries.add(new BarEntry(4, 0));
        entries.add(new BarEntry(5, 0));
        entries.add(new BarEntry(6, 0));
        entries.add(new BarEntry(7, 0));
        entries.add(new BarEntry(8, (float)4.2*1000));
        entries.add(new BarEntry(9, 0));
        entries.add(new BarEntry(10, 0));
        entries.add(new BarEntry(11, 0));
        entries.add(new BarEntry(12, 0));
        entries.add(new BarEntry(13, 0));
        entries.add(new BarEntry(14, (float)2.3*1000));
        entries.add(new BarEntry(15, 0));
        entries.add(new BarEntry(16, 0));
        entries.add(new BarEntry(17, 0));
        entries.add(new BarEntry(18, 7*1000));
        entries.add(new BarEntry(19, 0));
        entries.add(new BarEntry(20, 0));
        entries.add(new BarEntry(21, 0));
        entries.add(new BarEntry(22, 0));
        entries.add(new BarEntry(23, 4*1000));
        entries.add(new BarEntry(24, 0));
        entries.add(new BarEntry(25, 0));
        entries.add(new BarEntry(26, 0));
        entries.add(new BarEntry(27, 0));
        entries.add(new BarEntry(28, 8*1000));
        entries.add(new BarEntry(29, 0));
        entries.add(new BarEntry(30, 10*1000));


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
        //barDataSet.setDrawValues(false);

        // Error 체크구간2
        System.out.println("에러 체크구간 2 : 이곳이 에러인가요?");

        // 이 페이지가 실행될 때 마다 DB에서 reduction을 갱신해 온다.

        // 갱신 완료

        // 절감된 전력량 DB에서 reduction
        ArrayList<BarEntry> entries_2 = new ArrayList<> (); //전력량 그래프

        entries_2.add(new BarEntry(1, 250));
        entries_2.add(new BarEntry(2, 178));
        entries_2.add(new BarEntry(3, 0));
        entries_2.add(new BarEntry(4, 0));
        entries_2.add(new BarEntry(5, 0));
        entries_2.add(new BarEntry(6, 0));
        entries_2.add(new BarEntry(7, 0));
        entries_2.add(new BarEntry(8, 356));
        entries_2.add(new BarEntry(9, 0));
        entries_2.add(new BarEntry(10, 0));
        entries_2.add(new BarEntry(11, 0));
        entries_2.add(new BarEntry(12, 0));
        entries_2.add(new BarEntry(13, 0));
        entries_2.add(new BarEntry(14, 178));
        entries_2.add(new BarEntry(15, 0));
        entries_2.add(new BarEntry(16, 0));
        entries_2.add(new BarEntry(17, 0));
        entries_2.add(new BarEntry(18, 631));
        entries_2.add(new BarEntry(19, 0));
        entries_2.add(new BarEntry(20, 0));
        entries_2.add(new BarEntry(21, 0));
        entries_2.add(new BarEntry(22, 0));
        entries_2.add(new BarEntry(23, 345));
        entries_2.add(new BarEntry(24, 0));
        entries_2.add(new BarEntry(25, 0));
        entries_2.add(new BarEntry(26, 0));
        entries_2.add(new BarEntry(27, 0));
        entries_2.add(new BarEntry(28, 764));
        entries_2.add(new BarEntry(29, 0));
        entries_2.add(new BarEntry(30, 940));

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
        //barDataSet_2.setDrawValues(false);

        ArrayList<BarEntry> entries_3 = new ArrayList<> (); //사용시간
        entries_3.add(new BarEntry(1, 3));
        entries_3.add(new BarEntry(2, 2));
        entries_3.add(new BarEntry(3, 0));
        entries_3.add(new BarEntry(4, 0));
        entries_3.add(new BarEntry(5, 0));
        entries_3.add(new BarEntry(6, 0));
        entries_3.add(new BarEntry(7, 0));
        entries_3.add(new BarEntry(8, (float)4.2));
        entries_3.add(new BarEntry(9, 0));
        entries_3.add(new BarEntry(10, 0));
        entries_3.add(new BarEntry(11, 0));
        entries_3.add(new BarEntry(12, 0));
        entries_3.add(new BarEntry(13, 0));
        entries_3.add(new BarEntry(14, (float)2.3));
        entries_3.add(new BarEntry(15, 0));
        entries_3.add(new BarEntry(16, 0));
        entries_3.add(new BarEntry(17, 0));
        entries_3.add(new BarEntry(18, 7));
        entries_3.add(new BarEntry(19, 0));
        entries_3.add(new BarEntry(20, 0));
        entries_3.add(new BarEntry(21, 0));
        entries_3.add(new BarEntry(22, 0));
        entries_3.add(new BarEntry(23, 4));
        entries_3.add(new BarEntry(24, 0));
        entries_3.add(new BarEntry(25, 0));
        entries_3.add(new BarEntry(26, 0));
        entries_3.add(new BarEntry(27, 0));
        entries_3.add(new BarEntry(28, 8));
        entries_3.add(new BarEntry(29, 0));
        entries_3.add(new BarEntry(30, 10));

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

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
