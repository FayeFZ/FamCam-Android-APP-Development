// This page was created by Fei Zhao

package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;



public class profile extends Activity {

    /*//code for camera
    private static String logtag ="CameraProfile";
    private static int TAKE_PICTURE =1;
    private Uri imageUri;
    //end*/

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
        setContentView(R.layout.activity_profile);


       /* //code for camera dec
        Button cameraButton = (Button)findViewById(R.id.button_camera);

        cameraButton.setOnClickListener(cameraListener);

        //end */
        //code for cam22
       btnTakePhoto = (Button)findViewById(R.id.button_camera);
        imgTakenPhoto=(ImageView)findViewById(R.id.image_camera);

        btnTakePhoto.setOnClickListener(new btnTakePhotoClicker());

        //end

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

    /*//code for camera new thanksgiving

    private View.OnClickListener cameraListener = new View.OnClickListener(){
        public void onClick(View v){
            takePhoto(v);
        }
    };

    private void takePhoto(View v){
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        File photo = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"picture.jpg");
        imageUri = Uri.fromFile(photo);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        startActivityForResult(intent,TAKE_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent intent) {
        super.onActivityResult(requestCode,resultCode,intent);

        if(resultCode == Activity.RESULT_OK){
            Uri selectedImage = imageUri;
            getContentResolver().notifyChange(selectedImage,null);

            ImageView imageView = (ImageView)findViewById(R.id.image_camera);
            ContentResolver cr = getContentResolver();
            Bitmap bitmap;

            try {
                bitmap = MediaStore.Images.Media.getBitmap(cr,selectedImage);
                imageView.setImageBitmap(bitmap);
                Toast.makeText(profile.this,selectedImage.toString(),Toast.LENGTH_LONG).show();

            } catch (Exception e){
                Log.e(logtag,e.toString());
            }
        }
    }

    //end */


    
/* old camera code (still work but can't save the picture

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
    }*/


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
