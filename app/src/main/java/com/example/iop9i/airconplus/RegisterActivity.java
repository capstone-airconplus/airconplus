package com.example.iop9i.airconplus;

import android.app.admin.SystemUpdateInfo;
import android.app.admin.SystemUpdatePolicy;
import android.content.Intent;
import android.content.SyncStatusObserver;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.textservice.SentenceSuggestionsInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.net.ResponseCache;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "EmailPassword";

    private String userID;
    private String userpassword;
    private String userEmail;
    private AlertDialog dialog;
    private boolean validate = false;

    /* 2018.11.08 강명구
    이전에는 이 필드에서 EditText를 선언하고 assign을 해서 사용했으나
    다른 필드에서도 사용하고 싶어서 class에서 선언하고 여기서 assign을 해서 사용
    */
    // onCreate 뿐만 아니라 다른 곳에서도 사용하고 싶어서 밖에서 선언
    private EditText idText;
    private EditText passwordText;
    private EditText emailText;

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // firebaseAuth 객체의 공유 인스턴스를 가져온다.
        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

        // firebase의 데이터베이스 읽고 쓰기 위해서는 DatabaseReference 인스턴스가 필요하다.
        // FirebaseDatabase database = FirebaseDatabase.getInstance().getReference("message");
        // DatabaseReference myRef = database.child("text"); 여기에서 .child()는 데이터 위치의 이름을 정해줌
        // 이렇게도 사용이 가능하다.
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.child("username").push().setValue("Hello, World!");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /* 2018.11.08 강명구
        이전에는 이 필드에서 EditText를 선언하고 assign을 해서 사용했으나
        다른 필드에서도 사용하고 싶어서 class에서 선언하고 여기서 assign을 해서 사용
         */
        idText = (EditText) findViewById(R.id.idText);
        passwordText = (EditText) findViewById(R.id.passwordText);
        emailText = (EditText) findViewById(R.id.emailText);

        /*
        // validateButton  중복체크버튼
        final Button validateButton = (Button) findViewById(R.id.validateButton);
        validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            protected void finalize() throws Throwable {
                super.finalize();
            }

            @Override
            public void onClick(View view) {
                String userID = idText.getText().toString();
                if(validate)
                {
                    return;
                }
                if(userID.equals(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                    dialog = builder.setMessage("아이디는 빈 칸일 수 없습니다.").setPositiveButton("확인", null).create();
                    dialog.show();
                    return;
                }
                //Response.Listener<String> responseListener = new Response.Listener<String> () {

                //}정상적이로 아이디값이 입력하면 중복검사 해주는 칸
            }
        });
        */

        // registerButton 가입하기 버튼
        Button registerButton = (Button) findViewById (R.id.registerButton);
        registerButton.setOnClickListener (new View.OnClickListener (){

            @Override
            public void onClick(View view) {
                String userID = idText.getText ().toString ();
                String userPassword = passwordText.getText ().toString ();
                String userEmail = emailText.getText ().toString ();

                // test용 회원가입 정상으로 되는지 확인하기 위해서 만들어봤습니다.
                // test가 끝나면 중복체크를 구현하여 정상작동이 되도록 수정해야합니다.
                System.out.println("ok");

                createAccount(userEmail, userPassword);


               /*
                if(!validate)
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder (RegisterActivity.this);
                    dialog = builder.setMessage("먼저 중복 체크를 해주세요.").setNegativeButton ("확인", null).create();
                    dialog.show();
                    return;
                }else if(userID.equals ("") || userPassword.equals ("") || userEmail.equals (""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder (RegisterActivity.this);
                    dialog = builder.setMessage("빈 칸 없이 입력해주세요.").setNegativeButton ("확인", null).create();
                    dialog.show();
                    return;
                }else{
                    createAccount(emailText.getText().toString(), passwordText.getText().toString());
                }
                */




            }
        });
    }

    // [START on_start_check_user]
    public void onStart(){
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        // 따로 updateUI 함수를 만들어 줘야하는데 google에는 나와있지만 나와 양식이 달라 생략한다.
        //updateUI(currentUser);

    }
    // [END on_start_check_user]

    private void createAccount(final String email, final String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validateForm()) {
            return;
        }

//        showProgressDialog();

        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            System.out.println("createOK");
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(RegisterActivity.this, "Authentication Success, complete creation.",
                                    Toast.LENGTH_SHORT).show();

                            // 다음 화면으로 전환
                            Intent secondregisterIntent = new Intent(RegisterActivity.this, SecondRegisterActivity.class);
                            RegisterActivity.this.startActivity(secondregisterIntent);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // [START_EXCLUDE]
//                        hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
        // [END create_user_with_email]
    }


    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);
        if (!validateForm()) {
            return;
        }

//        showProgressDialog();

        // [START sign_in_with_email]
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        /*
                        현재 이부분 이해가 안감 mstatusTextView가 무엇인지 확인해볼 필요있음
                        나중에 해보자 명구
                        // [START_EXCLUDE]
                        if (!task.isSuccessful()) {
                            mStatusTextView.setText(R.string.auth_failed);
                        }
//                        hideProgressDialog();
                        // [END_EXCLUDE]
                        */
                    }
                });
        // [END sign_in_with_email]
    }
    /* 이부분은 현재 email을 중복체크하는 부분인데
    validateButton를 이용하여 아이디 중복체크버튼으로 개발중 나중에 변경해야합니다
     */
    private void sendEmailVerification() {
        // Disable button
        findViewById(R.id.validateButton).setEnabled(false);

        // Send verification email
        // [START send_email_verification]
        final FirebaseUser user = mAuth.getCurrentUser();
        user.sendEmailVerification()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        // [START_EXCLUDE]
                        // Re-enable button
                        findViewById(R.id.validateButton).setEnabled(true);

                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this,
                                    "Verification email sent to " + user.getEmail(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e(TAG, "sendEmailVerification", task.getException());
                            Toast.makeText(RegisterActivity.this,
                                    "Failed to send verification email.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // [END_EXCLUDE]
                    }
                });
        // [END send_email_verification]
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

    /*
    일단 생략해 시부럴거 mStatusTextView,mDetailTextView,emailpassword_status_fmt,firebase_status_fmt,hideProgressDialog
    준내 먼말인지 모르겠다
    */
    /*
    private void updateUI(FirebaseUser user) {
        hideProgressDialog();
        if (user != null) {
            mStatusTextView.setText(getString(R.string.emailpassword_status_fmt,
                    user.getEmail(), user.isEmailVerified()));
            mDetailTextView.setText(getString(R.string.firebase_status_fmt, user.getUid()));

            findViewById(R.id.emailPasswordButtons).setVisibility(View.GONE);
            findViewById(R.id.emailPasswordFields).setVisibility(View.GONE);
            findViewById(R.id.signedInButtons).setVisibility(View.VISIBLE);

            findViewById(R.id.verifyEmailButton).setEnabled(!user.isEmailVerified());
        } else {
            mStatusTextView.setText(R.string.signed_out);
            mDetailTextView.setText(null);

            findViewById(R.id.emailPasswordButtons).setVisibility(View.VISIBLE);
            findViewById(R.id.emailPasswordFields).setVisibility(View.VISIBLE);
            findViewById(R.id.signedInButtons).setVisibility(View.GONE);
        }
    }
    */



    @Override
    // implement view.onclicklistener 추가했음
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.registerButton) {
            createAccount(emailText.getText().toString(), passwordText.getText().toString());
        }
//        } else if (i == R.id.emailSignInButton) {
//            signIn(mEmailField.getText().toString(), mPasswordField.getText().toString());
//        }
//        } else if (i == R.id.signOutButton) {
//            signOut();
//        } else if (i == R.id.verifyEmailButton) {
//            sendEmailVerification();
//        }
    }


}
