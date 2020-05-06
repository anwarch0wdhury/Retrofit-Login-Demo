package com.anwar.retrofitloginexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiInterface {

    /**
     * Anwar Chowdhury
     * Date:5/2/2020
     */
    @POST("myfoodserver/readusers.php")
    Call<List<Users>> getContacts();

    @FormUrlEncoded
    @POST("myfoodserver/addusers.php")
    public Call<Users> insertUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("mobile") String mobile,
            @Field("address") String address,
            @Field("maplink") String maplink,
            @Field("city") String city,
            @Field("country") String country,
            @Field("zip") String zip,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("myfoodserver/addadminusers.php")
    public Call<Users> insertadminUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("mobile") String mobile,
            @Field("address") String address,
            @Field("maplink") String maplink,
            @Field("city") String city,
            @Field("country") String country,
            @Field("zip") String zip,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("myfoodserver/editusers.php")
    public Call<Users> editUser(
            @Field("id") String id,
            @Field("name") String name,
            @Field("mobile") String mobile,
            @Field("address") String address,
            @Field("maplink") String maplink,
            @Field("city") String city,
            @Field("country") String country,
            @Field("zip") String zip,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("myfoodserver/deleteusers.php")
    public Call<Users> editUser(
            @Field("id") String id);


    @GET("myfoodserver/userslogin.php")
    Call<Users> doLogin(@Query("email") String email, @Query("password") String password);

    @FormUrlEncoded
    @POST("myfoodserver/forgetpass.php")
    public Call<Users> forgetpassUser(

            @Field("email") String name,
            @Field("request") String request);


}
