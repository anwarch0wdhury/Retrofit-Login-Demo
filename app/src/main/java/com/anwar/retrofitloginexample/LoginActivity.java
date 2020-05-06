package com.anwar.retrofitloginexample;
/**
 * Anwar Chowdhury
 * Date:5/2/2020
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;


public class LoginActivity extends AppCompatActivity implements LoginInterface {

    public static AppPreference appPreference;
    public static String c_date;

    FrameLayout container_layout;

    public static ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        container_layout = findViewById(R.id.fragment_container);
        appPreference = new AppPreference (this);

        //Log.e("created_at: ", c_date);

        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        if (container_layout != null){
            if (savedInstanceState != null){
                return;
            }

            //check login status from sharedPreference
            if (appPreference.getLoginStatus()){
                //when true
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container, new ProfileFragment())
                        .commit();
            } else {
                // when get false
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container, new LoginFragment ())
                        .commit();
            }
        }

    } // ending onCreate


    // overridden from LoginInterface



    @Override
    public void login(String name,String id, String email, String mobile,String address,String maplink, String city, String country ,String zip, String created_at,String token,String type) {
        appPreference.setName(name);
        appPreference.setId(id);
        appPreference.setEmail(email);
        appPreference.setMobile(mobile);
        appPreference.setAddress(address);
        appPreference.setMaplink(maplink);
        appPreference.setCity(city);
        appPreference.setCountry(country);
        appPreference.setZip(zip);
        appPreference.setCreDate(created_at);
        appPreference.setToken (token);
        appPreference.setType (type);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new ProfileFragment())
                .commit();
    }


    @Override
    public void logout() {
        appPreference.setLoginStatus(false);
        appPreference.setName("Name");
        appPreference.setEmail("Email");
        appPreference.setMobile("Mobile");
        appPreference.setAddress ("Address");
        appPreference.setMaplink ("Maplink");
        appPreference.setCity ("City");
        appPreference.setCountry ("Country");
        appPreference.setZip ("ZIP");
        appPreference.setCreDate("DATE");
        appPreference.setToken ("Token");
        appPreference.setType ("Type");



        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new LoginFragment ())
                .commit();
    }
}
