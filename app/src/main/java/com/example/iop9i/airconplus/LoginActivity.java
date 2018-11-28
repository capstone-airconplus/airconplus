package com.example.iop9i.airconplus;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "EmailPassword";
    private LinearLayout linearLayout;

    private FirebaseAuth mAuth;
    private FirebaseDatabase mDB;
    private DatabaseReference myRef;

    private EditText emailText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDB = FirebaseDatabase.getInstance();

        mAuth = FirebaseAuth.getInstance();
        mAuth.getUid();

        linearLayout = (LinearLayout)findViewById(R.id.mainactivity_linearlayout);

        emailText = (EditText)findViewById(R.id.emailText);
        passwordText = (EditText)findViewById(R.id.passwordText);
        TextView registerButton = (TextView) findViewById(R.id.registerButton);

        // 회원가입버튼
        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);
            }


        });

        TextView loginButton = (TextView) findViewById(R.id.loginButton);

        // 로그인 버튼
        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String userPassword = passwordText.getText ().toString ();
                String userEmail = emailText.getText ().toString ();

                System.out.println(userEmail);
                System.out.println(userPassword);
                // 로그인 성공인지 아닌지를 알기위해서는signIn이 boolean이 되어야한다.
                signIn(userEmail, userPassword);

            }


        });
    }

    // signIn을 boolean으로 변경해봄 test
    private void signIn(final String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return ;
        }

//        showProgressDialog();

        System.out.println("여기까지 ok?");

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            //System.out.println("intent에서 error?");

                            // DB에 업로드하는 이벤트를 발생
                            dbUpload();

                            Intent mainactivityIntent = new Intent(LoginActivity.this, MainActivity.class);
                            LoginActivity.this.startActivity(mainactivityIntent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }


                    }
                });
        // [END sign_in_with_email]
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = emailText.getText().toString();
        if (TextUtils.isEmpty(email)) {
            emailText.setError("Required.");
            valid = false;
        } else {
            emailText.setError(null);
        }

        String password = passwordText.getText().toString();
        if (TextUtils.isEmpty(password)) {
            passwordText.setError("Required.");
            valid = false;
        } else {
            passwordText.setError(null);
        }

        return valid;
    }

    // 로그인 성공시 DB에 정보를 업로드하는 함수
    public void dbUpload(){

        LoginDTO loginDTO = new LoginDTO();

        loginDTO.UID = mAuth.getCurrentUser().getUid();
        loginDTO.email = mAuth.getCurrentUser().getEmail();

        myRef = mDB.getReference(loginDTO.UID);
        myRef.setValue(loginDTO);

    }
}
