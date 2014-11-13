// This page was created by Fei Zhao

package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class profile extends Activity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences mySharedPreferences = getSharedPreferences(MY_PREFS, Activity.MODE_PRIVATE);
        String usernameText = mySharedPreferences.getString("Username", "");
        Button RECORD = (Button) findViewById(R.id.button);
            if (usernameText == "Grandma Tata") {
                RECORD.setVisibility(View.VISIBLE);
            }
            else {
                RECORD.setVisibility(View.GONE);
            }
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
