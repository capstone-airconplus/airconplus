package com.example.iop9i.airconplus;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class eachFunction {

    // 전기세 계산해주는 함수
    double cal_electricity_fee(double time, double power){
        double fee = 0;
        fee = time * power;
        return fee;
    }

    // 절감된 전기세 계산
    double cal_reduced_electricity_fee(double fee, double temp){
        double reduced_fee=0;
        if(temp > 0 && temp < 35){
            reduced_fee = fee * 1.0;
        }else if(temp >= 35 && temp <40){
            reduced_fee = fee * 0.7;
        }else if(temp >= 40 && temp <50){
            reduced_fee = fee * 0.6;
        }else if(temp >=50 ){
            reduced_fee = fee * 0.5;
        }
        return reduced_fee;
    }

}
