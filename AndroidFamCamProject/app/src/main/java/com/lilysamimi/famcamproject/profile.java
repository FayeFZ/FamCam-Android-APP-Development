// This page was created by Fei Zhao

package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class profile extends Activity {

    public static final String MyPREFERENCES ="MyPrefs";
    public static final String Name = "nameKey";

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        /*SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String usernameText = mySharedPreferences.getString("Username", "");
        Button RECORD = (Button) findViewById(R.id.button);
            if (usernameText.equals("Grandma Tata")) {
                RECORD.setVisibility(View.VISIBLE);
            }
            else {
                RECORD.setVisibility(View.GONE);
            } */


       //retrieve the name

        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String usernameText = mySharedPreferences.getString(Name, "");
        Button button = (Button) findViewById(R.id.button_record);
        if (usernameText.equals("Grandma Tata")) button.setVisibility(View.VISIBLE);
        else button.setVisibility(View.GONE);

        //end of retrieve the name


    }

    public void dispatchTakePictureIntent(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager())!= null) {
            startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.profile, menu);
        return true;
    }

    //(save for action bar later)
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

                else if (id == R.id.myProfile) {
            myProfile();
            return true;
        }
        else if (id == R.id.myFamily){
            listMyFamily();
            return true;
        }

        else if (id == R.id.logout){
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void listMyFamily() {
        Intent intent = new Intent (this, ListviewMyFamily.class);
        startActivity(intent);
    }

    public void myProfile() {
        Intent intent = new Intent (this, profile.class);
        startActivity(intent);
    }


    public void logout() {
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
   // public void openRecord(View view) {
       // Intent intent = new Intent(this, Record.class);
       // startActivity(intent);
        // When user clicks on record, go to record in android camera
   // }

    public void openMyFamily(View view) {
        Intent intent = new Intent(this, ListviewMyFamily.class);
        startActivity(intent);
        // When user clicks on My Family button, go to My Family page
    }


}
