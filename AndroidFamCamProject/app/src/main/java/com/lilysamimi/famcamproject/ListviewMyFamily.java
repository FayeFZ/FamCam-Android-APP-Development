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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListviewMyFamily extends Activity {

     public final static String EXTRA_MESSAGE = "com.lilysamimi.famcamproject.MESSAGE";

    // code for camera
    static final int REQUEST_IMAGE_CAPTURE = 1;
     private ImageView mImageView;

   // code for teamivore listview, we have images, so comment it out
   // List<Map<String, String>> membersList = new ArrayList<Map<String,String>>();




    //add names
    String[] members = new String[]{
            "Grandma Tata",
            "Grandpa John",
            "Maria",
            "Edgar"
    };

    //add images

    int[] images = new int[]{
            R.drawable.man,
            R.drawable.woman,
            R.drawable.man2,
            R.drawable.woman2
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_my_family);

        SharedPreferences mySharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String usernameText = mySharedPreferences.getString("Username", "");
        Button RECORD = (Button) findViewById(R.id.button);
        if (usernameText == "Grandma Tata") {
            RECORD.setVisibility(View.VISIBLE);
        }
        else {
            RECORD.setVisibility(View.GONE);
        }

        //Mike- Hey Lily, I added the shared preferences that were located in profile here so that it affected if the
        //record button was on or off on the main landing page.  However, this still doesn't seem to be pulling the user entered
        //text from the textview "userNameText"... Right now the "RECORD" is just always gone, so it is understanding
        // the if statement as false.  I think we need something that pulls the text from there
        //with something like you have for the record button "findViewById(R.id.userNameText" and use this in the main shared
        //preferences in the "MainActivity" java.  I am also not sure if the sharedpreferences in MainActivity java should be
        //housed in "onCreate".  So many questions...

        //Each row in the list stores member and images
        List<HashMap<String,String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i=0;i<4;i++){
            HashMap<String,String> hm = new HashMap<String, String>();
            hm.put("txt","" + members[i]);
            hm.put("image",Integer.toString(images[i]));
            aList.add(hm);
        }

        String[] from = {"image","txt"};

        int[] to = {R.id.image,R.id.txt};

        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(),aList,R.layout.single_row,from,to);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                openFamilyDetail(id);

            }
        });


        /*  code for Teamivore list view, no image, comment it out

        registerForContextMenu((ListView) findViewById(R.id.listView));

        initList();

        ListView teamListView = (ListView) findViewById(R.id.listView);
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, membersList, android.R.layout.simple_list_item_1, new String[] {"member"}, new int[] {android.R.id.text1});
        teamListView.setAdapter(simpleAdpt);

        teamListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                openFamilyDetail(id);
            }
        });
        */

    }


/* code for teamivore list view, no image, comment it out
    private void initList() {
        membersList.add(createMember("member", "Member 1: Tata"));
        membersList.add(createMember("member", "Member 2: John"));
        membersList.add(createMember("member", "Member 3: Maria"));
        membersList.add(createMember("member", "Member 4: Hill"));
    }

    private HashMap<String, String> createMember(String key, String name) {
        HashMap<String, String> member = new HashMap<String, String>();
        member.put(key, name);
        return member;
    }

*/


    public void openFamilyDetail(long id) {
        Intent intent = new Intent(this, ListviewFamilyDetail.class);
        String message = String.valueOf(id);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.listview_my_family, menu);
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




    // code for open my profile

    public void openProfile(View view) {
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }

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
