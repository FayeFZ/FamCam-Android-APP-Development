// This page was created by Michael Grisafe

package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyFamily extends Activity {


    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView mImageView;

    /* code for list view    10/29/14 comment out for now
    public final static String EXTRA_MESSAGE = "com.lilysamimi.famcamproject.MESSAGE";

    List<Map<String,String>> familyList = new ArrayList<Map<String,String>>();

    end */

    @Override
 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_family);

        TextView t = (TextView) findViewById(R.id.testTextView);

        t.setAllCaps(true);

    }

    public void changeColor(View view) {


           TextView t = (TextView) findViewById(R.id.testTextView);



               if(view.getId() == R.id.imageButton1){
                       t.setText("green!");
                   }
               else if(view.getId() == R.id.imageButton2){
                         t.setText("red!");
                     }
               else if(view.getId() == R.id.imageButton3) {
            t.setText("white!");
        }
               else if(view.getId() == R.id.imageButton4) {
                   t.setText("white!");
               }

    }



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









    public void openProfile(View view) {
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }
    // When user clicks on My Profile button go to my profile screen



    // camera code

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
}





