package com.anwar.retrofitloginexample;
/**
 * Anwar Chowdhury
 * Date:5/2/2020
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;




/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    private TextView txv_name, txv_email,txv_mobile;
    private Button btn_logout,btn_show,btn_update;
    private Button btn_signup;
    LoginInterface logoutListener;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        txv_email = view.findViewById(R.id.txv_Email);
        txv_name = view.findViewById(R.id.txv_Name);
        txv_mobile = view.findViewById(R.id.txv_Mobile);
        btn_signup =view.findViewById(R.id.btn_Signup);


        String Name = "Welcome!\n" + LoginActivity.appPreference.getName();
        String Email = LoginActivity.appPreference.getEmail();
        String Mobile = LoginActivity.appPreference.getMobile ()
                +"\n ID :"+ LoginActivity.appPreference.getId ()
                +"\n city :"+ LoginActivity.appPreference.getCity ()
                +"\n Registered at : " + LoginActivity.appPreference.getCreDate()
                +"\n token : " + LoginActivity.appPreference.getToken()
                +"\n type : " + LoginActivity.appPreference.getType();
        txv_name.setText(Name);
        txv_email.setText(Email);
        txv_mobile.setText(Mobile);

        insert();
        //Log.e("created_at: ", c_date);
if (LoginActivity.appPreference.getType ().equals ("customer")){
    btn_signup.setVisibility(View.GONE);
    btn_logout = view.findViewById(R.id.btn_Logout);
    btn_logout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            logoutListener.logout();
        }
    });

    btn_show = view.findViewById(R.id.btn_Showinfo);
    btn_show.setVisibility(View.GONE);
    btn_show.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // TODO Auto-generated method stub
            Intent i = new Intent(getContext (), ReadusersFragment.class);
            startActivity(i);
        }
    });

    btn_update = view.findViewById(R.id.btn_Update);
    btn_update.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment updatefragment = new UpdateFragment ();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, updatefragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    });
}
else  {
    btn_logout = view.findViewById(R.id.btn_Logout);
    btn_logout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            logoutListener.logout();
        }
    });

    btn_show = view.findViewById(R.id.btn_Showinfo);
    btn_show.setVisibility(View.VISIBLE);
    btn_show.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // TODO Auto-generated method stub
            Fragment readuserFragment = new ReadusersFragment ();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, readuserFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    });
    btn_update = view.findViewById(R.id.btn_Update);
    btn_update.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Fragment updatefragment = new UpdateFragment ();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, updatefragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    });


    }




        return view;
    } // ending onCreateView


    private void insert(){

        btn_signup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // TODO  go to signup  activity
                Intent i = new Intent(getContext(), AdminsignupActivity.class);
                startActivity(i);
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
