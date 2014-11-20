// This page was created by Lily Samimi

package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.SharedPreferences.Editor;
import android.content.Context;

public class MainActivity extends Activity {

    TextView name;
    public static final String MyPREFERENCES ="MyPrefs";
    public static final String Name = "nameKey";

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     //code for save the name
        name = (TextView)findViewById(R.id.editTextName);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        if (sharedpreferences.contains(Name)){
            name.setText(sharedpreferences.getString(Name,""));
        }

    }

    public void run(View view){
        String n = name.getText().toString();
        Editor editor = sharedpreferences.edit();
        editor.putString(Name,n);

        editor.apply();
    }

    //end of the save name function




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /* (save for action bar later)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    */

    public void openMyFamily(View view) {

        run(view);

        Intent intent = new Intent(this, ListviewMyFamily.class);
        startActivity(intent);
        // When user clicks on Start button go to My Family page

        /* Lily's code for sharedPreference

        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor usernameText = mySharedPreferences.edit();
        usernameText.putString("Username", "Grandma Tata");
        usernameText.apply();
        // saves username so that it can be shown on Profile page

        */



    }

    public void openSettings(View view){

    Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
        // When user clicks on Settings button go to Settings page
    }




}

