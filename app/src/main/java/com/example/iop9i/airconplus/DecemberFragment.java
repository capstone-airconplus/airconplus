package com.example.iop9i.airconplus;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DecemberFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DecemberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DecemberFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View v;
    private BarChart barChart;
    private Button next_Btn;
    private Button previous_Btn;

    private OnFragmentInteractionListener mListener;

    public DecemberFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DecemberFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DecemberFragment newInstance(String param1, String param2) {
        DecemberFragment fragment = new DecemberFragment();
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
        v= inflater.inflate(R.layout.fragment_december, container, false);

        previous_Btn = (Button) v.findViewById(R.id.previous_dec_Button);
        next_Btn = (Button) v.findViewById(R.id.next_dec_Button);
        barChart = (BarChart)v.findViewById(R.id.decemberchart);

        previous_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_2, new NovemberFragment());
                fragmentTransaction.commit();
            }
        });

        next_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager ();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
                fragmentTransaction.replace (R.id.fragment_2, new OctoberFragment());
                fragmentTransaction.commit ();

            }
        });

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
