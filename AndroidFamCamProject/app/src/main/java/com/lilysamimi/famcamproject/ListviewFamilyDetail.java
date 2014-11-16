package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ListviewFamilyDetail extends Activity {




    private void initList() {
        membersList.add("Grandma Tata");
        membersList.add("Grandpa John");
        membersList.add("Maria");
        membersList.add("Edgar");
    }

    List<String> membersList = new ArrayList<String>();

    private void intheList() {
        description.add("Love cooking for my family :D");
        description.add("I want to go fishing!");
        description.add("Looking forward to Christmas");
        description.add("Watching football game");
    }

    List<String> description = new ArrayList<String>();

    private void inList() {

        array_image.add(R.drawable.man);
        array_image.add(R.drawable.woman);
        array_image.add(R.drawable.man2);
        array_image.add(R.drawable.woman2);
    }

    ArrayList<Integer> array_image = new ArrayList<Integer>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_family_detail);


        initList();
        inList();
        intheList();


        Intent intent = getIntent();
        String message = intent.getStringExtra(ListviewMyFamily.EXTRA_MESSAGE);

        int id = (int) Long.parseLong(message);

        //create the text view

        TextView textView=(TextView)findViewById(R.id.txt);

        textView.setText(membersList.get(id));

        TextView descriptions=(TextView)findViewById(R.id.des);

        descriptions.setText(description.get(id));

        //create the image view

        ImageView imageView=(ImageView)findViewById(R.id.img);

        imageView.setImageResource(array_image.get(id));

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.listview_family_detail, menu);
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

    public void openMyFamily(View view) {
        Intent intent = new Intent(this, ListviewMyFamily.class);
        startActivity(intent);
        // When user clicks on My Family button, go to My Family page
    }
}
