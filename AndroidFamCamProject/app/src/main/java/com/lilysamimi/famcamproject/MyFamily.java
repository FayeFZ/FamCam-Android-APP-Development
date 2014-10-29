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

    // code for list view
    public final static String EXTRA_MESSAGE = "com.lilysamimi.famcamproject.MESSAGE";

    List<Map<String,String>> familyList = new ArrayList<Map<String,String>>();

    //end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_family);

        //code for list view

        registerForContextMenu((ListView) findViewById(R.id.listView));

        initList();

        ListView familyListView = (ListView) findViewById(R.id.listView);
        SimpleAdapter simpleAdpter = new SimpleAdapter(this, familyList, android.R.layout.simple_list_item_1, new String[] {"family"}, new int[] {android.R.id.text1});
        familyListView.setAdapter(simpleAdpter);

        familyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                openFamilyDetail(id);
            }
                });


        //end
    }

    // code for list view

    private void initList() {
        familyList.add(createFamily("family", "Family 1: John"));
        familyList.add(createFamily("family", "Family 2: Tata"));
        familyList.add(createFamily("family", "Family 3: Maria"));
        familyList.add(createFamily("family", "Family 4: Joe"));
    }

    private HashMap<String,String> createFamily(String key,String name){
        HashMap<String, String> family = new HashMap<String,String>();
        family.put(key, name);
        return family;
    }

    public void openFamilyDetail(long id) {
        Intent intent = new Intent(this, FamilyDetailActivity.class);
        String message = String.valueOf(id);
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

    // end


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





