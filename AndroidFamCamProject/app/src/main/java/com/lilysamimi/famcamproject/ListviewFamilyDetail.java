package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ListviewFamilyDetail extends Activity {


    private void initList() {
        membersList.add("Member 1: Tata");
        membersList.add("Member 2: John");
        membersList.add("Member 3: Maria");
        membersList.add("Member 4: Hill");
    }

    List<String> membersList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_family_detail);

        initList();

        Intent intent = getIntent();
        String message = intent.getStringExtra(ListviewMyFamily.EXTRA_MESSAGE);

        int id = (int) Long.parseLong(message);

        // Create the text view
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(membersList.get(id));

        // Set the text view as the activity layout
        setContentView(textView);
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
}
