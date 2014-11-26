package com.lilysamimi.famcamproject;

import android.app.Activity;
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


public class ChildrenProfile extends Activity {

    //code for cam22
    Button btnTakePhoto;
    ImageView imgTakenPhoto;
    private  static final int CAM_REQUEST = 1313;
    //end

    public static final String MyPREFERENCES ="MyPrefs";
    public static final String Name = "nameKey";

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_children_profile);

        //code for cam22
        btnTakePhoto = (Button)findViewById(R.id.button_camera);
        imgTakenPhoto=(ImageView)findViewById(R.id.image_camera);

        btnTakePhoto.setOnClickListener(new btnTakePhotoClicker());

        //retrieve the name

        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String usernameText = mySharedPreferences.getString(Name, "");
        Button button = (Button) findViewById(R.id.button_camera);
        if (usernameText.equals("Grandma Tata")) button.setVisibility(View.VISIBLE);
        else button.setVisibility(View.GONE);

        //end of retrieve the name

    }

    //code for cam method 2
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == CAM_REQUEST){
            Bitmap thumbnail = (Bitmap)data.getExtras().get("data");
            imgTakenPhoto.setImageBitmap(thumbnail);
        }
    }

    class btnTakePhotoClicker implements Button.OnClickListener{
        @Override
        public void onClick(View v){
            Intent cameraintent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraintent,CAM_REQUEST);
        }
    }

    //end


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.children_profile, menu);
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
