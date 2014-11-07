// This page was created by Michael Grisafe

package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    /* //save for action bar later
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

    public void openAddFamilyMember(View view) {
            Intent intent = new Intent(this, AddFamilyMembers.class);
            startActivity(intent);
        // When user clicks on Add Grandchild or Grandparent, go to Add Family page
    }

    public void openNewUser(View view) {
        Intent intent = new Intent(this, NewUserLogin.class);
        startActivity(intent);
        // When user clicks on New User, go to New User Login page
    }

    public void openMain(View view) {
        //Intent intent = new Intent(this, MainActivity.class);
       // startActivity(intent);
        // replacing this with dialog fragment

        FragmentManager fm = getFragmentManager();
        FragmentLogout testDialog = new FragmentLogout();
        testDialog.setRetainInstance(true);
        testDialog.show(fm, "Confirm Logout");
    }

}



