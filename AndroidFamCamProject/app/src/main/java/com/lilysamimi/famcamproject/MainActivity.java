// This page was created by Lily Samimi

package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
        Intent intent = new Intent(this, ListviewMyFamily.class);
        startActivity(intent);
        // When user clicks on Start button go to My Family page

        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor usernameText = mySharedPreferences.edit();
        usernameText.putString("Username", "Grandma Tata");
        usernameText.apply();
        // saves username so that it can be shown on Profile page
    }

    public void openSettings(View view){
    Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
        // When user clicks on Settings button go to Settings page
    }
}

