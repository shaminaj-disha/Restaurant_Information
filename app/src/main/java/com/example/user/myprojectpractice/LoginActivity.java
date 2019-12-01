package com.example.user.myprojectpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button login;
    private EditText emailET,passET;
    private DataBaseCreate db;
    TextView signupTxt;

    public static String CREDENTIAL = "Credential";
    public static String USEREMAIL = "userEmail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DataBaseCreate(this);
        emailET = (EditText)findViewById(R.id.emailET);
        passET = (EditText)findViewById(R.id.passET);
        login = (Button)findViewById(R.id.logBtn);
        signupTxt = (TextView)findViewById(R.id.signPageBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        signupTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SigningActivity.class));
            }
        });

    }
    private void login() {
        String email = emailET.getText().toString();
        String pass = passET.getText().toString();

        if (db.getUser(email, pass)) {



            Intent i = new Intent(getApplicationContext(),ReviewActivity.class);
            Bundle data = new Bundle();
            data.putCharSequence(USEREMAIL,email);
            i.putExtra(CREDENTIAL,data);
            startActivity(i);
            finish();

        } else {
            Toast.makeText(getApplicationContext(), "Wrong email/password", Toast.LENGTH_SHORT).show();
        }
    }


}
