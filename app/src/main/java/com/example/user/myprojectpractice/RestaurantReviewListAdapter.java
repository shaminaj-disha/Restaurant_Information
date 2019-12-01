package com.example.user.myprojectpractice;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class RestaurantReviewListAdapter extends BaseAdapter {

    private Context nContext;
    private List<RestaurantReviewList> nReviewList;

    public RestaurantReviewListAdapter(Context nContext, List<RestaurantReviewList> nReviewList) {
        this.nContext = nContext;
        this.nReviewList = nReviewList;
    }

    @Override
    public int getCount() {
        return nReviewList.size();
    }

    @Override
    public Object getItem(int position) {
        return nReviewList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(nContext, R.layout.restaurant_review_list, null);


        TextView ReviewerNameTxt = (TextView)view.findViewById(R.id.ReseviewerNameTxt);
        TextView ReviewsTxt = (TextView)view.findViewById(R.id.ResReviewTxt);
        TextView RatingViewTxt = (TextView)view.findViewById(R.id.ratingResReviewTxt);

        ReviewerNameTxt.setText(nReviewList.get(position).getReviewerList());
        ReviewsTxt.setText(nReviewList.get(position).getReviewList());
        RatingViewTxt.setText(nReviewList.get(position).getRatingPonitList());
        view.setTag(nReviewList.get(position).getId_rev());

        return view;
    }
}
