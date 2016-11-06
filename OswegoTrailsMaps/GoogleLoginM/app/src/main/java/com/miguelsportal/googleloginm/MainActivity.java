package com.miguelsportal.googleloginm;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by Miguel on 11/6/2016.
 * Description: This is the Main class of this project, it
 *  implements the Google login and lets the user sign in
 *  with their existing Google account. If the user fails to
 *  provide a Google account then it allows the user to
 *  create one. Any data from the users account can be gather
 *  and save to a database or a .txt file.
 */

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    private static final int REQUEST_CODE = 100;
    private SignInButton login;        //Implements Google Sign In
    private TextView name;
    private GoogleApiClient googleApiClient; //Implements Google Sign In
    private GoogleSignInOptions signInOptions; //Implements Google Sign In

    private String fullName;      //contains users full name or account name
    private Button proceed;       //this is button proceed
    private String email;         //acquires the users email
    private Button proceedLand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //attaches this class to layout activity_main

        signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();
        login = (SignInButton) findViewById(R.id.login);
        name = (TextView) findViewById(R.id.name);
        proceed = (Button)findViewById(R.id.button); //attaches the proceed button to the button in layout
        proceedLand = (Button)findViewById(R.id.button2); //Landscape layout

        /**
         * Leave this comment out for now
         */
//        proceed.setClickable(false); //disables the button proceed clickability on start
//        proceed.setEnabled(false);   //disables the button proceed
//        proceedLand.setEnabled(false);
//        proceedLand.setClickable(false);

        login.setSize(SignInButton.SIZE_WIDE);
        login.setScopes(signInOptions.getScopeArray());

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(signInIntent, REQUEST_CODE);
            }
        });

    }

    //Implements Google Sign In
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            GoogleSignInAccount account = result.getSignInAccount();

                //catches a NullPointerException just in case
                try {

                    /**
                     * Here is where we get the users info
                     */

                    //gets the users display name from account
                    fullName = account.getDisplayName();

                    //gets the users email address from account
                    email = account.getEmail();

                    //Greets the user after successfully sign in
                    String greetin = "Welcome ";
                    String OswegoTrails = ", Access Granted. Please Click Proceed";
                    String speech = greetin+ fullName + OswegoTrails;
                    name.setText(speech);
                    System.out.println(fullName);

                    /**
                     * If the variable fullName is empty then do nothing
                     * else enable the button proceed so is clikable
                     */
                    if(fullName == null){

                        System.out.println("Please sign in first!");
                    }
                    else{

                        System.out.println("Proceed");

                        //enables proceed button
                        proceed.setClickable(true);
                        proceed.setEnabled(true);
                    }
                }catch(NullPointerException e){
                    e.printStackTrace();
                }
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    /**
     * Ends Google Sign In Implementation
     * @param view
     */

    public void showMenu(View view){

        //gets the text from all buttons
        String button_text;
        button_text = ((Button) view).getText().toString();
        System.out.println(button_text);

        /**
         * if the button's text is 'proceed' please open MenuActivity class
         */
        if(button_text.equals("Proceed")){
                Intent intent = new Intent(this, MenuActivity.class);
                startActivity(intent);
            }

    }



}