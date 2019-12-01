package com.example.user.myprojectpractice;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class RestaurantListAdapter extends BaseAdapter {

    private Context mContext;
    private List <RestaurantList> mRestaurantList;

    public RestaurantListAdapter(Context mContext, List<RestaurantList> mRestaurantList) {
        this.mContext = mContext;
        this.mRestaurantList = mRestaurantList;
    }

    @Override
    public int getCount() {
        return mRestaurantList.size();
    }

    @Override
    public Object getItem(int position) {
        return mRestaurantList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext, R.layout.restaurant_list, null);

        TextView ResNameTxt = (TextView)v.findViewById(R.id.resNameTxt);
        TextView AddressTxt = (TextView)v.findViewById(R.id.AddressTxt);
        TextView PhnTxt = (TextView)v.findViewById(R.id.PhnTxt);
        TextView RatingTxt = (TextView)v.findViewById(R.id.RatingTxt);
       // RatingBar trbar = (RatingBar)v.findViewById(R.id.rateBarList);


        //float rate = Float.valueOf(mRestaurantList.get(position).getRatingList());

        ResNameTxt.setText(mRestaurantList.get(position).getResNameList());
        AddressTxt.setText(mRestaurantList.get(position).getAddressList());
        PhnTxt.setText(String.valueOf(mRestaurantList.get(position).getPhnNoList()));
        RatingTxt.setText(String.valueOf(mRestaurantList.get(position).getRatingList()));
        //trbar.setRating(rate);
        v.setTag(mRestaurantList.get(position).getId());

        return v;
    }
}
