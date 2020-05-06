package com.anwar.retrofitloginexample;
/**
 * Anwar Chowdhury
 * Date:5/2/2020
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupFragment extends Fragment {

    private ApiInterface apiInterface;

    private EditText edt_name, edt_email,edt_mobile,edt_address,edt_maplink,edt_city,edt_country,edt_zip,edt_password;
    private Button btn_register;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_signup, container, false);

        edt_name =view.findViewById(R.id.edt_Name);
        edt_email =view.findViewById(R.id.edt_Email);
        edt_mobile =view.findViewById(R.id.edt_Mobile);
        edt_address =view.findViewById(R.id.edt_Address);
        edt_maplink =view.findViewById(R.id.edt_Maplink);
        edt_city =view.findViewById(R.id.edt_City);
        edt_country =view.findViewById(R.id.edt_Country);
        edt_zip =view.findViewById(R.id.edt_Zip);
        edt_password =view.findViewById(R.id.edt_Password);

        btn_register = view.findViewById(R.id.btn_Register);


            insert ();

        return view;

    }

    private void insertUser() {

        String sname = edt_name.getText ().toString ();
        String semail = edt_email.getText ().toString ();
        String smobile = edt_mobile.getText ().toString ();
        String saddress = edt_address.getText ().toString ();
        String smaplink = edt_maplink.getText ().toString ();
        String scity = edt_city.getText ().toString ();
        String scountry = edt_country.getText ().toString ();
        String szip = edt_zip.getText ().toString ();
        String spassword = edt_password.getText ().toString ();


        apiInterface = ApiClient.getApiClient ().create (ApiInterface.class);

        Call<Users> call = apiInterface.insertUser (sname, semail, smobile, saddress, smaplink, scity, scountry, szip, spassword);

        Log.e (String.valueOf (this), sname + " " + smobile + " " + semail + " " + scountry + " " + szip);

        call.enqueue (new Callback<Users> () {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                String value = response.body ().getValue ();
                String message = response.body ().getMassage ();
                if (value.equals ("1")) {
                    Toast.makeText (getContext (),
                            "Registered", Toast.LENGTH_SHORT).show ();
                    Log.e (String.valueOf (this), value + " inserted");

                } else {
                    Toast.makeText (getContext (), "Your Email is already in use.", Toast.LENGTH_SHORT).show ();
                    Log.e (String.valueOf (this), value + " not inserted");
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText (getContext (), "Network Error! :\n" + t.toString (), Toast.LENGTH_SHORT).show ();
            }
        });
    }

    private void insert(){


        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    insertUser ();

            }
        });



    }

}
