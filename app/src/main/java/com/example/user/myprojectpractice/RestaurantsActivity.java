package com.example.user.myprojectpractice;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;
import android.Manifest;
import android.provider.Telephony;
import android.widget.Toast;

import java.util.List;


public class RestaurantsActivity extends Activity {

    private ListView IvRestaurantList;
    private RestaurantListAdapter adapter;
    private List <RestaurantList> mRestaurantList;
    private DataBaseCreate db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        IvRestaurantList = (ListView)findViewById(R.id.alllist);
        db = new DataBaseCreate(this);

        mRestaurantList = db.getRestaurant();

        adapter = new RestaurantListAdapter(this,mRestaurantList);

        IvRestaurantList.setAdapter(adapter);

        registerForContextMenu(IvRestaurantList);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.alllist)
        {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu_item,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

       switch (item.getItemId())
        {
            case R.id.callRes:
                String num = mRestaurantList.get(info.position).getPhnNoList();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + num));

                if(ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
                    return true;
                }
                startActivity(callIntent);
                return true;

            case R.id.view:
                Bundle data = new Bundle();
                Intent i = new Intent(RestaurantsActivity.this,RestaurantReview.class);
                data.putCharSequence("RES_NAME",mRestaurantList.get(info.position).getResNameList());
                i.putExtra("RES_DATA",data);
                startActivity(i);
                return true;

            case R.id.mapShow:
                String location = mRestaurantList.get(info.position).getLocationList();
                Uri gmmIntentUri = Uri.parse(location);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
                return true;

            default:
                return super.onContextItemSelected(item);
        }


    }
}
