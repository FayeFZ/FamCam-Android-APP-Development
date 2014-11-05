package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ListviewMyFamily extends Activity {

    public final static String EXTRA_MESSAGE = "com.lilysamimi.famcamproject.MESSAGE";

    List<Map<String, String>> membersList = new ArrayList<Map<String,String>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_my_family);

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

    }

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
}
