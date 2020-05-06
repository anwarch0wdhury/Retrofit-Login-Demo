package com.anwar.retrofitloginexample;
/**
 * Anwar Chowdhury
 * Date:5/2/2020
 */
public interface LoginInterface {


    void login(String name, String id, String email, String mobile,String address,String maplink, String city,String country,String zip, String created_at, String token, String type);
    void logout();
}
