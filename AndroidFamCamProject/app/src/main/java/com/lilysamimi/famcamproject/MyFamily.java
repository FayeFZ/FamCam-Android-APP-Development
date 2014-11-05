// This page was created by Michael Grisafe

package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

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

    //end */

    @Override
 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_family);

        //code for grid view

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MyFamily.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });


        /*code for list view

        //registerForContextMenu((ListView) findViewById(R.id.listView));

        initList();

        ListView familyListView = (ListView) findViewById(R.id.listView);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                familyList, android.R.layout.simple_list_item_1,
                new String[] {"family"},
                new int[] {android.R.id.text1});

        familyListView.setAdapter(simpleAdapter);

        familyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                openFamilyDetail(id);
            }
                });


        //end */
    }

    //code for grid view

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context context) {
            mContext = context;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return 0;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        //create a new ImageView for each item referenced by the Adapter

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null){
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(300,300));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8,8,8,8);
            }
            else{
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

        private Integer[] mThumbIds = {
                R.drawable.man, R.drawable.woman,
                R.drawable.man2, R.drawable.woman2
        };
    }


    /* code for list view

    private void initList() {
        familyList.add(createFamily("family", "Family 1: John"));
        familyList.add(createFamily("family", "Family 2: Tata"));
        familyList.add(createFamily("family", "Family 3: Maria"));
        familyList.add(createFamily("family", "Family 4: Joe"));
    }

        TextView t = (TextView) findViewById(R.id.testTextView);

        t.setAllCaps(true);

    }

    public void changeColor(View view) {



           TextView t = (TextView) findViewById(R.id.testTextView);

   // end */


    /*


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

    */



    //public void openRecord(View view) {
    //Intent intent = new Intent(this, Record.class);
    //startActivity(intent);
    // When user clicks on record go to record screen
    //}


    /*
    public void openMember1(View view) {
        Intent intent = new Intent(this, Member1.class);
        startActivity(intent);
    }
    // When user clicks on Member1 image go to Member 1 profile screen







    */

    /*

    public void openProfile(View view) {
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }
    // When user clicks on My Profile button go to my profile screen

    */

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





