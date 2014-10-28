// This page was created by Michael Grisafe

package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;


public class MyFamily extends Activity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_family);
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





