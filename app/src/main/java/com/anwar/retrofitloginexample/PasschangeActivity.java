package com.anwar.retrofitloginexample;
/**
 * Anwar Chowdhury
 * Date:5/2/2020
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PasschangeActivity extends AppCompatActivity {

    private ApiInterface apiInterface;

    private EditText edt_name, edt_mobile, edt_address, edt_maplink, edt_city, edt_country, edt_zip, edt_password;
    private Button btn_Save, btn_Delete;

    String extr_id;
    String extr_name;
    String extr_mobile;
    String extr_address;
    String extr_maplink;
    String extr_city;
    String extr_country;
    String extr_zip;
    String extr_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_passchange);

        Intent i = getIntent ();
        extr_id = i.getStringExtra ("id");
        extr_name = i.getStringExtra ("name");
        extr_mobile = i.getStringExtra ("mobile");
        extr_address = i.getStringExtra ("address");
        extr_maplink = i.getStringExtra ("maplink");
        extr_city = i.getStringExtra ("city");
        extr_country = i.getStringExtra ("country");
        extr_zip = i.getStringExtra ("zip");
        extr_password = i.getStringExtra ("password");


        edt_name = findViewById (R.id.edt_Name);
        edt_mobile = findViewById (R.id.edt_Mobile);
        edt_address = findViewById (R.id.edt_Address);
        edt_maplink = findViewById (R.id.edt_Maplink);
        edt_city = findViewById (R.id.edt_City);
        edt_country = findViewById (R.id.edt_Country);
        edt_zip = findViewById (R.id.edt_Zip);
        edt_password = findViewById (R.id.edt_Password);
        btn_Save = findViewById (R.id.btn_Save);
        btn_Delete = findViewById (R.id.btn_Delete);


        condition ();

    }


    private void editUser() {

        String sid = extr_id;
        String sname = edt_name.getText ().toString ();
        String smobile = edt_mobile.getText ().toString ();
        String saddress = edt_address.getText ().toString ();
        String smaplink = edt_maplink.getText ().toString ();
        String scity = edt_city.getText ().toString ();
        String scountry = edt_country.getText ().toString ();
        String szip = edt_zip.getText ().toString ();
        String spassword = edt_password.getText ().toString ();

        apiInterface = ApiClient.getApiClient ().create (ApiInterface.class);

        Call<Users> call = apiInterface.editUser (sid, sname, smobile, saddress, smaplink, scity, scountry, szip, spassword);
        call.enqueue (new Callback<Users> () {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                String value = response.body ().getValue ();
                String message = response.body ().getMassage ();
                if (value.equals ("1")) {
                    Toast.makeText (PasschangeActivity.this, message, Toast.LENGTH_SHORT).show ();
                    Log.e (String.valueOf (this), value + " inserted");
                    finish ();
                } else {
                    Toast.makeText (PasschangeActivity.this, message, Toast.LENGTH_SHORT).show ();
                    Log.e (String.valueOf (this), value + " Not inserted");
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText (PasschangeActivity.this, "Network Error! " + t.toString (), Toast.LENGTH_SHORT).show ();
            }
        });
    }

    private void deleteuser() {
        String sid = extr_id;

        apiInterface = ApiClient.getApiClient ().create (ApiInterface.class);

        Call<Users> call = apiInterface.editUser (sid);
        call.enqueue (new Callback<Users> () {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                String value = response.body ().getValue ();
                String message = response.body ().getMassage ();
                if (value.equals ("1")) {
                    Toast.makeText (PasschangeActivity.this, message, Toast.LENGTH_SHORT).show ();
                    finish ();
                } else {
                    Toast.makeText (PasschangeActivity.this, message, Toast.LENGTH_SHORT).show ();
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText (PasschangeActivity.this, "Network Error! " + t.toString (), Toast.LENGTH_SHORT).show ();
            }
        });

    }

    private void condition() {

        edt_name.setText (extr_name);
        edt_mobile.setText (extr_mobile);
        edt_address.setText (extr_address);
        edt_maplink.setText (extr_maplink);
        edt_city.setText (extr_city);
        edt_country.setText (extr_country);
        edt_zip.setText (extr_zip);
        edt_password.setText (extr_password);

        btn_Save.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                editUser ();
            }
        });
        btn_Delete.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                deleteuser ();
            }
        });

    }
}
