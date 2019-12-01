package com.example.user.myprojectpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button searchbtn,resbtn,helpbtn;
    TextView logtxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logtxt = (TextView) findViewById(R.id.loginPageTxt);
        searchbtn =(Button) findViewById(R.id.searchResBtn);
        resbtn =(Button) findViewById(R.id.restaurantsBtn);
        helpbtn =(Button) findViewById(R.id.helpBtn);

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SearchRestaurant.class));
            }
        });

        resbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RestaurantsActivity.class));
            }
        });

        helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,InstructionsActivity.class));
            }
        });

        logtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });

    }
}
