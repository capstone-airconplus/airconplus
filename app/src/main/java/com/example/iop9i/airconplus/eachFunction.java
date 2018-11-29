package com.example.iop9i.airconplus;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class eachFunction {


    // test 부분
    FirebaseDatabase mDB = FirebaseDatabase.getInstance();
    DatabaseReference mRef = mDB.getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    Float[] fl_day = new Float[32];
    String str_day;

    void main(){
        mRef.child(mAuth.getUid()).child("use_power").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

//                int p=27;
//                String getday = Integer.toString(p+1);
//                String str_day = dataSnapshot.child("2018-11").child(getday).child("use").getValue().toString();
//                fl_day[p] = Float.parseFloat(str_day);
//                System.out.println("===day==================================================");
//                System.out.println(fl_day[p]);
                for(int p=0; p<31; p++){
                    String getday = Integer.toString(p+1);
                    if(dataSnapshot.child("2018-11").child(getday).child("use").getValue() == null){
                        str_day = "0";
                    }else{
                        str_day = dataSnapshot.child("2018-11").child(getday).child("use").getValue().toString();
                    }
                    System.out.println(str_day);
                    fl_day[p] = Float.parseFloat(str_day);
                    System.out.println("day " + (p+1) + " : " + fl_day[p]);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    // test 끝


    // 전기세를 계산
    double cal_electricity_fee(double time, double power){
        double fee = 0;
        fee = time * power;
        return fee;
    }

    // 절감된 전기세 계산
    double cal_reduced_electricity_fee(double fee, double temp){
        double reduced_fee=0;
        if(temp < 32){
            reduced_fee = fee * 0;
        }else if(temp >= 32 && temp <36){
            reduced_fee = fee * 0.12;
        }else if(temp >= 36 && temp <40){
            reduced_fee = fee * 0.15;
        }else if(temp >=40 ){
            reduced_fee = fee * 0.36;
        }
        return reduced_fee;
    }

}
