package com.example.iop9i.airconplus;

import android.text.Editable;

public class LoginDTO {
    String UID;
    String email;
    String aircon_name;
    double aircon_power;  // 표준전력량
    double indoor_temp;  // 내부 온도
    double indoor_hum;  // 내부 습도(humidity)
    double outdoor_temp;  // 외부 온도
    double outdoor_hum;  // 외부 습도
    double using_time;  // 사용시간
    double elec_fee;  // 전기세 electricity fee

    public LoginDTO(){}

    public LoginDTO(String UID, String email, String aircon_name, double aircon_power, int indoor_temp, int indoor_hum,
                    int outdoor_hum, int outdoor_temp, int using_time, int elec_fee){
        this.UID = UID;
        this.email = email;
        this.aircon_name = aircon_name;
        this.aircon_power = aircon_power;
        this.indoor_temp = indoor_temp;
        this.indoor_hum = indoor_hum;
        this.outdoor_temp = outdoor_temp;
        this.outdoor_hum = outdoor_hum;
        this.using_time = using_time;
        this.elec_fee = elec_fee;
    }

    /*
    public String getUID(){
        return UID;
    }

    public void setUID(String UID){
        this.UID = UID;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getAircon_name(){
        return aircon_name;
    }

    public void setAircon_name(String aircon_name){
        this.aircon_name = aircon_name;
    }

    public double getAircon_power(){
        return aircon_power;
    }

    public void setAircon_power(double aircon_power){
        this.aircon_power = aircon_power;
    }

    public double getIndoor_temp(){
        return indoor_temp;
    }

    public void setIndoor_temp(double indoor_temp){
        this.indoor_temp = indoor_temp;
    }

    public double getIndoor_hum(){
        return indoor_hum;
    }

    public void setIndoor_hum(double indoor_hum){
        this.indoor_hum = indoor_hum;
    }

    public double getOutdoor_temp() {
        return outdoor_temp;
    }

    public void setOutdoor_temp(double outdoor_temp) {
        this.outdoor_temp = outdoor_temp;
    }

    public double getOutdoor_hum() {
        return outdoor_hum;
    }

    public void setOutdoor_hum(double outdoor_hum) {
        this.outdoor_hum = outdoor_hum;
    }

    public double getUsing_time() {
        return using_time;
    }

    public void setUsing_time(double using_time) {
        this.using_time = using_time;
    }

    public double getElec_fee() {
        return elec_fee;
    }

    public void setElec_fee(double elec_fee) {
        this.elec_fee = elec_fee;
    }
    */
}
