// This page was created by Michael Grisafe

package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


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

    @Override
    public void record(View view {
        Intent intent= new Intent(this, RecordActivity.class);
        startActivity(intent);
    })
        // When user clicks on record go to record screen

    @Override
    public void myProfile(View view {
        Intent intent= new Intent(this, MyProfile.class);
        startActivity(intent);
    })
    // When user clicks on MyProfle go to My Profile screen


    @Override
    public void familyImage(View view {
        Intent intent= new Intent(this, FamilyImage.class);
        startActivity(intent);
    })
    // When user clicks on any FamilyMember go to Grandma Tata Profile demo screen
}
