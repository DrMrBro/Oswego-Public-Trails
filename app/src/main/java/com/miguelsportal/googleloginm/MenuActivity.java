package com.miguelsportal.googleloginm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Miguel on 11/6/2016.
 * Description: This is the Menu class, a menu is provided
 *  for the user to navegate.
 */

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu); //ties this class to layout_menu
    }

    public void showMenu(View view){

        //gets the button text from every button in menu
        String button_text;
        button_text = ((Button) view).getText().toString();
        System.out.println(button_text);

        /**
         * When user clicks on button, it gets the text and
         * compares it to the boolean conditionals listed below.
         * if any of the boolean conditionals matches the text
         * from button, then it opens the respective class.
         */

        if(button_text.equals("Maps")){
            Intent intent = new Intent(this, MapScreenActivity.class);
            startActivity(intent);
        }else if(button_text.equals("Trails")){
            Intent intent = new Intent(this, TrailActivity.class);
            startActivity(intent);
        }else if(button_text.equals("Weather")){
            Intent intent = new Intent(this, WeatherActivity.class);
            startActivity(intent);
        }else if(button_text.equals("Compass")){
            Intent intent = new Intent(this, CompassActivity.class);
            startActivity(intent);
        }else{
            System.out.println("Invalid Event!");
        }



    }
}
