package com.example.user.myprojectpractice;

public class RestaurantReviewList {

    int id_rev;
    String RestaurantNameList;
    String ReviewerList;
    String ReviewList;
    String RatingPonitList;

    public RestaurantReviewList(int id_rev, String restaurantNameList, String reviewerList, String reviewList, String ratingPonitList) {
        this.id_rev = id_rev;
        RestaurantNameList = restaurantNameList;
        ReviewerList = reviewerList;
        ReviewList = reviewList;
        RatingPonitList = ratingPonitList;
    }

    public int getId_rev() {
        return id_rev;
    }

    public void setId_rev(int id_rev) {
        this.id_rev = id_rev;
    }

    public String getRestaurantNameList() {
        return RestaurantNameList;
    }

    public void setRestaurantNameList(String restaurantNameList) {
        RestaurantNameList = restaurantNameList;
    }

    public String getReviewerList() {
        return ReviewerList;
    }

    public void setReviewerList(String reviewerList) {
        ReviewerList = reviewerList;
    }

    public String getReviewList() {
        return ReviewList;
    }

    public void setReviewList(String reviewList) {
        ReviewList = reviewList;
    }

    public String getRatingPonitList() {
        return RatingPonitList;
    }

    public void setRatingPonitList(String ratingPonitList) {
        RatingPonitList = ratingPonitList;
    }
}
