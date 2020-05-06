package com.anwar.retrofitloginexample;

/**
 * Anwar Chowdhury
 * Date:5/2/2020
 */
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private LoginInterface loginFromActivityListener;


    private EditText edt_email, edt_password;
    private Button btn_login;
    private TextView txv_register,txv_forgetpass;
    private ImageView img_pass;

    public LoginFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);

        // for login
        edt_email = view.findViewById(R.id.edt_Email);
        edt_password = view.findViewById(R.id.edt_Password);
        btn_login = view.findViewById(R.id.btn_Login);
        txv_register = view.findViewById(R.id.txv_Register);
        txv_forgetpass = view.findViewById(R.id.txv_Forgetpass);
        img_pass= view.findViewById(R.id.img_Pass);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        txv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment signupActivity = new SignupFragment ();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, signupActivity);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        txv_forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment forgetActivity = new ForgetFragment ();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, forgetActivity);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        img_pass.setOnTouchListener(new View.OnTouchListener () {
            public boolean onTouch(View v, MotionEvent event) {

                switch ( event.getAction() ) {

                    case MotionEvent.ACTION_UP:
                        edt_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        edt_password.setSelection(edt_password.getText().length());
                        break;

                    case MotionEvent.ACTION_DOWN:
                        edt_password.setInputType(InputType.TYPE_CLASS_TEXT);
                        edt_password.setSelection(edt_password.getText().length());

                        break;

                }
                return true;
            }
        });

        return view;
    } //ending onCreateView

    private void loginUser() {
        String sEmail = edt_email.getText().toString();
        String sPassword = edt_password.getText().toString();

        if (TextUtils.isEmpty(sEmail)){
            LoginActivity.appPreference.showToast("Your email is required!");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(sEmail).matches()) {
            LoginActivity.appPreference.showToast("Invalid email");
        } else if (TextUtils.isEmpty(sPassword)){
            LoginActivity.appPreference.showToast("Password required");
        } else if (sPassword.length() < 6){
            LoginActivity.appPreference.showToast("Password  may be at least 6 characters long.");
        } else {
            Call<Users> userCall = LoginActivity.apiInterface.doLogin(sEmail, sPassword);
            userCall.enqueue(new Callback<Users>() {
                @Override
                public void onResponse(Call<Users> call, Response<Users> response) {
                    if (response.body().getResponse().equals("data")){
                        LoginActivity.appPreference.setLoginStatus(true); // set login status in sharedPreference
                        loginFromActivityListener.login(
                                response.body().getName(),
                                response.body().getId(),
                                response.body().getEmail(),
                                response.body().getMobile(),
                                response.body().getAddress (),
                                response.body().getMaplink (),
                                response.body().getCity(),
                                response.body().getCountry (),
                                response.body().getZip (),
                                response.body().getCreated_at(),
                                response.body().getToken(),
                                response.body().getType());
                    } else if (response.body().getResponse().equals("Login_failed")){
                        LoginActivity.appPreference.showToast("Error. Login Failed");
                        edt_email.setText("");
                        edt_password.setText("");
                    }
                }
                @Override
                public void onFailure(Call<Users> call, Throwable t) {
                }
            });
        }
    } //ending loginUser()

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        loginFromActivityListener = (LoginInterface) activity;
    }

}
