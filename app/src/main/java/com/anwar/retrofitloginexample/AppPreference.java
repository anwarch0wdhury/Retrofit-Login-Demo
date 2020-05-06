package com.anwar.retrofitloginexample;
/**
 * Anwar Chowdhury
 * Date:5/2/2020
 */
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

// Shared Preference METHODS

public class AppPreference {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public AppPreference(Context context){
        this.context = context;


        sharedPreferences = context.getSharedPreferences(String.valueOf(R.string.s_pref_file), Context.MODE_PRIVATE);

        editor = sharedPreferences.edit();
    }

    //Setting login status
    public void setLoginStatus(boolean status){
        editor.putBoolean(String.valueOf(R.string.s_pref_login_status), status);
        editor.commit();
    }
    public boolean getLoginStatus(){
        return sharedPreferences.getBoolean(String.valueOf(R.string.s_pref_login_status), false);
    }


    //For id
    public void setId(String id){
        editor.putString(String.valueOf(R.string.s_pref_id), id);
        editor.commit();
    }
    public String getId(){
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_id), "id");
    }

    // For Name
    public void setName(String name){
        editor.putString(String.valueOf(R.string.s_pref_name), name);
        editor.commit();
    }
    public String getName(){
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_name), "Name");
    }

    //For email
    public void setEmail(String email){
        editor.putString(String.valueOf(R.string.s_pref_email), email);
        editor.commit();
    }
    public String getEmail(){
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_email), "email");
    }



    //For mobile
    public void setMobile(String mobile){
        editor.putString(String.valueOf(R.string.s_pref_mobile), mobile);
        editor.commit();
    }
    public String getMobile(){
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_mobile), "mobile");
    }
    //For address
    public void setAddress(String address){
        editor.putString(String.valueOf(R.string.s_pref_address), address);
        editor.commit();
    }
    public String getAddress(){
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_address), "address");
    }

    //For maplink
    public void setMaplink(String maplink){
        editor.putString(String.valueOf(R.string.s_pref_maplink), maplink);
        editor.commit();
    }
    public String getMaplink(){
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_maplink), "maplink");
    }

    //For city
    public void setCity(String city){
        editor.putString(String.valueOf(R.string.s_pref_city), city);
        editor.commit();
    }
    public String getCity(){
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_city), "city");
    }

    //For city
    public void setCountry(String country){
        editor.putString(String.valueOf(R.string.s_pref_country), country);
        editor.commit();
    }
    public String getCountry(){
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_country), "country");
    }

    //For city
    public void setZip(String zip){
        editor.putString(String.valueOf(R.string.s_pref_zip), zip);
        editor.commit();
    }
    public String getZip(){
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_zip), "zip");
    }



    //For Created date
    public void setCreDate(String date){
        editor.putString(String.valueOf(R.string.s_pref_date), date);
        editor.commit();
    }
    public String getCreDate(){
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_date), "date");
    }
    //For token
    public void setToken(String token){
        editor.putString(String.valueOf(R.string.s_pref_token), token);
        editor.commit();
    }
    public String getToken(){
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_token), "token");
    }

    //For type
    public void setType(String type){
        editor.putString(String.valueOf(R.string.s_pref_type), type);
        editor.commit();
    }
    public String getType(){
        return sharedPreferences.getString(String.valueOf(R.string.s_pref_type), "type");
    }

    // For TOAST Message for response
    public void showToast(String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}