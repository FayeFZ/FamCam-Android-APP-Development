package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import java.util.List;


public class Member1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.member1, menu);
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
    // Intent intent = new Intent(this, Record.class);
    // startActivity(intent);
    // When user clicks on Record button, open record
    //}

   void populateImageArray() {
       String[] images;
       images[0] = "man.gif";
       images[1] = "woman.gif";
       images[2] = "woman2.gif";
       images[3] = "man2.gif";
   }

    public void changeImage (View view) {
        ImageView i = (ImageView) findViewById(R.id.)

        if (view.getId() == R.id.imageButton1) {
           getIntent(0);
        }
        else if (view.getId() == R.id.imageButton2) {
            getIntent(1)
        }
        else if (view.getId() == R.id.imageButton3) {
            getIntent(1)
        }
        else (view.getId() == R.id.imageButton4) {
            getIntent(3)
        }
    }



    public void openMyFamily(View view) {
        Intent intent = new Intent(this, MyFamily.class);
        startActivity(intent);
        // When user clicks on My Family button, go to My Family page
    }
}