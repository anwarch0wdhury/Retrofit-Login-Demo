package com.anwar.retrofitloginexample;
/**
 * Anwar Chowdhury
 * Date:5/2/2020
 */

import android.app.Activity;
import android.content.Context;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {
    private EditText edt_name,edt_email, edt_mobile, edt_address, edt_maplink, edt_city, edt_country, edt_zip, edt_password;
    private Button btn_update;
    private ApiInterface apiInterface;
    LoginInterface logoutListener;

    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_update, container, false);

        edt_name = view.findViewById (R.id.edt_Name);
        edt_mobile = view.findViewById (R.id.edt_Mobile);
        edt_email = view.findViewById(R.id.edt_Email);
        edt_address = view.findViewById (R.id.edt_Address);
        edt_maplink = view.findViewById (R.id.edt_Maplink);
        edt_city = view.findViewById (R.id.edt_City);
        edt_country = view.findViewById (R.id.edt_Country);
        edt_zip = view.findViewById (R.id.edt_Zip);
        edt_password = view.findViewById (R.id.edt_Password);
        btn_update = view.findViewById (R.id.btn_Update);



        String sName = LoginActivity.appPreference.getName();
        edt_name.setText(sName);
        String sEmail= LoginActivity.appPreference.getEmail();
        edt_email.setText(sEmail);
        String sMobile= LoginActivity.appPreference.getMobile ();
        edt_mobile.setText(sMobile);
        String sAddress= LoginActivity.appPreference.getAddress ();
        edt_address.setText(sAddress);
        String sMaplink= LoginActivity.appPreference.getMaplink ();
        edt_maplink.setText(sMaplink);
        String sCity= LoginActivity.appPreference.getCity ();
        edt_city.setText(sCity);
        String sCountry= LoginActivity.appPreference.getCountry ();
        edt_country.setText(sCountry);
        String sZip= LoginActivity.appPreference.getZip ();
        edt_zip.setText(sZip);

        btn_update.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                editUser ();
            }
        });


        return view;
    } // ending onCreateView


    private void editUser() {

        String sid = LoginActivity.appPreference.getId ();
        String sname = LoginActivity.appPreference.getName ();
        String smobile = LoginActivity.appPreference.getMobile ();
        String saddress = LoginActivity.appPreference.getAddress ();
        String smaplink = LoginActivity.appPreference.getMaplink ();
        String scity = LoginActivity.appPreference.getCity ();
        String scountry = LoginActivity.appPreference.getCountry ();
        String szip =LoginActivity.appPreference.getZip ();
        String spassword = edt_password.getText ().toString ();

        apiInterface = ApiClient.getApiClient ().create (ApiInterface.class);

        Call<Users> call = apiInterface.editUser (sid, sname, smobile, saddress, smaplink, scity, scountry, szip, spassword);
        call.enqueue (new Callback<Users> () {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                String value = response.body ().getValue ();
                String message = response.body ().getMassage ();
                if (value.equals ("1")) {
                    Toast.makeText (getContext (), message, Toast.LENGTH_SHORT).show ();
                    Log.e (String.valueOf (this), value + " inserted");

                } else {
                    Toast.makeText (getContext (), message, Toast.LENGTH_SHORT).show ();
                    Log.e (String.valueOf (this), value + " Not inserted");
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText (getContext (), "Network Error! " + t.toString (), Toast.LENGTH_SHORT).show ();
            }
        });
    }





    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        logoutListener = (LoginInterface) activity;

    }
}
