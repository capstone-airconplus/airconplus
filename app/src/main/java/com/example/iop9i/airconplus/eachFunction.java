package com.example.iop9i.airconplus;

import android.support.annotation.NonNull;

import com.github.mikephil.charting.data.BarEntry;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static java.lang.Thread.sleep;

public class eachFunction {


    // test 부분
    FirebaseDatabase mDB = FirebaseDatabase.getInstance();
    DatabaseReference mRef = mDB.getReference();
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    //Float[] fl_day = new Float[32];
    //String str_day;
    LoginDTO loginDTO;


    float[] fl_day = new float[32];  // DB에서 day의 use를 넣는 float형 list
    float[] fl_reduction = new float[32];  // DB에서 day의 reduction를 넣느 float형 list

    String str_day;
    String str_red;

    String getday;


    void main(){
        //System.out.println(loginDTO.aircon_power);
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
        System.out.println("##########여기 확인좀 해주세요###########");
        System.out.println(mRef.child(mAuth.getUid()).child("use_power").child("2018-10").child("28"));

    }
    // test 끝

    void test(){
        //System.out.println("엔트리 값 : " + entries);  // 왠지 모르겠는데 이미 들어가 있음
        // test
        // Error 체크 구간 1
        //System.out.println("Error 체크구간1 : 이곳이 에러인가요?");

        // 에어컨파워를 가져오는 것

    }

    float get_fl_day(int num) throws InterruptedException {
        System.out.println(mRef.child(mAuth.getUid()).child("use_power").child("2018-10").child("28"));
        if(num < 0 || num > 31){
            System.out.println("잘못된 범위 Error 입니다.");
            return 0;
        }else{
            mRef.child(mAuth.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    //entries.clear(); // 한번 클리어해준다.
                    //System.out.println("엔트리 클리어했습니다." + entries);
                    loginDTO = dataSnapshot.getValue(LoginDTO.class);
                    System.out.println("loginDTO.aircon_power : " +loginDTO.aircon_power);
                    for(int p = 0; p <31; p++){
                        int int_getday = p+1;
                        getday = Integer.toString(int_getday);
                        if(dataSnapshot.child("use_power").child("2018-11").child(getday).child("use").getValue() == null){
                            // 사용안한 날은 defalt 값을 0으로 초기화
                            str_day = "0";
                            str_red = "0";
                        }else{
                            str_day = dataSnapshot.child("use_power").child("2018-11").child(getday).child("use").getValue().toString();
                            System.out.println("str_day test : " + str_day);
                            str_red = dataSnapshot.child("use_power").child("2018-11").child(getday).child("reduction").getValue().toString();
                            System.out.println("str_red test : " + str_red);
                        }
                        fl_day[p] = Float.parseFloat(str_day);
                        fl_reduction[p] = Float.parseFloat(str_red) * loginDTO.aircon_power;
                        System.out.println("fl_day 값입니다." + getday + "day :" + fl_day[p]);
                        System.out.println("fl_reduction 값입니다." + getday + "day : " + fl_reduction[p]);

                        //entries.add(new BarEntry( p+1, fl_day[p]));
                        //System.out.println("엔트리 add중입니다. : " + entries);
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
        sleep(300);
        float usetime = fl_day[num];
        System.out.println("####################################");
        System.out.println("usetime : " + usetime);
        return usetime;
    }
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
