package com.anwar.retrofitloginexample;

import com.google.gson.annotations.SerializedName;


public class Users {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("mobile")
    private String mobile;
    @SerializedName("address")
    private String address;
    @SerializedName("maplink")
    private String maplink;
    @SerializedName("city")
    private String city;
    @SerializedName("country")
    private String country;
    @SerializedName("zip")
    private String zip;
    @SerializedName("password")
    private String password;

    @SerializedName("created_at")
    private String created_at;

    @SerializedName("token")
    private String token;

    @SerializedName("type")
    private String type;

    @SerializedName("request")
    private String request;

    @SerializedName("response")
    private String response;
    @SerializedName("value")
    private String value;
    @SerializedName("massage")
    private String massage;

    public Users(String id, String name, String email, String mobile, String address, String maplink, String city, String country, String zip, String password, String request) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.maplink = maplink;
        this.city = city;
        this.country = country;
        this.zip = zip;
        this.password = password;
        this.request = request;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public String getMaplink() {
        return maplink;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getZip() {
        return zip;
    }

    public String getPassword() {
        return password;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getToken() {
        return token;
    }

    public String getRequest() {
        return request;
    }

    public String getType() {
        return type;
    }

    public String getResponse() {
        return response;
    }

    public String getValue() {
        return value;
    }

    public String getMassage() {
        return massage;
    }

    @Override
    public String toString() {
        return "Users{" +
                "response='" + response + '\'' +
                ",value='" + value + '\'' +
                ",massage='" + massage + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", city='" + city + '\'' +
                ", created_at='" + created_at + '\'' +
                ", token='" + token + '\'' +
                ", type='" + type + '\'' +
                ", request='" + request + '\'' +
                '}';
    }

}
