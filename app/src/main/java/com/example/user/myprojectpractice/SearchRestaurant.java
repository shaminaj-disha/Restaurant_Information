package com.example.user.myprojectpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchRestaurant extends AppCompatActivity {

    EditText rName;
    Button search;
    DataBaseCreate db = new DataBaseCreate(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_restaurant);

        rName = (EditText)findViewById(R.id.searchET);
        search = (Button)findViewById(R.id.searchBtn);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = rName.getText().toString();
                if(name.isEmpty())
                    Toast.makeText(getApplicationContext(),"Enter restaurant name!!!",Toast.LENGTH_SHORT).show();
                else {
                    if (db.getRes(name)) {
                        Intent i = new Intent(SearchRestaurant.this, ResDetails.class);
                        Bundle data = new Bundle();
                        data.putCharSequence("RES_NAME", name);
                        i.putExtra("RES_DATA", data);
                        startActivity(i);
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Not found!!!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}
