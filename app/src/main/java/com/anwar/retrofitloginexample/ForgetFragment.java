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

public class ForgetFragment extends Fragment {

    private ApiInterface apiInterface;

    private EditText edt_email;
    private Button btn_Request;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_forgetpass, container, false);


        edt_email =view.findViewById(R.id.edt_Emailr);


        btn_Request = view.findViewById(R.id.btn_request);


        forget ();

        return view;

    }


    private void forgetpassUser() {


        String sname = edt_email.getText ().toString ();
        String srequest = "Forgot my password";

        apiInterface = ApiClient.getApiClient ().create (ApiInterface.class);

        Call<Users> call = apiInterface.forgetpassUser ( sname, srequest);
        call.enqueue (new Callback<Users> () {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                String value = response.body ().getValue ();
                String message = response.body ().getMassage ();
                if (value.equals ("1")) {
                    Toast.makeText (getContext (), "A new password will be sent to your email address.", Toast.LENGTH_SHORT).show ();
                    Log.e (String.valueOf (this), value + " request sent");
                   // finish ();
                } else {
                    Toast.makeText (getContext (), message+"No email address found.", Toast.LENGTH_SHORT).show ();
                    Log.e (String.valueOf (this), value + " Not sent");
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                Toast.makeText (getContext (), "Network Error! " + t.toString (), Toast.LENGTH_SHORT).show ();
            }
        });
    }


    private void forget(){


        btn_Request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgetpassUser();


            }
        });



    }

}
