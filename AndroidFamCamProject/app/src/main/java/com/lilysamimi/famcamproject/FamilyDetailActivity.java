package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


public class FamilyDetailActivity extends Activity {

    //code for list view
    ArrayList familyList = new ArrayList<String>();
    //end

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_detail);

    //code for list view
        initList();

        Intent intent = getIntent();
        String message = intent.getStringExtra(MyFamily.EXTRA_MESSAGE);

        int id = (int) Long.parseLong(message);

        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText((Integer) familyList.get(id));

        setContentView(textView);
    //end
    }

    //code for list view
    private void initList(){
        familyList.add("Family 1");
        familyList.add("Family 2");
        familyList.add("Family 3");
        familyList.add("Family 4");
    }
    //end

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
