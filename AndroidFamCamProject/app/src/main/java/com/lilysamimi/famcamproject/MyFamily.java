// This page was created by Michael Grisafe

package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;


public class MyFamily extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_family);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_family, menu);
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

    //public void openRecord(View view) {
        //Intent intent = new Intent(this, Record.class);
        //startActivity(intent);
        // When user clicks on record go to record screen
    //}

    public void openMember1(View view) {
        Intent intent = new Intent(this, Member1.class);
        startActivity(intent);
    }
    // When user clicks on Member1 image go to Member 1 profile screen

    public void openMember2(View view) {
        Intent intent = new Intent(this, Member2.class);
        startActivity(intent);
    }
    // When user clicks on Member2 image go to Member 2 profile screen

    public void openMember3(View view) {
        Intent intent = new Intent(this, Member3.class);
        startActivity(intent);
    }
    // When user clicks on Member3 image go to Member3 profile screen

public void openMember4(View view) {
        Intent intent = new Intent(this, Member4.class);
        startActivity(intent);
    }
    // When user clicks on Member4 image go to Member 4 profile screen

    public void openProfile(View view) {
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }
    // When user clicks on My Profile button go to my profile screen

}





