package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class FamilyDetailActivity extends Activity {


    //define memberList
    //List<String> memberList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_detail);


        //initList();
    /*Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MyFamily.EXTRA_MESSAGE);

        int id = (int) Long.parseLong(message); */

     // create new text view


/*
        if (message == "0"){
            ImageView member1 = (ImageView) findViewById(R.id.gridview);
            member1.setImageResource(Integer.parseInt(memberList.get(0)));
        }

        else if(message == "1"){
            ImageView member2 = (ImageView) findViewById(R.id.gridview);
            member2.setImageResource(Integer.parseInt(memberList.get(1)));
        }

        */

    }

    //initial a list help us grab the member image
    /*
    private void initList(){
        memberList.add("man.gif");
        memberList.add("woman.gif");
        memberList.add("man2.gif");
        memberList.add("woman.gif");

    }
    */


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.family_detail, menu);
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
}
