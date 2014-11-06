package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.app.FragmentManager;


public class NewUserLogin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_login);

        FragmentManager fm = getFragmentManager();
        TestDialog testDialog = new TestDialog();
        testDialog.setRetainInstance(true);
        testDialog.show(fm, "fragment_name");


        // I inserted the code above to add the fragment to this screen.- Mike



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.new_user_login, menu);
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

    public void openMakeProfile (View view) {
        Intent intent = new Intent(this, MakeProfile.class);
        startActivity(intent);
        // When user clicks on Submit button, go to Make Profile page
    }





}
