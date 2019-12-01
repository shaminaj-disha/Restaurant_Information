package com.example.user.myprojectpractice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class RestaurantReview extends AppCompatActivity {

    private ListView IvReviewList;
    private RestaurantReviewListAdapter adapter_review;
    private List<RestaurantReviewList> nReviewList;
    private DataBaseCreate db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_review);

        Intent i = getIntent();
        Bundle data = i.getBundleExtra("RES_DATA");
        String rName = data.getString("RES_NAME");

        TextView rsname = (TextView)findViewById(R.id.ResReviewNameTxt);
        rsname.setText(rName);
        IvReviewList = (ListView)findViewById(R.id.listRestReview);
        db = new DataBaseCreate(this);

        nReviewList = db.getReviewResturatnt(rName);

        adapter_review = new RestaurantReviewListAdapter(this,nReviewList);

        IvReviewList.setAdapter(adapter_review);


    }

}
