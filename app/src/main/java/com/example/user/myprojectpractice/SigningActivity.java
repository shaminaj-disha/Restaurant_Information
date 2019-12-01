package com.example.user.myprojectpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigningActivity extends AppCompatActivity {

    private Button signBtn;
    private DataBaseCreate db;
    EditText signName,signMobile,signEmail,signPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signing);

        db = new DataBaseCreate(this);
        signBtn = (Button) findViewById(R.id.signUpBtn);
        signEmail = (EditText) findViewById(R.id.signEmailET);
        signPass = (EditText)findViewById(R.id.signPassET);
        signName= (EditText)findViewById(R.id.signNameET);
        signMobile = (EditText)findViewById(R.id.signMobET);


        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    private void signup(){

        String email = signEmail.getText().toString();
        String pass = signPass.getText().toString();
        String name = signName.getText().toString();
        String mobile = signMobile.getText().toString();


        if(email.isEmpty() || pass.isEmpty() || name.isEmpty() || mobile.isEmpty() ){
            displayToast("Fill all field.");
        }else{
            db.addUser(name,email,mobile,pass);
            displayToast("Sign Up successful!!!");
            finish();
        }
    }

    private void displayToast(String message){
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }
}
