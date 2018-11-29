package com.example.iop9i.airconplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SecondRegisterActivity extends AppCompatActivity {

    private TextView emailText;
    private EditText ariconText;
    private EditText powerText;
    private String email;
    private float string_power;

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    FirebaseDatabase mDB = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_register);

        email = mAuth.getCurrentUser().getEmail();

        // 여기 editText를 방금 회원가입되면서 받아온 정보의 email을 넣어주고 싶은데,
        // 어떻게 하는거지 textview로 바꿔야 사용자가 email을 안바꾸고 그대로 사용이 되고 그걸 받아와서 DB업로드가 가능한데;;;
        emailText = (TextView) findViewById(R.id.emailText);
        emailText.setText(email.toString());
        ariconText = (EditText)findViewById(R.id.airconText);
        powerText = (EditText)findViewById(R.id.powerText);
        //final double power = Double.parseDouble(powerText.getText().toString());


        Button registerButton = (Button)findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("secondRegister OK");
                // 여기서 aircon 이름을 DB에 저장을 하던 이메일에 저장을 하던 해야합니다.
                // 그 부분에 대해서는 더 공부를 해야합니다.

                // 로그인 이전에 DB에 userUID를 만들어 그 하위에 에어컨 정보와 email 새로 만든다.
                // 표준전력량 textview의 내용을 double로 변경하고 그값을 string_power로 받아서 db업로드의 파라메터로 사용한다.
                string_power = Float.parseFloat(powerText.getText().toString());
                System.out.println("@@@@@@@@@@@@@"+string_power);
                dbUpload(ariconText.getText().toString(), string_power);


                // 이부분은 로그인 처리를 합시다.
                Intent loginIntent = new Intent(SecondRegisterActivity.this, LoginActivity.class);
                SecondRegisterActivity.this.startActivity(loginIntent);
            }
        });
    }


    public void dbUpload(String aircon_name, float aircon_power){
        LoginDTO loginDTO = new LoginDTO();

        loginDTO.UID = mAuth.getCurrentUser().getUid();
        loginDTO.email = mAuth.getCurrentUser().getEmail();
        loginDTO.aircon_name = aircon_name;
        loginDTO.aircon_power = aircon_power;
        loginDTO.indoor_hum = 0;
        loginDTO.indoor_temp = 0;
        loginDTO.outdoor_temp = 0;
        loginDTO.outdoor_hum = 0;
        loginDTO.using_time = 0;
        loginDTO.elec_fee = 0;

        // 연동된 firebase의 DB에 UID를 이름으로하며 그 하위에 값들을 저장함.
        mDB.getReference().child(loginDTO.UID).setValue(loginDTO);


    }
}
