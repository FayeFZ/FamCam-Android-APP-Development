// This page was created by Michael Grisafe

package com.lilysamimi.famcamproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //In the onCreate, I linked the logout button to a onclickListener. When you click the button,
        // it will do the showDialog() method

        Button button = (Button) findViewById(R.id.logout);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    //now define the showDialog method: I create a new DialogFragment with the title string
    // "are you sure you want to log out?" This new Fragment will show a dialog

    void showDialog() {
        DialogFragment newFragment = LogoutDialogFragment
                .newInstance(R.string.Logout_dialog_two_buttons_title);
        newFragment.show(getFragmentManager(), "dialog");
    }

    //here it defined the positive click method, when you click ok, it will open MainActivity class, the log is to record what user do

    public void doPositiveClick() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Log.i("FamCamProject", "Positive click!");
    }

    //here it defined the negative click, when you click no, it go back and do nothing, the log is to record what user do

    public void doNegativeClick() {
        Log.i("FamCamProject", "Negative click!");
    }


    //this logout dialogFragment class is extends from the dialogFragment class

    public static class LogoutDialogFragment extends DialogFragment {

        //here it defined the logoutFragment method, and a new frag method, the new frag method is put the title "are you sure you want to logout?"
        // in the dialog fragment

        public static LogoutDialogFragment newInstance(int title) {
            LogoutDialogFragment frag = new LogoutDialogFragment();
            Bundle args = new Bundle();
            args.putInt("title", title);
            frag.setArguments(args);
            return frag;
        }

        //here it created a new onCreate thing, it shows what will happen when it runs

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            int title = getArguments().getInt("title");

            //AlertDialog is a android build in method,it help you build the alertDialog, the alert dialog has three parts:
            //1. title; 2. Yes Button, when clicked, it will do the doPositiveClick method which we defined on the top.
            //3. No button, when click, it will do the doNegativeClick method
            
            return new AlertDialog.Builder(getActivity())
                    .setTitle(title)
                    .setPositiveButton(R.string.Logout_dialog_yes,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int whichButton) {
                                    ((SettingsActivity) getActivity())
                                            .doPositiveClick();
                                }
                            })
                    .setNegativeButton(R.string.Logout_dialog_cancel,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int whichButton) {
                                    ((SettingsActivity) getActivity())
                                            .doNegativeClick();
                                }
                            }).create();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    /* //save for action bar later
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

    public void openAddFamilyMember(View view) {
            Intent intent = new Intent(this, AddFamilyMembers.class);
            startActivity(intent);
        // When user clicks on Add Grandchild or Grandparent, go to Add Family page
    }

    public void openNewUser(View view) {
        Intent intent = new Intent(this, NewUserLogin.class);
        startActivity(intent);
        // When user clicks on New User, go to New User Login page
    }

   /* now we have dialog to ask if they are sure to log out

    public void openMain(View view) {
        //Intent intent = new Intent(this, MainActivity.class);
       // startActivity(intent);
        // replacing this with dialog fragment

        FragmentManager fm = getFragmentManager();
        FragmentLogout testDialog = new FragmentLogout();
        testDialog.setRetainInstance(true);
        testDialog.show(fm, "Confirm Logout");
    }

    */

}



