package com.example.user.myprojectpractice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

public class ResDetails extends AppCompatActivity {

    TextView res_name,res_add,phnNo,rate;
    DataBaseCreate db = new DataBaseCreate(this);
    ArrayList<String> restData = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_details);


        Intent i = getIntent();
        Bundle data = i.getBundleExtra("RES_DATA");
        String rName = data.getString("RES_NAME");

        res_name = (TextView)findViewById(R.id.resNamDetTxt);
        res_add = (TextView)findViewById(R.id.resAddDetTxt);
        phnNo = (TextView)findViewById(R.id.resPhnDetTxt);
        rate = (TextView)findViewById(R.id.resRatingDetTxt);



        restData = db.getResDetails(rName);
        res_name.setText(restData.get(0));
        res_add.setText(restData.get(1));
        phnNo.setText(restData.get(2));
        rate.setText(restData.get(3));

        final String resName = rName;
        TextView review = (TextView)findViewById(R.id.resRevNamDetTxt);

        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                Intent i = new Intent(ResDetails.this,RestaurantReview.class);
                data.putCharSequence("RES_NAME",resName);
                i.putExtra("RES_DATA",data);
                startActivity(i);
            }
        });

        TextView call = (TextView)findViewById(R.id.rCall);
        TextView map = (TextView)findViewById(R.id.rMap);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String num = restData.get(2);
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + num));

                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {

                }
                startActivity(callIntent);

            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String location = restData.get(4);
                Uri gmmIntentUri = Uri.parse(location);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

            }
        });

    }
}
