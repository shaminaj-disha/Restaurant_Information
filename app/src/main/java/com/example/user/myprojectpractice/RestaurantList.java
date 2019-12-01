package com.example.user.myprojectpractice;

public class RestaurantList {
    int id;
    String ResNameList;
    String AddressList;
    String phnNoList;
    String ratingList;
    String locationList;

    public RestaurantList(int id, String resNameList, String addressList, String phnNoList, String ratingList, String locationList) {
        this.id = id;
        ResNameList = resNameList;
        AddressList = addressList;
        this.phnNoList = phnNoList;
        this.ratingList = ratingList;
        this.locationList = locationList;
    }

    public String getLocationList() {
        return locationList;
    }

    public void setLocationList(String locationList) {
        this.locationList = locationList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResNameList() {
        return ResNameList;
    }

    public void setResNameList(String resNameList) {
        ResNameList = resNameList;
    }

    public String getAddressList() {
        return AddressList;
    }

    public void setAddressList(String addressList) {
        AddressList = addressList;
    }

    public String getPhnNoList() {
        return phnNoList;
    }

    public void setPhnNoList(String phnNoList) {
        this.phnNoList = phnNoList;
    }

    public String getRatingList() {
        return ratingList;
    }

    public void setRatingList(String ratingList) {
        this.ratingList = ratingList;
    }
}
